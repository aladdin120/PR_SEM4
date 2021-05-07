package com.example.lab24.service;

import com.example.lab24.email.EmailService;
import com.example.lab24.entities.Order;
import com.example.lab24.repos.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    private EmailService emailService;

    @Captor
    ArgumentCaptor<Order> captor;

    @Test
    void getAllOrders() {
        Order order = new Order();
        order.setNumber("1234");
        order.setOrderDate("10");
        Order order1 = new Order();
        order1.setNumber("4321");
        order1.setOrderDate("20");

        Mockito.when(orderRepository.findAll())
                .thenReturn(List.of(order, order1));
        OrderService orderService = new OrderService(orderRepository);
        assertEquals(2, orderService.getAllOrders().size());
        assertEquals("1234", orderService.getAllOrders().get(0).getNumber());
    }

    @Test
    void getOrdersFilteredByNumber() {
        Order order = new Order();
        order.setNumber("1234");
        order.setOrderDate("10");
        Order order1 = new Order();
        order1.setNumber("4321");
        order1.setOrderDate("20");

        Mockito.when(orderRepository.findAll(Sort.by(Sort.Direction.ASC, "number")))
                .thenReturn(List.of(order, order1));
        OrderService orderService = new OrderService(orderRepository);
        assertEquals(2, orderService.getOrdersFilteredByNumber().size());
        assertEquals("1234", orderService.getOrdersFilteredByNumber().get(0).getNumber());
    }

    @Test
    void getOrdersFilteredByDate() {
        Order order = new Order();
        order.setNumber("1234");
        order.setOrderDate("10");
        Order order1 = new Order();
        order1.setNumber("4321");
        order1.setOrderDate("20");

        Mockito.when(orderRepository.findAll(Sort.by(Sort.Direction.ASC, "orderDate")))
                .thenReturn(List.of(order, order1));
        OrderService orderService = new OrderService(orderRepository);
        assertEquals(2, orderService.getOrdersFilteredByDate().size());
        assertEquals("1234", orderService.getOrdersFilteredByDate().get(0).getNumber());
    }


    @Test
    void addOrder() {
        Order order = new Order();
        order.setNumber("1234");
        order.setOrderDate("10");
        OrderService orderService = new OrderService(orderRepository, emailService);

        orderService.addOrder(order);

        Mockito.verify(emailService)
                .sendMessage(Mockito.contains(order.toString()));
        Mockito.verify(orderRepository)
                .save(captor.capture());
        Order captured = captor.getValue();
        assertEquals("1234", captured.getNumber());
    }
}
