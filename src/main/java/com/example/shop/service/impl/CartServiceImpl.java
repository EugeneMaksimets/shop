package com.example.shop.service.impl;

import com.example.shop.model.Cart;
import com.example.shop.model.Person;
import com.example.shop.model.Product;
import com.example.shop.service.CartService;
import com.example.shop.storage.CartStorage;
import com.example.shop.storage.PersonStorage;
import com.example.shop.storage.ProductStorage;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private List<Product> productList = new ArrayList<>();
    private List<Cart> cartList = new ArrayList<>();

    @Override
    public Cart createCart(Cart cart) {
        cart.setPriceInCart(BigDecimal.ZERO);
        CartStorage.cartStorageList.add(cart);
        cartList.add(cart);
        for (Person tmp : PersonStorage.personStorageList) {
            if (tmp.getId().equals(cart.getPersonId())) {
                tmp.setCartList(cartList);
            }
        }
        return cart;
    }

    @Override
    public Cart updateCart(Cart cart) {
        Cart newCart = new Cart();
        for (Cart tmp : CartStorage.cartStorageList) {
            if (tmp.getId().equals(cart.getId())) {
                tmp.setPriceInCart(cart.getPriceInCart());
                tmp.setPersonId(cart.getPersonId());
                newCart = tmp;
            }
        }
        return newCart;
    }

    @Override
    public void deleteCart(Cart cart) {
        CartStorage.cartStorageList.removeIf(tmp -> tmp.getId().equals(cart.getId()));
    }

    @Override
    public Cart getById(int id) {
        Cart cart = new Cart();
        for (Cart tmp : CartStorage.cartStorageList) {
            if (tmp.getId() == id) {
                cart = tmp;
            }
        }
        return cart;
    }

    @Override
    public List<Cart> getAll() {
        return CartStorage.cartStorageList;
    }

    @Override
    public Cart addProductToCart(int id, int idProduct) {
        Cart cart = new Cart();
        for (Cart tmp : CartStorage.cartStorageList) {
            if (id == tmp.getId()) {
                for (Product tmpProduct : ProductStorage.productStorageList) {
                    if (idProduct == tmpProduct.getId()) {
                        BigDecimal sum = getFullPrice(tmp.getId());
                        sum = sum.add(tmpProduct.getPrice());
                        tmp.setPriceInCart(sum);
                        productList.add(tmpProduct);
                        tmp.setProductList(productList);
                        cart = tmp;
                    }
                }
            }
        }
        return cart;
    }

    @Override
    public Cart deleteProductFromCart(int id, int idProduct) {
        Cart cart = new Cart();
        for (Cart tmp : CartStorage.cartStorageList) {
            if (id == tmp.getId()) {
                for (Product tmpProduct : ProductStorage.productStorageList) {
                    if (idProduct == tmpProduct.getId()) {
                        BigDecimal sum = getFullPrice(tmp.getId());
                        sum = sum.subtract(tmpProduct.getPrice());
                        tmp.setPriceInCart(sum);
                        productList.remove(tmpProduct);
                        tmp.setProductList(productList);
                        cart = tmp;
                    }
                }
            }
        }
        return cart;
    }

    @Override
    public BigDecimal getFullPrice(int id) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Cart tmp : CartStorage.cartStorageList) {
            if (tmp.getId() == id) {
                sum = sum.add(tmp.getPriceInCart());
                tmp.setPriceInCart(sum);
            }
        }
        return sum;
    }
}
