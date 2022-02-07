package com.allenyang.wowauctionassistant.config;

import javax.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

/**
 * @author yilunyang
 * @date 2/7/2022
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "blizzard")
@Data
public class BlizzardConfig {
  private String locale;

  @Autowired
  private BlizzardApiAccessConfig apiAccessConfig;

  @Configuration
  @ConfigurationProperties(prefix = "api.access")
  @Data
  public static class BlizzardApiAccessConfig {
    public static final String CLIENT_ID_ENVIRONMENT_VARIABLE_NAME = "BLIZZARD_CLIENT_ID";
    public static final String CLIENT_SECRET_ENVIRONMENT_VARIABLE_NAME = "BLIZZARD_CLIENT_SECRET";

    private String clientId;
    private String clientSecret;

    @PostConstruct
    public void init(){
      clientId = System.getenv(CLIENT_ID_ENVIRONMENT_VARIABLE_NAME);
      Assert.notNull(clientId, String.format("Environment Variable %s must be specified.", CLIENT_ID_ENVIRONMENT_VARIABLE_NAME));
      Assert.hasText(clientId, String.format("Environment Variable %s must be specified.", CLIENT_ID_ENVIRONMENT_VARIABLE_NAME));

      clientSecret = System.getenv(CLIENT_SECRET_ENVIRONMENT_VARIABLE_NAME);
      Assert.notNull(clientSecret, String.format("Environment Variable %s must be specified.", CLIENT_SECRET_ENVIRONMENT_VARIABLE_NAME));
      Assert.hasText(clientSecret, String.format("Environment Variable %s must be specified.", CLIENT_SECRET_ENVIRONMENT_VARIABLE_NAME));
    }
  }
}
