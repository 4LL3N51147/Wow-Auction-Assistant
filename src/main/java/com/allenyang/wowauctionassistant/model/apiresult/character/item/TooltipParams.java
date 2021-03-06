package com.allenyang.wowauctionassistant.model.apiresult.character.item;

import lombok.Data;

@Data
public class TooltipParams {
    private Long transmogItem;
    private Integer timewalkerLevel;
    private Long azeritePower0, azeritePower1, azeritePower2, azeritePower3;
    private Integer azeritePowerLevel;
}
