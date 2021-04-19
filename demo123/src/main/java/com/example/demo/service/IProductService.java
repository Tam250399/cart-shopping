package com.example.demo.service;

import com.example.demo.model.CartItem;
import com.example.demo.model.Product;

public interface IProductService extends IGeneralService<Product>{
    Product get(Long id);
}
