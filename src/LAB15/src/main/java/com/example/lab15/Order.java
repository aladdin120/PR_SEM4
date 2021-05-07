package com.example.lab15;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "date")
    private String orderDate;

    @Column(name = "item_id")
    private String name;

    public Order(String number, String orderDate) {
        this.number = number;
        this.orderDate = orderDate;
    }
}
