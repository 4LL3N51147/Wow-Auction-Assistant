package com.allengcc.wowauctionassistant.repository;

import com.allengcc.wowauctionassistant.entity.Item;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface ItemRepository extends Repository<Item, String> {
  List<Item> findById(String id);

  List<Item> findByName(String name);

  List<Item> findByPriceBetween(Integer min, Integer max);
}
