package com.example.lab24.service;

import com.example.lab24.entities.Item;

import java.util.List;

public interface ItemServiceInterface {

    List<Item> getAllItems();
    List<Item> getItemsFilteredByName();
    List<Item> getItemsFilteredByDate();
    List<Item> getItemsFilteredByPrice();
    void addItem(Item item);
}
