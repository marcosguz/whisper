package com.whisper.service.mapper.impl;

import com.whisper.model.User;
import com.whisper.service.dto.UserDto;
import com.whisper.service.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDto userToUserDto(User user) {
        return new UserDto(
                user.getIdUser(),
                user.getUsername(),
                user.getName(),
                user.getSurname(),
                user.getAge(),
                user.getGender(),
                user.getPhone(),
                user.getEmail(),
                user.getPassword(),
                user.getCreationDate(),
                user.getUpdateDate(),
                user.isStatus(),
                user.getProfileImage()
        );
    }

    @Override
    public User userDtoToUser(UserDto userDto) {
        return new User(
                userDto.getIdUser(),
                userDto.getUsername(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getAge(),
                userDto.getGender(),
                userDto.getPhone(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getCreationDate(),
                userDto.getUpdateDate(),
                userDto.isStatus(),
                userDto.getProfileImage()
        );
    }
}
