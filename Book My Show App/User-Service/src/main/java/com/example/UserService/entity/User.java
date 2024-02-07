package com.example.UserService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "user_tbl",uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "userName")
        })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String userId;
    private String fName;
    private String email;
    private LocalDate dob;
    private String userName;
    private String password;
}
