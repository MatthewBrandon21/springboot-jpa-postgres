package com.traveloka.springbootjpapostgres.repository;

import com.traveloka.springbootjpapostgres.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
