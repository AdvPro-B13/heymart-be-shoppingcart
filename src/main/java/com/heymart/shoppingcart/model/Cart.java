package com.heymart.shoppingcart.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.UUID;

@Entity
@Table(name = "cart")
@Getter @Setter
public class Cart {
    @Id
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "supermarket_id", nullable = false)
    private int supermarketId;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "cart_product_data", joinColumns = @JoinColumn(name = "cart_id"))
    @MapKeyColumn(name = "product_id")
    @Column(name = "product_amount")
    private HashMap<String, Integer> productData = new HashMap<>();

    public Cart(UUID userId) {
        this.userId = userId;
    }

    public void setUserId(UUID userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setSupermarketId(int supermarketId) {
        if (supermarketId < 0) {
            throw new IllegalArgumentException("Supermarket ID cannot be negative");
        }
        this.supermarketId = supermarketId;
    }

    public void addProduct(String productId, int amount) {
        if (productId == null) {
            throw new NullPointerException("Product ID cannot be null");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Product amount cannot be negative");
        }
        productData.put(productId, productData.getOrDefault(productId, 0) + amount);
    }

    public void removeProduct(UUID productId) {
        if (productId == null) {
            throw new NullPointerException("Product ID cannot be null");
        }
        productData.remove(productId);
    }

    public void updateProductAmount(String productId, int amount) {
        if (productId == null) {
            throw new NullPointerException("Product ID cannot be null");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Product amount cannot be negative");
        }
        if (productData.containsKey(productId)) {
            productData.put(productId, amount);
        } else {
            throw new IllegalArgumentException("Product not found in cart");
        }
    }
}