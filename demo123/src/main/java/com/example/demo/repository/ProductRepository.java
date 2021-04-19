package com.example.demo.repository;

import com.example.demo.model.CartItem;
import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {
    Product findBySku(String sku);

}
