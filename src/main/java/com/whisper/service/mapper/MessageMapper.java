package com.whisper.service.mapper;

import com.whisper.model.Message;
import com.whisper.service.dto.MessageDto;

public interface MessageMapper {
    MessageDto messageToMessageDto(Message message);
    Message messageDtoToMessage(MessageDto messageDto);
}
