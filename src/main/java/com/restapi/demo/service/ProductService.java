package com.restapi.demo.service;

import com.restapi.demo.dto.ProductDto;
import com.restapi.demo.entity.Product;
import com.restapi.demo.repository.ProductRepositiory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepositiory repositiory;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${product.tax}")
    private String taxProduct;

    public void addProdcut(ProductDto productDto){
        productDto.setAmount(applyTax(productDto.getAmount()));
        Product entity = modelMapper.map(productDto, Product.class);
        repositiory.save(entity);
    }

    public List<ProductDto> getProducts(){
       return repositiory.findAll().stream()
               .map(product->modelMapper.map(product, ProductDto.class))
               .collect(Collectors.toList());
    }

    private BigDecimal applyTax(BigDecimal amount){
        BigDecimal taxApplied = amount.multiply(new BigDecimal(taxProduct).divide(new BigDecimal(100)));
        return amount.add(taxApplied);
    }
}
