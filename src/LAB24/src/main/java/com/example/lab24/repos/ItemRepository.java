package com.example.lab24.repos;

import com.example.lab24.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {
}
