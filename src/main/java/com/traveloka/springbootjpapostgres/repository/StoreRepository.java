package com.traveloka.springbootjpapostgres.repository;

import com.traveloka.springbootjpapostgres.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
