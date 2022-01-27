package com.example.shop.service.impl;

import com.example.shop.converter.ProductConverter;
import com.example.shop.model.Product;
import com.example.shop.model.Shop;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.ShopRepository;
import com.example.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public Product createProduct(Product product, Long shopId) {
        Shop shop = shopRepository.findById(shopId).get();
        List<Product> productList = shop.getProductList();
        productList.add(product);
        Product newProduct = productRepository.save(product);
        shopRepository.save(shop);
        return newProduct;
    }

    @Override
    public Product updateProduct(Product product) {
        Product oldProduct = productRepository.findById(product.getId()).orElseGet(Product::new);
        return productRepository.save(ProductConverter.productConverter(product, oldProduct));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }
}
