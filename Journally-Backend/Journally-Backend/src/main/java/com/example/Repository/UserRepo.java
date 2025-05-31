package com.example.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
    User getUserByEmail(String email);

    @Query(value = "select u.email from User u where u.userId not in :activeUsers")
    List<String> getUnActiveUsers(@Param(value = "activeUsers") List<Integer> activeUsers);

    
} 
