package com.whisper.service.impl;

import com.whisper.model.User;
import com.whisper.model.UserContact;
import com.whisper.repository.UserContactRepository;
import com.whisper.repository.UserRepository;
import com.whisper.service.UserContactService;
import com.whisper.service.dto.UserContactDto;
import com.whisper.service.mapper.UserContactMapper;
import com.whisper.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserContactServiceImpl implements UserContactService {

    private UserContactRepository userContactRepository;
    private UserContactMapper userContactMapper;
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserContactServiceImpl(UserContactRepository userContactRepository, UserContactMapper userContactMapper,
                                  UserRepository userRepository, UserMapper userMapper) {
        this.userContactRepository = userContactRepository;
        this.userContactMapper = userContactMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserContactDto addContact(UserContactDto userContactDto) {
        UserContact contact = userContactRepository.getUserContact(userContactDto.getUsername());

        if (contact == null) {
            userContactDto.setCreationDate(LocalDateTime.now());
            userContactDto.setUpdateDate(LocalDateTime.now());
            userContactDto.setStatus(true);
            return userContactMapper.userContactToUserContactDto(userContactRepository.save(userContactMapper.userContactDtoToUserContact(userContactDto)));
        } else {
            if (contact.getUsername().toUpperCase().trim().equalsIgnoreCase(userContactDto.getUsername().toUpperCase().trim())) {
                contact.setUpdateDate(LocalDateTime.now());
                contact.setStatus(true);
                return userContactMapper.userContactToUserContactDto(userContactRepository.save(contact));
            }
        }
        return null;
    }

    @Override
    public UserContactDto deleteContact(String idContact) {
        UserContact contact = userContactRepository.deleteContact(idContact);
        contact.setStatus(false);
        contact.setUpdateDate(LocalDateTime.now());
        return userContactMapper.userContactToUserContactDto(userContactRepository.save(contact));
    }

    @Override
    public List<UserContactDto> getContactsByUserId(String idUser) {
        return userContactRepository.getContacts(idUser).stream()
                .map(userContactMapper::userContactToUserContactDto)
                .collect(Collectors.toList());
    }
}
