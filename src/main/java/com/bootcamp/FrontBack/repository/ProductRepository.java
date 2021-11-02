package com.bootcamp.FrontBack.repository;

import com.bootcamp.FrontBack.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}