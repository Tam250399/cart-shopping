package com.example.demo.service;


import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService implements IProductService{
    @Autowired
    private ProductRepository cartRepository;

    @Override
    public List<Product> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return cartRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Product get(Long id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public void remove(Long id) {
            cartRepository.deleteById(id);
    }




    //	lay ve list product
//    public List<Product> listAll(){
//        return cartRepository.findAll();
//    }
//    //	them 1 san pham
//    public void save(Product p) {
//        repo.save(p);
//    }
//    //	lay san pham theo id
//    public Product get(Long id) {
//        return repo.findById(id).get();
//    }
//    //	xoa san pham
//    public void delete(Long id) {
//        repo.deleteById(id);
//    }
}