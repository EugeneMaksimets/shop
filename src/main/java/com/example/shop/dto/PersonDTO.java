package com.example.shop.dto;

import com.example.shop.model.Cart;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {
    private Integer id;
    private String name;
    private Cart cart;
}
