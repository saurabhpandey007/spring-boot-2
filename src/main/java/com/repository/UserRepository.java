package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUserName(String username);
}