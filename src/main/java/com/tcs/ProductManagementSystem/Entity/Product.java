package com.tcs.ProductManagementSystem.Entity;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name="product_tbl")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public long price;
    public String review;

    public Product(long id, String name, long price, String review) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.review = review;
    }
    public Product() {
    }
}
