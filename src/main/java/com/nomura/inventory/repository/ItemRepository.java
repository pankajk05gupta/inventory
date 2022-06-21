package com.nomura.inventory.repository;

import com.nomura.inventory.model.Item;

import java.util.List;

public interface ItemRepository {

    int count();
    int save(Item item);
    List<Item> getAllItem();

}
