package com.example.lab23.service;

import com.example.lab23.entities.Item;
import com.example.lab23.repos.ItemRepository;
import com.example.lab23.service.EmailService;
import com.example.lab23.service.ItemServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService implements ItemServiceInterface {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    EmailService emailService;

    @Transactional
    @Override
    public List<Item> getAllItems() {
        log.info("Starting the service getAllItems");
        return itemRepository.findAll();
    }

    @Transactional
    @Override
    public List<Item> getItemsFilteredByName() {
        log.info("Starting the service getItemsFiletredByName");
        return itemRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Transactional
    @Override
    public List<Item> getItemsFilteredByDate() {
        log.info("Starting the service getItemsFilteredByDate");
        return itemRepository.findAll(Sort.by(Sort.Direction.ASC, "creationDate"));
    }

    @Transactional
    @Override
    public List<Item> getItemsFilteredByPrice() {
        log.info("Starting the service getItemsFilteredByPrice");
        return itemRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
    }

    @Transactional
    @Override
    public void addItem(Item item) {
        log.info("Starting the service addItem");
        emailService.sendMessage(item.toString());
        itemRepository.save(item);
    }

}
