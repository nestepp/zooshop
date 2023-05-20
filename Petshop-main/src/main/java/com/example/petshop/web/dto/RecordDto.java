package com.example.petshop.web.dto;

import lombok.Data;

@Data
public class RecordDto {

    private String item;

    private int quantity;
    private int price;

    private int cost;

    public RecordDto() {
    }

    public RecordDto(String item,int price,int cost, int quantity) {
        super();
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.cost = cost;
    }
}
