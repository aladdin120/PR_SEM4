package com.example.lab19.service;

import com.example.lab19.entities.Order;

import java.util.List;


public interface OrderServiceInterface {

    List<Order> getAllOrders();
    List<Order> getOrdersFilteredByNumber();
    List<Order> getOrdersFilteredByDate();
}
