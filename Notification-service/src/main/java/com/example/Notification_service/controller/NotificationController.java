package com.example.Notification_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Notification_service.Service.NotificationService;
import com.example.Notification_service.feign.UserInterface;

@RestController
public class NotificationController {
    @Autowired
    NotificationService notificationService;
    @Autowired
    UserInterface users;

   @PostMapping("/reminder")
    public String Notify(){
        List<String> emails = users.getUnActiveUsers();
        return notificationService.reminder(emails);
    }

   @PostMapping("/greetings")
    public String greet(@RequestParam String email,@RequestParam String userName ){
        return notificationService.notify(email, userName);
    }

}
