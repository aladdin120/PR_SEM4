package com.example.lab20.service;

import com.example.lab20.entities.Order;

import java.util.List;


public interface OrderServiceInterface {

    List<Order> getAllOrders();
    List<Order> getOrdersFilteredByNumber();
    List<Order> getOrdersFilteredByDate();
}
