package com.example.pollingapp.Service;

import com.example.pollingapp.DTO.UserDto.Request.UserRequestDto;
import com.example.pollingapp.DTO.UserDto.Response.UserResponseDto;
import com.example.pollingapp.Entity.User;
import com.example.pollingapp.Mappers.UserMapper;
import com.example.pollingapp.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserResponseDto registrationUser(UserRequestDto userRequestDto){
        User user = userMapper.userRequestDtoToUser(userRequestDto);
        User saved = userRepository.save(user);
        log.info("User with id: {} registered successfully", saved.getId());
        return userMapper.userToUserResponseDto(saved);
    }
}
