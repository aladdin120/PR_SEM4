package com.example.lab24.service;

import com.example.lab24.email.EmailService;
import com.example.lab24.entities.Item;
import com.example.lab24.repos.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ItemServiceImplTest {

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private EmailService emailService;

    @Captor
    ArgumentCaptor<Item> captor;

    @Test
    void getAllItems() {
        Item item1 = new Item();
        item1.setName("item1");
        item1.setPrice("100");
        Item item2 = new Item();
        item2.setName("item2");
        item2.setPrice("200");

        Mockito.when(itemRepository.findAll())
                .thenReturn(List.of(item1, item2));
        ItemService itemService = new ItemService(itemRepository);
        assertEquals(2, itemService.getAllItems().size());
        assertEquals("item1", itemService.getAllItems().get(0).getName());
    }

    @Test
    void getItemsFilteredByName() {
        Item item1 = new Item();
        item1.setName("item1");
        item1.setPrice("100");
        Item item2 = new Item();
        item2.setName("item2");
        item2.setPrice("200");

        Mockito.when(itemRepository.findAll(Sort.by(Sort.Direction.ASC, "name")))
                .thenReturn(List.of(item1, item2));
        ItemService itemService = new ItemService(itemRepository);
        assertEquals(2, itemService.getItemsFilteredByName().size());
        assertEquals("item1", itemService.getItemsFilteredByName().get(0).getName());
    }

    @Test
    void getItemsFilteredByDate() {
        Item item1 = new Item();
        item1.setName("item1");
        item1.setPrice("100");
        item1.setCreationDate("20");
        Item item2 = new Item();
        item2.setName("item2");
        item2.setPrice("200");
        item2.setCreationDate("2");

        Mockito.when(itemRepository.findAll(Sort.by(Sort.Direction.ASC, "creationDate")))
                .thenReturn(List.of(item2, item1));
        ItemService itemService = new ItemService(itemRepository);
        assertEquals(2, itemService.getItemsFilteredByDate().size());
        assertEquals("item2", itemService.getItemsFilteredByDate().get(0).getName());
    }

    @Test
    void getItemsFilteredByPrice() {
        Item item1 = new Item();
        item1.setName("item1");
        item1.setPrice("100");
        item1.setCreationDate("20");
        Item item2 = new Item();
        item2.setName("item2");
        item2.setPrice("200");
        item2.setCreationDate("2");

        Mockito.when(itemRepository.findAll(Sort.by(Sort.Direction.ASC, "price")))
                .thenReturn(List.of(item1, item2));
        ItemService itemService = new ItemService(itemRepository);
        assertEquals(2, itemService.getItemsFilteredByPrice().size());
        assertEquals("item1", itemService.getItemsFilteredByPrice().get(0).getName());
    }

    @Test
    void addItem() {
        Item item1 = new Item();
        item1.setName("item1");
        item1.setPrice("100");
        item1.setCreationDate("20");
        ItemService itemService = new ItemService(itemRepository, emailService);

        itemService.addItem(item1);

        Mockito.verify(emailService)
                .sendMessage(Mockito.contains(item1.toString()));
        Mockito.verify(itemRepository)
                .save(captor.capture());
        Item captured = captor.getValue();
        assertEquals("item1", captured.getName());
    }
}
