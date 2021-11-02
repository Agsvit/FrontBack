package com.bootcamp.FrontBack.controller;

import com.bootcamp.FrontBack.model.Product;
import com.bootcamp.FrontBack.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProduct(){
        return productService.findAll();
    }

       @GetMapping("/Products/{id}")
    public Product getProductById(@PathVariable(value = "id") Long id) {
        return productService.findById(id);
    }

}