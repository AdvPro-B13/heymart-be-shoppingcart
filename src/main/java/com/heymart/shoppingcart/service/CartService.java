package com.heymart.shoppingcart.service;

import com.heymart.shoppingcart.model.Cart;
import java.util.List;
import java.util.UUID;

public interface CartService {
    public void create(Long userId);
    public List<Cart> findAll();
    public Cart getCart(Long userId);
    public Cart addProduct(Long userId, String supermarketId, String productId);
    public Cart deleteProduct(Long userId, String productId);
    public Cart addProductAmount(Long userId, String productId);
    public Cart subtractProductAmount(Long userIid, String productId);
    public void checkout(Long userId, String productId);
}