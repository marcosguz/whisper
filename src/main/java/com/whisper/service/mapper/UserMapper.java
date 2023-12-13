package com.whisper.service.mapper;

import com.whisper.model.User;
import com.whisper.service.dto.UserDto;

public interface UserMapper {
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
