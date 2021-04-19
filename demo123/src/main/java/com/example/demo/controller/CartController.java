package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {
@Autowired
private CartService cartService;

@Autowired
    private ProductRepository productRepository;
@Autowired
    private ProductService productService;

    @RequestMapping("/add")
    public String add(HttpSession session, @RequestParam("id") Long id, @RequestParam(value = "qty", required = false, defaultValue = "1") int qty) {
        Product product= productService.get(id);
        Cart cart=cartService.getCart(session);
        cart.addItem(product,qty);
        return "cart";
    }
    @RequestMapping("/remove")// xoa san pham trong gio hang
    public String remove(HttpSession session, @RequestParam("id") Long id) {
        Product product= productService.get(id);
        Cart cart = cartService.getCart(session);
        cart.removeItem(product);
        return "cart";
    }

    @RequestMapping("/update")
    public String update(HttpSession session, @RequestParam("id") Long id,@RequestParam("qty") int qty) {
        Product product= productService.get(id);
        Cart cart = cartService.getCart(session);
        cart.updateItem(product, qty);
        return "cart";
    }

}
