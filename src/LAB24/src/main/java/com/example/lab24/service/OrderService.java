package com.example.lab24.service;

import com.example.lab24.email.EmailService;
import com.example.lab24.entities.Order;
import com.example.lab24.repos.ItemRepository;
import com.example.lab24.repos.OrderRepository;
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
    public OrderService(OrderRepository orderRepository, EmailService emailService) {
        this.orderRepository = orderRepository;
        this.emailService = emailService;
    }

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

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
