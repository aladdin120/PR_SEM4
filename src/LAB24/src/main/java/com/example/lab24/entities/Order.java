package com.example.lab24.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "date")
    private String orderDate;

    @Column(name = "item_id")
    private Long item_id;

    @ManyToOne(targetEntity = Item.class)
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    @JsonIgnore
    public Item item;

    public Order(String number, String orderDate) {
        this.number = number;
        this.orderDate = orderDate;
    }
}
