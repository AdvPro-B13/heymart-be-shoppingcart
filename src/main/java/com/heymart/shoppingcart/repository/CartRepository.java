package com.heymart.shoppingcart.repository;

import com.heymart.shoppingcart.model.Cart;
import com.heymart.shoppingcart.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CartRepository {
    private final List<Cart> carts = new ArrayList<>();
    private final ProductRepository productRepository;

    public CartRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Cart create(Long userId) {
        Cart c = new Cart(userId);
        carts.add(c);
        return c;
    }

    public Iterator<Cart> findAll() {
        return carts.iterator();
    }

    // Connect to Product
    public Cart getCart(Long uid) {
        for (Cart c : carts) {
            if (c.getUserId() == uid) {
                return c;
            }
        }
        return null;
    }

    // Add an exception, if supermarketId == Cart.supermarketId then ask for product deletion for all the saved product in Cart, then add the new one
    public Cart addProduct(Long userId, int supermarketId, String productId) {
        Cart c = getCart(userId);
        if (c == null) {
            throw new IllegalArgumentException("Cart not found for user ID: " + userId);
        }

        if (c.getSupermarketId() == supermarketId) {
            Optional<Product> product = productRepository.findProductById(productId);
            if (product == null) {
                throw new IllegalArgumentException("Product not found: " + productId);
            }

            c.getProductData().put(productId, c.getProductData().getOrDefault(productId, 0) + 1);
        } else {
            throw new IllegalArgumentException("Supermarket ID does not match with the cart's supermarket ID");
        }

        return c;
    }

    public Cart deleteProduct(Long userId, String productId) {
        Cart c = getCart(userId);
        if (c == null) {
            throw new IllegalArgumentException("Cart not found for user ID: " + userId);
        }

        c.getProductData().remove(productId);
        return c;
    }

    public Cart addProductAmount(Long userId, String productId) {
        Cart c = getCart(userId);
        if (c == null) {
            throw new IllegalArgumentException("Cart not found for user ID: " + userId);
        }
        c.getProductData().put(productId, c.getProductData().getOrDefault(productId, 0) + 1);
        return c;
    }

    // If productAmount == 0 then do product deletion
    public Cart subtractProductAmount(Long userId, String productId) {
        Cart c = getCart(userId);
        if (c == null) {
            throw new IllegalArgumentException("Cart not found for user ID: " + userId);
        }

        int productAmount = c.getProductData().getOrDefault(productId, 0);
        if (productAmount > 1) {
            c.getProductData().put(productId, productAmount - 1);
        } else if (productAmount == 1) {
            c.getProductData().remove(productId);
        }

        return c;
    }
}