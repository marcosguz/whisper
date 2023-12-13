package com.whisper.service.impl;

import com.whisper.model.Message;
import com.whisper.model.User;
import com.whisper.repository.MessageRepository;
import com.whisper.repository.UserRepository;
import com.whisper.service.MessageService;
import com.whisper.service.dto.MessageDto;
import com.whisper.service.mapper.MessageMapper;
import com.whisper.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;
    private UserMapper userMapper;
    private UserRepository userRepository;
    private MessageMapper messageMapper;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, UserMapper userMapper,
                              MessageMapper messageMapper, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userMapper = userMapper;
        this.messageMapper = messageMapper;
        this.userRepository = userRepository;
    }

    @Override
    public MessageDto sender(MessageDto messageDto) {
        Optional<User> optionalUser = userRepository.isPresentUserById(messageDto.getIdReceiver().getIdUser());

        if (optionalUser.isEmpty()) {
            return null;
        }

        messageDto.setCreationDate(LocalDateTime.now());
        messageDto.setUpdateDate(LocalDateTime.now());
        return messageMapper.messageToMessageDto(messageRepository.save(messageMapper.messageDtoToMessage(messageDto)));
    }

    @Override
    public MessageDto editMessage(MessageDto messageDto) {
        Message message = messageRepository.isPresentMessageById(messageDto.getIdMess());

        message.setText(messageDto.getText());
        message.setUpdateDate(LocalDateTime.now());
        return messageMapper.messageToMessageDto(messageRepository.save(message));
    }

    @Override
    public List<MessageDto> messageList(String idUser) {
        return messageRepository.getMessagesListById(idUser).stream()
                .map(messageMapper::messageToMessageDto)
                .collect(Collectors.toList());
    }
}
