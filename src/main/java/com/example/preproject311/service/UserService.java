package com.example.preproject311.service;

import com.example.preproject311.exception.NotFoundException;
import com.example.preproject311.model.User;
import com.example.preproject311.repo.UserRepo;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepo userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(long id) {
        return userRepo.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public void update(long id, User updatedUser) {
        User user = findById(id);
        user.setUserName(updatedUser.getUserName());
        user.setAge(updatedUser.getAge());
        userRepo.save(user);
    }

    public void delete(long id) {
        userRepo.delete(findById(id));
    }
}
