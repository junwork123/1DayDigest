package com.oneday.digest.domains.product.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class Product{
    @Id
    private final long id;
    private final String name;
    private final int price;
    private final int quantity;

    @Builder
    public Product(long id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
        this.id = -1;
        this.name = "default";
        this.price = 0;
        this.quantity = 0;
    }
}

