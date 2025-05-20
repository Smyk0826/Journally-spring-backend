package com.example.Journally_Backend.Controller;


import org.springframework.web.bind.annotation.RestController;
import com.example.Journally_Backend.service.notesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.model.Note;
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
        noteService.addNote(entity);
        return "Successfully posted Note";
    }
    
}
