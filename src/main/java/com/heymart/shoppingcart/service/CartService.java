package com.heymart.shoppingcart.service;

import com.heymart.shoppingcart.model.Cart;
import java.util.List;
import java.util.UUID;

public interface CartService {
    public void create(UUID userId);
    public List<Cart> findAll();
    public Cart getCart(UUID userIid);
    public Cart addProduct(UUID userId, String supermarketId, String productId);
    public Cart deleteProduct(UUID userId, String productId);
    public Cart addProductAmount(UUID userId, String productId);
    public Cart subtractProductAmount(UUID userIid, String productId);
    public void checkout(UUID userId, String productId);
}