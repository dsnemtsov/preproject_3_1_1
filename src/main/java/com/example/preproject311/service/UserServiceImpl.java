package com.example.preproject311.service;

import com.example.preproject311.exception.NotFoundException;
import com.example.preproject311.model.User;
import com.example.preproject311.repo.UserRepo;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void update(long id, User updatedUser) {
        User user = findById(id);
        user.setUserName(updatedUser.getUserName());
        user.setAge(updatedUser.getAge());
        userRepo.save(user);
    }

    @Override
    public void delete(long id) {
        userRepo.delete(findById(id));
    }
}
