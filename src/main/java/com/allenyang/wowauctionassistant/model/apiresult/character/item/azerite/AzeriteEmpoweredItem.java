package com.allenyang.wowauctionassistant.model.apiresult.character.item.azerite;

import lombok.Data;

import java.util.Collection;

/**
 * @author yilunyang
 */
@Data
public class AzeriteEmpoweredItem {
    private Collection<AzeritePower> azeritePowers;
}
