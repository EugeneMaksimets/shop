package com.example.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Person {
    private Integer id;
    private String name;
    private List<Cart> cartList;

}
