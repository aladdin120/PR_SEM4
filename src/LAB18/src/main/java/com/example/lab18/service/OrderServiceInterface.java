package com.example.lab18.service;

import com.example.lab18.entities.Order;

import java.util.List;

public interface OrderServiceInterface {

    List<Order> getAllOrders();
    List<Order> getOrdersFiltredByNumber();
    List<Order> getOrdersFiltredByDate();
}
