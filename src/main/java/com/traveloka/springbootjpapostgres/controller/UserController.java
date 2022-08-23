package com.traveloka.springbootjpapostgres.controller;

import com.traveloka.springbootjpapostgres.dto.UserDto;
import com.traveloka.springbootjpapostgres.model.User;
import com.traveloka.springbootjpapostgres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public UserDto create(@RequestBody UserDto request){
        final User user = userService.mapToEntity(request);
        final User result = userService.create(user);
        return userService.mapToDto(result);
    }

    @PutMapping("/update/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UserDto request){
        final User user = userService.mapToEntity(request);
        final User result = userService.update(id, user);
        return userService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<UserDto> findAll(){
        return userService.findAll().stream().map(user -> userService.mapToDto(user))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
