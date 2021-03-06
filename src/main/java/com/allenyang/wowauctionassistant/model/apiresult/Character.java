package com.allenyang.wowauctionassistant.model.apiresult;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * @author yilunyang
 * @date 2/7/2022
 */
@Data
@Log4j2
public class Character {
  private Long lastModified;
  private String name;
  private String realm;
  private String battlegroup;

  @JsonProperty(value = "class")
  private Integer classId;

  private Integer race;
  private Integer gender;
  private Integer level;
  private Integer achievementPoints;
  private String thumbnail;
  @JsonProperty(value="calcClass")
  private String localizedClassName;
  private Integer faction;
  private Integer totalHonorableKills;
}
