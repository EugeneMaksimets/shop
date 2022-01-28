package com.example.shop.service.impl;

import com.example.shop.model.Cart;
import com.example.shop.model.Person;
import com.example.shop.model.Product;
import com.example.shop.model.Shop;
import com.example.shop.repository.CartRepository;
import com.example.shop.repository.PersonRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.ShopRepository;
import com.example.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public Cart createCart(Long personId) {
        Cart cart = new Cart();
        Person person = personRepository.findById(personId).get();
        cart.setPriceInCart(BigDecimal.ZERO);
        Cart newCart = cartRepository.save(cart);
        List<Cart> cartList = person.getCarts();
        cartList.add(cart);
        person.setCarts(cartList);
        personRepository.save(person);
        return newCart;
    }

    @Override
    public Cart getById(Long id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public List<Cart> getAll() {
        return (List<Cart>) cartRepository.findAll();
    }

    @Override
    public Cart addProductToCart(Long shopId, Long id, Long idProduct) {
        Cart cart = cartRepository.findById(id).get();
        Shop shop = shopRepository.findById(shopId).get();
        for (Product tmp : shop.getProductList()) {
            if (tmp.getId().equals(idProduct)) {
                List<Product> productList = cart.getProductList();
                productList.add(tmp);
                cart.setProductList(productList);
                BigDecimal sum = cart.getPriceInCart().add(tmp.getPrice());
                cart.setPriceInCart(sum);
                break;
            } else {
                System.err.println("This product from another shop");
            }
        }
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart deleteProductFromCart(Long id, Long idProduct) {
        Cart cart = cartRepository.findById(id).get();
        for (Product tmp : cart.getProductList()) {
            if (tmp.getId().equals(idProduct)) {
                List<Product> productList = cart.getProductList();
                productList.remove(tmp);
                cart.setProductList(productList);
                BigDecimal sum = cart.getPriceInCart().subtract(tmp.getPrice());
                cart.setPriceInCart(sum);
                cartRepository.save(cart);
                break;
            }
        }
        return cart;
    }

    @Override
    public BigDecimal getFullPrice(Long id) {
        Cart cart = cartRepository.findById(id).get();
        return cart.getPriceInCart();
    }
}

