package com.restapi.demo.repository;

import com.restapi.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositiory extends JpaRepository<Product, Long> {
    Product findByName(String name);
}
