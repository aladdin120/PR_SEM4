package com.example.lab23.service;

import com.example.lab23.entities.Order;
import com.example.lab23.repos.OrderRepository;
import com.example.lab23.service.OrderServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements OrderServiceInterface {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    EmailService emailService;

    @Transactional
    @Override
    public List<Order> getAllOrders() {
        log.info("Starting the service getAllOrders");
        return orderRepository.findAll();
    }

    @Transactional
    @Override
    public List<Order> getOrdersFilteredByNumber() {
        log.info("Starting the service getOrdersFilteredByNumber");
        return orderRepository.findAll(Sort.by(Sort.Direction.ASC, "number"));
    }

    @Transactional
    @Override
    public List<Order> getOrdersFilteredByDate() {
        log.info("Starting the service getOrdersFilteredByDate");
        return orderRepository.findAll(Sort.by(Sort.Direction.ASC, "orderDate"));
    }

    @Transactional
    @Override
    public void addOrder(Order order) {
        log.info("Starting the service addOrder");
        emailService.sendMessage(order.toString());
        orderRepository.save(order);
    }

}
