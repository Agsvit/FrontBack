package com.bootcamp.FrontBack.controller;

import com.bootcamp.FrontBack.controller.request.ProductRequest;
import com.bootcamp.FrontBack.controller.response.ProductResponse;
import com.bootcamp.FrontBack.model.Product;
import com.bootcamp.FrontBack.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    @ApiOperation(value = "Get all products",
            authorizations = {@Authorization(value = "basicAuth")})
    public List<Product> getProduct() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    @ApiOperation(value = "Get products by id",
            authorizations = {@Authorization(value = "basicAuth")})
    public Product getProductById(@PathVariable(value = "id") Long id) {
        return productService.findById(id);
    }

    //Create
    @PostMapping(value = "/products")
    @ApiOperation(value = "Create product",
            authorizations = {@Authorization(value = "basicAuth")})
    public Product createProduct(@RequestBody ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .value(productRequest.getValue())
                .build();
        productService.createProduct(product);
        return product;
    }

    @GetMapping(value = "/products/cheapest")
    @ApiOperation(value = "Get cheapest products",
            authorizations = {@Authorization(value = "basicAuth")})
    public List<ProductResponse> getCheapestProducts() {
        List<Product> products = productService.getCheapestProducts();
        List<ProductResponse> responseList = new ArrayList<>();
        for (Product product : products) {
            responseList.add(ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .value(product.getValue())
                    .build());
        }
        return responseList;
    }

}