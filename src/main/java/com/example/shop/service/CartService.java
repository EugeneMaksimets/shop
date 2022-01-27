package com.example.shop.service;

import com.example.shop.model.Cart;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {

    Cart createCart(Long personId);

    Cart getById(Long id);

    List<Cart> getAll();

    Cart addProductToCart(Long id, Long idProduct);

    Cart deleteProductFromCart(Long id, Long idProduct);

    BigDecimal getFullPrice(Long id);
}

