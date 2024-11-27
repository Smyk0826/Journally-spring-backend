package com.example.backend.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.User;
import com.example.backend.repository.UserRepository;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepo;
    public List<User> getUsers() {
      return userRepo.findAll();
    }

    public User putUser(User user){
        return userRepo.save(user);
    }

}
