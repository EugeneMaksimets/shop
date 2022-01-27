package com.example.shop.service;

import com.example.shop.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product, Long shopId);

    Product updateProduct(Product product);

    void deleteProduct(Long id);

    Product getById(Long id);

    List<Product> getAll();

}
