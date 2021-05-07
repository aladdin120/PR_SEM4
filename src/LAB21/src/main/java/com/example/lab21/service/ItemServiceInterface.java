package com.example.lab21.service;

import com.example.lab21.entities.Item;

import java.util.List;

public interface ItemServiceInterface {

    List<Item> getAllItems();
    List<Item> getItemsFilteredByName();
    List<Item> getItemsFilteredByDate();
    List<Item> getItemsFilteredByPrice();
    void addItem(Item item);
}
