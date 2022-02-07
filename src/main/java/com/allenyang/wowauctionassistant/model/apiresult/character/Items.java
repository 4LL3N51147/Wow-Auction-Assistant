package com.allenyang.wowauctionassistant.model.apiresult.character;

import com.allenyang.wowauctionassistant.model.apiresult.character.item.Item;
import lombok.Data;

/**
 * @author yilunyang
 * @date 2/7/2022
 */
@Data
public class Items {
  private Integer averageItemLevel, averageItemLevelEquipped;
  private Item head, neck, shoulder, back, chest, shirt, tabard, wrist, hands, waist, legs, feet, finger1, finger2,
      trinket1, trinket2, mainHand, offHand;
}
