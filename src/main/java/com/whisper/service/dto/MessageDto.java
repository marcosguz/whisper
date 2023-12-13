package com.whisper.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessageDto {
    private String idMess;
    private UserDto idSender;
    private UserDto idReceiver;
    private String text;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private boolean status;
}
