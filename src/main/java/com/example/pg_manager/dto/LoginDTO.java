// src/main/java/com/example/pg_manager/dto/LoginProfileDTO.java
package com.example.pg_manager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    // Login Fields (from the payload)
    private String name;
    private String phoneNumber;
    private String email;
    private String password; // <-- Required by Login model
    private boolean isActive = true;
    private boolean isDeleted = false;

    // Profile Fields (from the payload)
    private String city;
    private String district;
    private String state;
    private String pincode;
}