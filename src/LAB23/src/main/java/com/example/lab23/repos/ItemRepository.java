package com.example.lab23.repos;

import com.example.lab23.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {
}
