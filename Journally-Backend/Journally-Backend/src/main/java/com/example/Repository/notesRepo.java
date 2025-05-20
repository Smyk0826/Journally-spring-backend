package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.example.model.Note;

@Repository
public interface notesRepo extends JpaRepository<Note, Integer> {

    List<Note> getNoteByUserId(int userId);

}
