package com.Journally.Note_service.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Note")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int noteId;
    String data;
    String date;
    int userId;
    public static List<Note> getNoteByUserId(int userId2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNoteByUserId'");
    }
}
