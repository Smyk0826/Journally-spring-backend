package com.Journally.Note_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Journally.Note_service.Repository.notesRepo;
import com.Journally.Note_service.model.Note;

import java.util.List;

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
    public List<Integer> getActiveUsers() {
        return noteRepo.getActiveUsers();
    }


}
