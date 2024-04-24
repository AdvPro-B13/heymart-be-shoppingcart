package com.heymart.shoppingcart.service;

import com.heymart.shoppingcart.model.Cart;
import java.util.List;

public interface CartService {
    public Cart create(Cart c);
    public List<Cart> findAll();
    public Cart getCart(int uid);
    public Cart addProduct(int uid, int supermarketId, int productId);
    public Cart deleteProduct(int uid, int productId);
    public Cart addProductAmount(int uid, int productId);
    public Cart subtractProductAmount(int uid, int productId);
    public void checkout(int uid, int productId);
}