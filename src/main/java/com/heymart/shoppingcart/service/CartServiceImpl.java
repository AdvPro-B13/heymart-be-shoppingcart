package com.heymart.shoppingcart.service;

import com.heymart.shoppingcart.model.Cart;
import com.heymart.shoppingcart.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    public Cart getCart(int uid) {
    return null;
    }

    @Override
    public Cart addProduct(int uid, int supermarketId, int productId) {
        return null;
    }

    @Override
    public Cart deleteProduct(int uid, int productId) {
        return null;
    }

    @Override
    public Cart addProductAmount(int uid, int productId) {
        return null;
    }

    @Override
    public Cart subtractProductAmount(int uid, int productId) {
        return null;
    }

    @Override
    public void checkout(int uid, int productId) {

    }
}