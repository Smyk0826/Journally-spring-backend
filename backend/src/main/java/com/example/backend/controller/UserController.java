package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.User;
import com.example.backend.service.UserServices;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class UserController {

    @Autowired
    UserServices userService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getMethodName() {
        return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }
    
    @PostMapping("/users")
    public ResponseEntity<?> putUser(@RequestBody User user){
        User savUser =  userService.putUser(user);
        return new ResponseEntity<>(savUser, HttpStatus.ACCEPTED);
    }
   

}
