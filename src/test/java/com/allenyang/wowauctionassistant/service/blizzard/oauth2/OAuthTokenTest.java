package com.allenyang.wowauctionassistant.service.blizzard.oauth2;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yilunyang
 * @date 2/7/2022
 */
@SpringBootTest
public class OAuthTokenTest {

  @Autowired
  private OAuth2TokenService handler;

  @Test
  void GetTokenTest() throws IOException {
    String token = handler.getToken();
    Assertions.assertNotNull(token);
  }
}
