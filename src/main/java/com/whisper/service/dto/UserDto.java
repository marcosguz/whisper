package com.whisper.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private String idUser;
    private String username;
    private String name;
    private String surname;
    private int age;
    private char gender;
    private String phone;
    private String email;
    private String password;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private boolean status;
    private byte[] profileImage;
}
