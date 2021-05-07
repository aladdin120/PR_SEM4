package com.example.lab20.repos;

import com.example.lab20.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {
}
