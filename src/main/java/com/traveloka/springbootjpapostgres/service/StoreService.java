package com.traveloka.springbootjpapostgres.service;

import com.traveloka.springbootjpapostgres.dto.StoreDto;
import com.traveloka.springbootjpapostgres.model.Store;

import java.util.List;

public interface StoreService {
    Store create(Store store);
    Store update(Long id, Store store);
    Boolean delete(Long id);
    List<Store> findAll();
    Store findById(Long id);

    StoreDto mapToDto(Store store);
    Store mapToEntity(StoreDto storeDto);
}
