package com.example.shop.controller;

import com.example.shop.model.Cart;
import com.example.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("cart/create/{idPerson}")
    Cart createCart(@PathVariable Long idPerson) {
        return cartService.createCart(idPerson);
    }

    @GetMapping("cart/{id}")
    public Cart findById(@PathVariable Long id) {
        return cartService.getById(id);
    }

    @GetMapping("/cart/all")
    public List<Cart> getAll() {
        return cartService.getAll();
    }

    @PutMapping("shop/{shopId}/cart/{id}/add/{idProduct}")
    public Cart addProduct(@PathVariable Long shopId, @PathVariable Long id, @PathVariable Long idProduct) {
        return cartService.addProductToCart(shopId, id, idProduct);
    }

    @DeleteMapping("cart/{id}/delete/{idProduct}")
    public Cart deleteProduct(@PathVariable Long id, @PathVariable Long idProduct) {
        return cartService.deleteProductFromCart(id, idProduct);
    }

    @GetMapping("cart/price/{id}")
    public BigDecimal getPriceFromCart(@PathVariable Long id) {
        return cartService.getFullPrice(id);
    }
}

