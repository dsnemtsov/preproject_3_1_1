package com.example.preproject311.service;

import com.example.preproject311.model.User;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    @Transactional
    List<User> findAll();

    @Transactional
    User findById(long id);

    @Transactional
    void save(User user);

    @Transactional
    void update(long id, User updatedUser);

    @Transactional
    void delete(long id);
}
