package com.example.shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "Carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "all_price")
    private BigDecimal priceInCart;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "products")
    private List<Product> productList;

}

