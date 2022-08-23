package com.traveloka.springbootjpapostgres.controller;

import com.traveloka.springbootjpapostgres.dto.StoreDto;
import com.traveloka.springbootjpapostgres.model.Store;
import com.traveloka.springbootjpapostgres.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @PostMapping("/create")
    public StoreDto create(@RequestBody StoreDto request){
        final Store store = storeService.mapToEntity(request);
        final Store result = storeService.create(store);
        return storeService.mapToDto(result);
    }

    @PutMapping("/update/{id}")
    public StoreDto update(@PathVariable Long id, @RequestBody StoreDto request){
        final Store store = storeService.mapToEntity(request);
        final Store result = storeService.update(id, store);
        return storeService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<StoreDto> findAll(){
        return storeService.findAll().stream().map(store -> storeService.mapToDto(store))
                .collect(Collectors.toList());
    }

    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Long id) {
        return storeService.delete((id));
    }
}
