package com.whisper.service;

import com.whisper.service.dto.UserContactDto;

import java.util.List;

public interface UserContactService {
    UserContactDto addContact(UserContactDto userContactDto);
    UserContactDto deleteContact(String idContact);
    List<UserContactDto> getContactsByUserId(String idUser);
}
