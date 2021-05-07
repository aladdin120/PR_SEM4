package com.example.lab18.service;

import com.example.lab18.entities.Item;
import com.example.lab18.entities.Order;
import com.example.lab18.repos.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderServiceInterface{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() { return orderRepository.findAll(); }

    @Override
    public List<Order> getOrdersFiltredByNumber() {
        return orderRepository.findAll(Sort.by(Sort.Direction.ASC, "number"));
    }

    @Override
    public List<Order> getOrdersFiltredByDate() {
        return orderRepository.findAll(Sort.by(Sort.Direction.ASC, "orderDate"));
    }

}
