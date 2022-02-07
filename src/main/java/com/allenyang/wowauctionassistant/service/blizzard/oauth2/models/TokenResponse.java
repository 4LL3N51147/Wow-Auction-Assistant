package com.allenyang.wowauctionassistant.service.blizzard.oauth2.models;

import lombok.Data;

/**
 * @author yilunyang
 * @date 2/7/2022
 */
@Data
public class TokenResponse {
  /**
   * The access token used on future requests to the API.
   */
  private String access_token;
  private String token_type;
  /**
   * Seconds from when received that the token will expire.
   */
  private Long expires_in;
}
