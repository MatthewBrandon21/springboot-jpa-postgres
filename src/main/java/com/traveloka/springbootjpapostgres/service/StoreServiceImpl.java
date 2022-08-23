package com.traveloka.springbootjpapostgres.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.traveloka.springbootjpapostgres.dto.StoreDto;
import com.traveloka.springbootjpapostgres.model.Store;
import com.traveloka.springbootjpapostgres.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StoreServiceImpl implements StoreService{

    @Autowired
    StoreRepository storeRepository;

    @Override
    public Store create(Store store) {
        final Store result = storeRepository.save(store);
        return result;
    }

    @Override
    public Store update(Long id, Store store) {
        final Store result = findById(id);
        if (result != null) {
            result.setAddress(store.getAddress());
            result.setName(store.getName());
            result.setUser_id(store.getUser_id());
            return storeRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Store result = findById(id);
        if (result != null){
            storeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store findById(Long id) {
        final Optional<Store> result = storeRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public StoreDto mapToDto(Store store) {
        return mapper.convertValue(store, StoreDto.class);
    }

    @Override
    public Store mapToEntity(StoreDto storeDto) {
        return mapper.convertValue(storeDto, Store.class);
    }
}
