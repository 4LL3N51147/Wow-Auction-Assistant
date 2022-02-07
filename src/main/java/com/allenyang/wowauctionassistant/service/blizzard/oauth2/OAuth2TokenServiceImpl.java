package com.allenyang.wowauctionassistant.service.blizzard.oauth2;

import com.allenyang.wowauctionassistant.service.blizzard.oauth2.models.TokenResponse;
import com.allenyang.wowauctionassistant.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.allenyang.wowauctionassistant.config.BlizzardConfig;
import java.io.IOException;
import java.time.Instant;
import java.util.Base64;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yilunyang
 * @date 2/7/2022
 */
@Service
@Log4j2
public class OAuth2TokenServiceImpl implements OAuth2TokenService {

  private BlizzardConfig blizzardConfig;

  private ObjectMapper objectMapper;

  private String token;
  private Instant tokenExpiry; // Instant when the token will expire
  private final Object tokenLock;

  @Autowired
  public OAuth2TokenServiceImpl(BlizzardConfig blizzardConfig, ObjectMapper objectMapper) {
    this.blizzardConfig = blizzardConfig;
    this.objectMapper = objectMapper;
    this.token = null;
    this.tokenExpiry = null;
    this.tokenLock = new Object();
  }

  @Override
  public String getToken() throws IOException {
    HttpClient httpClient = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost(Constants.OAUTH_TOKEN_URL);

    String clientId = blizzardConfig.getApiAccessConfig().getClientId();
    String clientSecret = blizzardConfig.getApiAccessConfig().getClientSecret();
    String encodedCredential = Base64.getEncoder().encodeToString((clientId+":"+clientSecret).getBytes());
    log.info("Building OAuth Token Request with client_id:[{}] and client_secret:[{}]", clientId, clientSecret);
    httpPost.addHeader("Authorization", "Basic "+ encodedCredential);

    HttpEntity entity = MultipartEntityBuilder
        .create()
        .addTextBody("grant_type", "client_credentials")
        .build();
    httpPost.setEntity(entity);

    String responseStr = StringUtils.EMPTY;
    try {
      HttpResponse response = httpClient.execute(httpPost);
      responseStr = EntityUtils.toString(response.getEntity(), "utf-8");
      log.info("request token succeeded with response " + responseStr);
    }
    catch (IOException e) {
      log.warn("failed to make oauth2 token request");
      e.printStackTrace();
    }
    catch (ParseException e) {
      log.warn("failed to parse oauth2 token request response");
      e.printStackTrace();
    }

    TokenResponse tokenResponse = objectMapper.readValue(responseStr, TokenResponse.class);
    synchronized (tokenLock) {
      tokenExpiry = Instant.now().plusSeconds(tokenResponse.getExpires_in());
      token = tokenResponse.getAccess_token();
      return token;
    }
  }

  @Override
  public boolean isTokenInvalid(){
    synchronized (tokenLock) {
      if (token == null) {
        return true;
      }
      if (tokenExpiry == null) {
        return true;
      }
      return Instant.now().isAfter(tokenExpiry);
    }
  }
}
