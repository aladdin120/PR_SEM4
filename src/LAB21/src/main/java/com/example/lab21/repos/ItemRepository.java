package com.example.lab21.repos;

import com.example.lab21.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {
}
