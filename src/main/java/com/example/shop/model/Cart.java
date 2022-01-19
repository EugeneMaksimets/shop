package com.example.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Cart {
    private Integer id;
    private Integer personId;
    private BigDecimal priceInCart;
    private List<Product> productList;
}

