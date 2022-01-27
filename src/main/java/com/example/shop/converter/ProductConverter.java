package com.example.shop.converter;

import com.example.shop.model.Product;

public class ProductConverter {
    public static Product productConverter(Product product, Product oldProduct){
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        return oldProduct;
    }
}
