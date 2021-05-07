package com.example.lab20.service;

import com.example.lab20.entities.Item;
import com.example.lab20.repos.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService implements ItemServiceInterface{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        log.info("Starting the service getAllItems");
        return itemRepository.findAll();
    }

    @Override
    public List<Item> getItemsFilteredByName() {
        log.info("Starting the service getItemsFiletredByName");
        return itemRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public List<Item> getItemsFilteredByDate() {
        log.info("Starting the service getItemsFilteredByDate");
        return itemRepository.findAll(Sort.by(Sort.Direction.ASC, "creationDate"));
    }

    @Override
    public List<Item> getItemsFilteredByPrice() {
        log.info("Starting the service getItemsFilteredByPrice");
        return itemRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
    }

}
