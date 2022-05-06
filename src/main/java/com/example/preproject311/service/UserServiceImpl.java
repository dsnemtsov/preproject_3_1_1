package com.example.preproject311.service;

import com.example.preproject311.exception.NotFoundException;
import com.example.preproject311.model.User;
import com.example.preproject311.repo.UserRepo;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(long id) {
        return userRepo.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Transactional
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

    @Transactional
    @Override
    public void delete(long id) {
        userRepo.delete(findById(id));
    }
}
