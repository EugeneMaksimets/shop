package com.example.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cart {
    private Integer id;
    private double priceInCard;
    private List<Product> productList;
}
