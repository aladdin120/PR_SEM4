package com.example.lab21.service;

import com.example.lab21.entities.Item;
import com.example.lab21.entities.Order;

import java.util.List;


public interface OrderServiceInterface {

    List<Order> getAllOrders();
    List<Order> getOrdersFilteredByNumber();
    List<Order> getOrdersFilteredByDate();
    void addOrder(Order order);
}
