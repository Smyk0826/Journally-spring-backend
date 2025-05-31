package com.Journally.Note_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Journally.Note_service.model.Note;

import java.util.List;


@Repository
public interface notesRepo extends JpaRepository<Note, Integer> {

    List<Note> getNoteByUserId(int userId);

    @Query(value = "SELECT DISTINCT user_id FROM note n WHERE DATE(STR_TO_DATE(SUBSTRING_INDEX(date, 'T', 1), '%Y-%m-%d')) = CURDATE()", nativeQuery = true)
    List<Integer> getActiveUsers();
 

}
