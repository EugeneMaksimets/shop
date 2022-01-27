package com.example.shop.service;

import com.example.shop.model.Shop;

import java.util.List;

public interface ShopService {
    Shop createShop(Shop shop);

    Shop updateShop(Shop shop);

    void deleteShop(Long id);

    Shop getById(Long id);

    List<Shop> getAll();
}
