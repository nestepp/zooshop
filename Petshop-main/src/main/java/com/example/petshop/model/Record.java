package com.example.petshop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="records")
@Data
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;

    private int quantity;

    private int price;

    private int cost;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Record() {
    }

    public Record(String item, int quantity, int price,int cost, User user) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.cost = cost;
        this.user = user;

    }
}
