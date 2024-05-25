package com.heymart.shoppingcart.service;

import com.heymart.shoppingcart.model.Cart;
import com.heymart.shoppingcart.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart create(Cart c) {
        cartRepository.create(c);
        return c;
    }

    @Override
    public List<Cart> findAll() {
        Iterator<Cart> productIterator = cartRepository.findAll();
        List<Cart> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }

    @Override
    public Cart getCart(UUID uid) {
    return null;
    }

    @Override
    public Cart addProduct(UUID userId, int supermarketId, String productId) {
        return null;
    }

    @Override
    public Cart deleteProduct(UUID userId, String productId) {
        return null;
    }

    @Override
    public Cart addProductAmount(UUID uid, String productId) {
        return null;
    }

    @Override
    public Cart subtractProductAmount(UUID userId, String productId) {
        return null;
    }

    @Override
    public void checkout(UUID userId, String productId) {

    }
}