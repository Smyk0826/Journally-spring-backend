package com.example.Journally_Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Repository.UserRepo;
import com.example.model.User;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User getUser(String email){
        return userRepo.getUserByEmail(email);
    }

    public void addUser(User user){
        System.out.println("user service called for user: "+user);
        userRepo.save(user);
        return;
    }

}
