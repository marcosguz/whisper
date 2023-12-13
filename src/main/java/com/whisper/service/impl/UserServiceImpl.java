package com.whisper.service.impl;

import com.whisper.model.User;
import com.whisper.repository.UserRepository;
import com.whisper.security.Encryption;
import com.whisper.service.UserService;
import com.whisper.service.dto.UserDto;
import com.whisper.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {

        Optional<User> optionalUser = userRepository.isPresentUserByEmail(userDto.getEmail());
        if (optionalUser.isPresent()) {
            return null;
        }

        userDto.setPassword(Encryption.aesEncrypt(userDto.getPassword(), false));
        userDto.setCreationDate(LocalDateTime.now());
        userDto.setUpdateDate(LocalDateTime.now());
        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(userDto)));
    }

    //TODO Revisar cuando se suba una imagen
    @Override
    public UserDto updateUser(UserDto userDto) {
        Optional<User> user = userRepository.findById(userDto.getIdUser());
        if (user.isPresent()) {
            userDto.setPassword(Encryption.aesEncrypt(userDto.getPassword(), false));
            userDto.setUpdateDate(LocalDateTime.now());
            return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(userDto)));
        }
        return null;
    }
    //TODO FIN
}
