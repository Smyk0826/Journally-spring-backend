package com.example.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    int id;
    String userName;
    String userPassword;
}
