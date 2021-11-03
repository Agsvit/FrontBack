package com.bootcamp.FrontBack.service;

import com.bootcamp.FrontBack.controller.response.ProductResponse;
import com.bootcamp.FrontBack.model.Product;
import com.bootcamp.FrontBack.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }


    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}