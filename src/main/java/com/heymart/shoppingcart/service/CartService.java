package com.heymart.shoppingcart.service;

import com.heymart.shoppingcart.model.Cart;
import java.util.List;
import java.util.UUID;

public interface CartService {
    public Cart create(Cart c);
    public List<Cart> findAll();
    public Cart getCart(UUID userIid);
    public Cart addProduct(UUID userId, int supermarketId, String productId);
    public Cart deleteProduct(UUID userId, String productId);
    public Cart addProductAmount(UUID userId, String productId);
    public Cart subtractProductAmount(UUID userIid, String productId);
    public void checkout(UUID userId, String productId);
}