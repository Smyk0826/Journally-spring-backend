package com.example.Journally_Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.Note;
import java.util.List;
import com.example.Repository.notesRepo;

@Service
public class notesService {
    @Autowired
    notesRepo noteRepo;
    public List<Note> getNotes(int userId) {
        return noteRepo.getNoteByUserId(userId);
    }
    public void addNote(Note entity) {
        // TODO Auto-generated method stub
        noteRepo.save(entity);
        return;
    }


}
