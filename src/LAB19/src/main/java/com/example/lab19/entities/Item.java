package com.example.lab19.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @SequenceGenerator(name = "ord_seq", sequenceName = "ord_seq", allocationSize = 1)
    @GeneratedValue(generator = "ord_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String creationDate;

    @Column(name = "price")
    private String price;

    @OneToMany(mappedBy = "item")
    private List<Order> ords;

    public Item(String name, String creationDate, String price) {
        this.name = name;
        this.creationDate = creationDate;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
