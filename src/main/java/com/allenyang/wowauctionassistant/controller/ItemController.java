package com.allenyang.wowauctionassistant.controller;

import com.allenyang.wowauctionassistant.entity.item.Item;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yilunyang
 * @date 2/7/2022
 */
@Slf4j
@Controller
@RequestMapping("/items")
public class ItemController {

  @GetMapping
  public String getItemLists(Model model) {
    List<Item> items = new ArrayList<>();
    return "1";
  }
}
