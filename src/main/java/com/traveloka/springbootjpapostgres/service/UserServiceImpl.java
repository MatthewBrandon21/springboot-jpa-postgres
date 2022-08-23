package com.traveloka.springbootjpapostgres.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.traveloka.springbootjpapostgres.dto.UserDto;
import com.traveloka.springbootjpapostgres.model.User;
import com.traveloka.springbootjpapostgres.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        final User result = userRepository.save(user);
        return result;
    }

    @Override
    public User update(Long id, User user) {
        final User result = findById(id);
        if (result != null) {
            result.setEmail(user.getEmail());
            result.setName(user.getName());
            result.setPassword(user.getPassword());
            result.setUsername(user.getUsername());
            result.setIsActive(user.getIsActive());
            return userRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final User result = findById(id);
        if (result != null){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        final Optional<User> result = userRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        return null;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public UserDto mapToDto(User user) {
        return mapper.convertValue(user, UserDto.class);
    }

    @Override
    public User mapToEntity(UserDto userDto) {
        return mapper.convertValue(userDto, User.class);
    }
}
