package com.heymart.shoppingcart.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter @Setter
public class Cart {
    private int uid, supermarketId;
    private HashMap<Integer, Integer> productData; //<productId, productAmount>
}