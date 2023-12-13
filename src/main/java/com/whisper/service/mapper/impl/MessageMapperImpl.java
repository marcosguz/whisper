package com.whisper.service.mapper.impl;

import com.whisper.model.Message;
import com.whisper.service.dto.MessageDto;
import com.whisper.service.mapper.MessageMapper;
import com.whisper.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageMapperImpl implements MessageMapper {

    private UserMapper userMapper;

    @Autowired
    public MessageMapperImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public MessageDto messageToMessageDto(Message message) {
        return new MessageDto(
                message.getIdMess(),
                userMapper.userToUserDto(message.getIdSender()),
                userMapper.userToUserDto(message.getIdReceiver()),
                message.getText(),
                message.getCreationDate(),
                message.getUpdateDate(),
                message.isStatus()
        );
    }

    @Override
    public Message messageDtoToMessage(MessageDto messageDto) {
        return new Message(
                messageDto.getIdMess(),
                userMapper.userDtoToUser(messageDto.getIdSender()),
                userMapper.userDtoToUser(messageDto.getIdReceiver()),
                messageDto.getText(),
                messageDto.getCreationDate(),
                messageDto.getUpdateDate(),
                messageDto.isStatus()
        );
    }
}
