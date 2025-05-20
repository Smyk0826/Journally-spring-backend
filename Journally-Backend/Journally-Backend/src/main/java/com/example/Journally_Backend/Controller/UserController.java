package com.example.Journally_Backend.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.Journally_Backend.service.UserService;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    UserService userService;
   
    @GetMapping("/hello")
    public String greet(){
        return "Welcome to Journally client";
    }

    @GetMapping("/users")
    public User getUser(@RequestParam String email){
        System.out.println("request called for email: "+email);
        return userService.getUser(email);
    }

    @PostMapping("/users")
    public String createUser(@RequestBody User user) { 
        System.out.println("request called for user: "+user);
        userService.addUser(user);       
        return "Successfull";
    }
    
}
