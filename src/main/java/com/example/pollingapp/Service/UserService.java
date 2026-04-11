package com.example.pollingapp.Service;

import com.example.pollingapp.DTO.UserDto.Request.UserRequestDto;
import com.example.pollingapp.DTO.UserDto.Response.UserResponseDto;
import com.example.pollingapp.Entity.User;
import com.example.pollingapp.Mappers.UserMapper;
import com.example.pollingapp.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserResponseDto registrationUser(UserRequestDto userRequestDto){
        User user = userMapper.userRequestDtoToUser(userRequestDto);
        User saved = userRepository.save(user);
        return userMapper.userToUserResponseDto(saved);
    }
}
