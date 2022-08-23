package com.traveloka.springbootjpapostgres.repository;

import com.traveloka.springbootjpapostgres.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
