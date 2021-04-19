package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tam")
public class ProductController {

@Autowired
    private ProductRepository productRepository;

@Autowired
    private ProductService productService;
@RequestMapping("/index")
        public String index(){
            return ("index");
        }

    @GetMapping("/shop")// lay ve toan bo san pham
    public String shop(Model model) {
        model.addAttribute("products",productRepository.findAll());
        return "shop";
    }

    @RequestMapping("/cart")// gio hang
    public String cart() {
        return "cart";
    }

    @RequestMapping("/product/{id}")// truy cap 1 san pham
    public String product(@PathVariable("id") Long id , Model model ) {
        Product product=productService.findById(id).get();
        model.addAttribute("product", product);
        return "product";
    }

}
