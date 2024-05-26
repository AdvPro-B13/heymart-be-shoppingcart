package com.heymart.shoppingcart.controller;
import com.heymart.shoppingcart.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public String addProduct(@PathVariable Long userId, String supermarketId, String productId) {
        service.addProduct(userId, supermarketId, productId);
        return "redirect:/cart/list";
    }

    @PostMapping("/del/{uid}/{productId}")
    public String deleteProduct(@PathVariable Long userId, String productId) {
        service.deleteProduct(userId, productId);
        return "redirct:/cart/list";
    }
}