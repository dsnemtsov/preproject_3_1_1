package com.example.preproject311.service;

import com.example.preproject311.model.User;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    List<User> findAll();

    User findById(long id);

    void save(User user);

    void update(long id, User updatedUser);

    void delete(long id);
}
