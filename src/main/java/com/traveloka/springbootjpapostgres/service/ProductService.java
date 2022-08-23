package com.traveloka.springbootjpapostgres.service;

import com.traveloka.springbootjpapostgres.dto.ProductDto;
import com.traveloka.springbootjpapostgres.model.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);
    Product update(Long id, Product product);
    Boolean delete(Long id);
    List<Product> findAll();
    Product findById(Long id);

    ProductDto mapToDto(Product product);
    Product mapToEntity(ProductDto productDto);
}
