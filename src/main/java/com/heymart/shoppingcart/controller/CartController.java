package com.heymart.shoppingcart.controller;

import com.heymart.shoppingcart.model.Cart;
import com.heymart.shoppingcart.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService service;

    //TODO: Get products
    @GetMapping("/list/{uid}")
    public String cartListPage(Model model) {
        return "";
    }

    @PostMapping("/add/{uid}/{supermarketId}/{productId}")
    public String addProduct(@PathVariable int uid, int supermarketId, int productId) {
        service.addProduct(uid, supermarketId, productId);
        return "rediredt:/cart/list";
    }

    @PostMapping("/del/{uid}/{productId}")
    public String deleteProduct(@PathVariable int uid, int productId) {
        service.deleteProduct(uid, productId);
        return "rediredt:/cart/list";
    }
}
