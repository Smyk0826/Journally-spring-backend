package com.Journally.Note_service.Controller;


import org.springframework.web.bind.annotation.RestController;

import com.Journally.Note_service.model.Note;
import com.Journally.Note_service.service.notesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class notesController {
    @Autowired
    notesService noteService;

    @GetMapping("/notes")
    public List<Note> getNotes(@RequestParam int userId) {
        
        return noteService.getNotes(userId);
    
    }

    @PostMapping("/notes")
    public String addNote(@RequestBody Note entity) {
        //TODO: process POST request
        System.out.println("request called for note: "+entity);
        noteService.addNote(entity);
        return "Successfully posted Note";
    }

    @GetMapping("/activeUsers")
    public List<Integer> getActiveUsers() {
        return noteService.getActiveUsers();
    }
    
    
}
