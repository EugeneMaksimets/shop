package com.example.shop.service.impl;

import com.example.shop.converter.ShopConverter;
import com.example.shop.model.Shop;
import com.example.shop.repository.ShopRepository;
import com.example.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopRepository shopRepository;

    @Override
    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public Shop updateShop(Shop shop) {
        Shop oldShop = shopRepository.findById(shop.getId()).orElseGet(Shop::new);
        return shopRepository.save(ShopConverter.shopConverter(shop, oldShop));
    }

    @Override
    public void deleteShop(Long id) {
        shopRepository.deleteById(id);
    }

    @Override
    public Shop getById(Long id) {
        return shopRepository.findById(id).get();
    }

    @Override
    public List<Shop> getAll() {
        return (List<Shop>) shopRepository.findAll();
    }
}
