package com.example.Notification_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("JOURNALLY-BACKEND")
public interface UserInterface {
    
    @GetMapping("/unActiveUsers")
    public List<String> getUnActiveUsers();
}
