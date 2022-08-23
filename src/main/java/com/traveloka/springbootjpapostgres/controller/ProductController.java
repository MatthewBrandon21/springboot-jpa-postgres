package com.traveloka.springbootjpapostgres.controller;

import com.traveloka.springbootjpapostgres.dto.ProductDto;
import com.traveloka.springbootjpapostgres.model.Product;
import com.traveloka.springbootjpapostgres.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public ProductDto create(@RequestBody ProductDto request){
        final Product product = productService.mapToEntity(request);
        final Product result = productService.create(product);
        return productService.mapToDto(result);
    }

    @PutMapping("/update/{id}")
    public ProductDto update(@PathVariable Long id, @RequestBody ProductDto request){
        final Product product = productService.mapToEntity(request);
        final Product result = productService.update(id, product);
        return productService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<ProductDto> findAll(){
        return productService.findAll().stream().map(product -> productService.mapToDto(product))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return productService.delete(id);
    }
}
