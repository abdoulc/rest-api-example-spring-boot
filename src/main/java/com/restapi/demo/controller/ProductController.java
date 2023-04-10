package com.restapi.demo.controller;

import com.restapi.demo.dto.ProductDto;
import com.restapi.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    private List<ProductDto> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    private void addProduct(@RequestBody ProductDto productDto){
        productService.addProdcut(productDto);
    }
}
