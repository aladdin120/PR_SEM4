package com.example.lab20.service;

import com.example.lab20.entities.Order;
import com.example.lab20.repos.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements OrderServiceInterface{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        log.info("Starting the service getAllOrders");
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersFilteredByNumber() {
        log.info("Starting the service getOrdersFilteredByNumber");
        return orderRepository.findAll(Sort.by(Sort.Direction.ASC, "number"));
    }

    @Override
    public List<Order> getOrdersFilteredByDate() {
        log.info("Starting the service getOrdersFilteredByDate");
        return orderRepository.findAll(Sort.by(Sort.Direction.ASC, "orderDate"));
    }

}
