package com.example.lab19.repos;

import com.example.lab19.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {
}
