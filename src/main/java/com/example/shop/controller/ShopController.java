package com.example.shop.controller;

import com.example.shop.model.Shop;
import com.example.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {
    @Autowired
    ShopService shopService;

    @PostMapping("shop/create")
    public Shop createShop(@RequestBody Shop shop) {
        return shopService.createShop(shop);
    }

    @PutMapping("shop/update")
    public Shop updateShop(@RequestBody Shop shop) {
        return shopService.updateShop(shop);
    }

    @DeleteMapping("shop/delete/{id}")
    public void deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
    }

    @GetMapping("shop/all")
    public List<Shop> getAll() {
        return shopService.getAll();
    }
    @GetMapping("shop/{id}")
    public Shop getById(@PathVariable Long id){
        return shopService.getById(id);
    }
}
