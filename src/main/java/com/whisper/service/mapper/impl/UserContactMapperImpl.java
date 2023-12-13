package com.whisper.service.mapper.impl;

import com.whisper.model.UserContact;
import com.whisper.service.dto.UserContactDto;
import com.whisper.service.mapper.UserContactMapper;
import com.whisper.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserContactMapperImpl implements UserContactMapper {

    private UserMapper userMapper;

    @Autowired
    public UserContactMapperImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserContactDto userContactToUserContactDto(UserContact userContact) {
        return new UserContactDto(
                userContact.getIdUserContact(),
                userContact.getUsername(),
                userMapper.userToUserDto(userContact.getIdUser()),
                userMapper.userToUserDto(userContact.getIdCont()),
                userContact.getCreationDate(),
                userContact.getUpdateDate(),
                userContact.isStatus()
        );
    }

    @Override
    public UserContact userContactDtoToUserContact(UserContactDto userContactDto) {
        return new UserContact(
                userContactDto.getIdUserContact(),
                userContactDto.getUsername(),
                userMapper.userDtoToUser(userContactDto.getIdUser()),
                userMapper.userDtoToUser(userContactDto.getIdContact()),
                userContactDto.getCreationDate(),
                userContactDto.getUpdateDate(),
                userContactDto.isStatus()
        );
    }
}
