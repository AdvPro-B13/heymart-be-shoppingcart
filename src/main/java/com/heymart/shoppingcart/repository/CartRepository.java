package com.heymart.shoppingcart.repository;

import com.heymart.shoppingcart.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;

@Repository
public class CartRepository {
    private List<Cart> carts = new ArrayList<>();

    public Cart create(Cart c) {
        carts.add(c);
        return c;
    }

    public Iterator<Cart> findAll() {
        return carts.iterator();
    }

    //TODO: Connect to Product
    public Cart getCart(int uid) {
        for (Cart c : carts) if (c.getUid() == uid) return c;
        return null;
    }

    //TODO: Add an exception for supermarketId == Cart.supermarketId
    public Cart addProduct(int uid, int supermarketId, int productId) {
        Cart c = getCart(uid);
        if (c.getSupermarketId() == supermarketId) c.getProductData().put(productId, 1);
        return c;
    }

    public Cart deleteProduct(int uid, int productId) {
        Cart c = getCart(uid);
        c.getProductData().remove(productId);
        return c;
    }

    public Cart addProductAmount(int uid, int productId) {
        Cart c = getCart(uid);
        HashMap<Integer, Integer> cartProducts = c.getProductData();
        cartProducts.put(productId, cartProducts.get(productId) + 1);
        return c;
    }

    //TODO: If productAmount == 0 then do product deletion
    public Cart subtractProductAmount(int uid, int productId) {
        Cart c = getCart(uid);
        HashMap<Integer, Integer> cartProducts = c.getProductData();
        int productAmount = cartProducts.get(productId);
        if (productAmount > 1) cartProducts.put(productId, productAmount - 1);
        return c;
    }

    public void checkout(int uid, int productId) {
        Cart c = getCart(uid);
        boolean isSucceed = false;
        //TODO: Checkout, if succeed then isSucceed = true
        if (isSucceed) c.getProductData().remove(productId);
    }
}