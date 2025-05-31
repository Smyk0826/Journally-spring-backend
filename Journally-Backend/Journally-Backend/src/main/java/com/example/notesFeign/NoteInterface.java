package com.example.notesFeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("NOTE-SERVICE")
public interface NoteInterface {
    @GetMapping("/activeUsers")
    public List<Integer> getActiveUsers();
}
