package com.allenyang.wowauctionassistant.model.apiresult;

import com.allenyang.wowauctionassistant.model.apiresult.character.Guild;
import com.allenyang.wowauctionassistant.model.apiresult.character.Items;
import lombok.Data;

/**
 * @author yilunyang
 * @date 2/7/2022
 */
@Data
public class CharacterItemsGuild extends Character {
  private Items items;
  private Guild guild;
}
