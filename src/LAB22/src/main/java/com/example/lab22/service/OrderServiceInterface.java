package com.example.lab22.service;

import com.example.lab22.entities.Order;

import java.util.List;


public interface OrderServiceInterface {

    List<Order> getAllOrders();
    List<Order> getOrdersFilteredByNumber();
    List<Order> getOrdersFilteredByDate();
    void addOrder(Order order);
}
