package com.example.shop.converter;

import com.example.shop.model.Shop;

public class ShopConverter {
    public static Shop shopConverter(Shop shop, Shop oldShop) {
        oldShop.setName(shop.getName());
        oldShop.setPersonList(shop.getPersonList());
        oldShop.setProductList(shop.getProductList());
        return oldShop;
    }
}
