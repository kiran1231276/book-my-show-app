package com.example.UserService.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {


    private String userId;

    @NotBlank
    @NotNull
    @Size(min = 5,message = "At least 5 character expected...!")
    private String fName;

    @Email(message = "Email is not valid!!!")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@gmail\\.com$")
    private String email;

    @NotBlank
    private LocalDate dob;

    @NotBlank
    @NotNull
    private String userName;

    @Pattern (regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,20}$",message = "At least one uppercase letter, one lowercase letter, one digit, and minimum length of 8 characters")
    @JsonIgnoreProperties
    private String password;
}
