package com.whisper.service;

import com.whisper.service.dto.MessageDto;

import java.util.List;

public interface MessageService {
    MessageDto sender(MessageDto messageDto);
    MessageDto editMessage(MessageDto messageDto);
    List<MessageDto> messageList(String idUser);
}
