package com.allenyang.wowauctionassistant.service.blizzard.client;

import com.allenyang.wowauctionassistant.service.blizzard.oauth2.OAuth2TokenService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yilunyang
 * @date 2/7/2022
 */
public class BlizzardClientServiceImpl implements BlizzardClientService {

  @Autowired
  private OAuth2TokenService tokenService;

  @Override
  public String getItemClassIndex() {
    return null;
  }


}
