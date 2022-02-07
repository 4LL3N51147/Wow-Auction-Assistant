package com.allenyang.wowauctionassistant.model.apiresult.character.guild;

import lombok.Data;

@Data
public class GuildEmblem {
    private Integer icon;
    private String iconColor;               // hex
    private Integer iconColorId;
    private Integer border;
    private String borderColor;             // hex
    private Integer borderColorId;
    private String backgroundColor;         // hex
    private Integer backgroundColorId;
}
