package com.allenyang.wowauctionassistant.model.apiresult;

import java.util.Collection;
import lombok.Data;

/**
 * @author yilunyang
 * @date 2/7/2022
 */
@Data
public class ClassName {
  private Object _links;
  private Integer id;
  private String name;
  private Object genderName;
  private Object powerType;
  private Collection<Object> specializations;
  private Object media;
  private Object pvpTalentSlots;
}
