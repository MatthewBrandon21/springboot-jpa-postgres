package com.traveloka.springbootjpapostgres.service;

import com.traveloka.springbootjpapostgres.dto.UserDto;
import com.traveloka.springbootjpapostgres.model.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User update(Long id, User user);
    Boolean delete(Long id);
    List<User> findAll();
    User findById(Long id);

    UserDto mapToDto(User user);
    User mapToEntity(UserDto userDto);
}
