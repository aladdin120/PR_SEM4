package com.example.lab20.service;

import com.example.lab20.entities.Item;

import java.util.List;

public interface ItemServiceInterface {

    List<Item> getAllItems();
    List<Item> getItemsFilteredByName();
    List<Item> getItemsFilteredByDate();
    List<Item> getItemsFilteredByPrice();
}
