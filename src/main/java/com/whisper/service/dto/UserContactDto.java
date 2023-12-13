package com.whisper.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserContactDto {
    private String idUserContact;
    private String username;
    private UserDto idUser;
    private UserDto idContact;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private boolean status;
}
