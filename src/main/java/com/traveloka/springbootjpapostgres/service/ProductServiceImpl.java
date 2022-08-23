package com.traveloka.springbootjpapostgres.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.traveloka.springbootjpapostgres.dto.ProductDto;
import com.traveloka.springbootjpapostgres.model.Product;
import com.traveloka.springbootjpapostgres.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        final Product result = productRepository.save(product);
        return result;
    }

    @Override
    public Product update(Long id, Product product) {
        final Product result = findById(id);
        if (result != null) {
            result.setName(product.getName());
            result.setDescription(product.getDescription());
            result.setStore_id(product.getStore_id());
            return productRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Product result = findById(id);
        if (result != null){
           productRepository.deleteById(id);
           return true;
        }
        return false;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        final Optional<Product> result = productRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        return null;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public ProductDto mapToDto(Product product) {
        return mapper.convertValue(product, ProductDto.class);
    }

    @Override
    public Product mapToEntity(ProductDto productDto) {
        return mapper.convertValue(productDto, Product.class);
    }
}
