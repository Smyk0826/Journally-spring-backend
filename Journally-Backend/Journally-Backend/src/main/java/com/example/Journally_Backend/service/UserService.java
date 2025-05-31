package com.example.Journally_Backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Repository.UserRepo;
import com.example.model.User;
import com.example.notesFeign.NoteInterface;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    NoteInterface noteInter;

    public User getUser(String email){
        return userRepo.getUserByEmail(email);
    }

    public void addUser(User user){
        System.out.println("user service called for user: "+user);
        userRepo.save(user);
        return;
    }

    public List<String> getUnActiveUsers() {
        List<Integer> activeUsers = noteInter.getActiveUsers();
        System.out.println("activeUsers : "+activeUsers.toString());
        return userRepo.getUnActiveUsers(activeUsers);
    }

}
