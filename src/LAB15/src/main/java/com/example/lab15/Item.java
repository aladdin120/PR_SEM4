package com.example.lab15;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @SequenceGenerator(name = "ord_seq", sequenceName = "ord_seq", allocationSize = 1)
    @GeneratedValue(generator = "ord_seq", strategy = GenerationType.SEQUENCE)
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String creationDate;

    @Column(name = "price")
    private String price;

    public Item(String name, String creationDate, String price) {
        this.name = name;
        this.creationDate = creationDate;
        this.price = price;
    }
}
