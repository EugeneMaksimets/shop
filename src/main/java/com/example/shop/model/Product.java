package com.example.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {
    private Integer id;
    private String name;
    private BigDecimal price;
}
