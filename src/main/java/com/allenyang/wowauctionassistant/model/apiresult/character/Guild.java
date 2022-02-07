package com.allenyang.wowauctionassistant.model.apiresult.character;

import com.allenyang.wowauctionassistant.model.apiresult.character.guild.GuildEmblem;
import lombok.Data;

/**
 * @author yilunyang
 * @date 2/7/2022
 */
@Data
public class Guild {
  private String name;
  private String realm;
  private String battlegroup;
  private Integer members;
  private Integer achievementPoints;
  private GuildEmblem emblem;
}
