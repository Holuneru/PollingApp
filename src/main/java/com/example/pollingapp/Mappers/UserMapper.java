package com.example.pollingapp.Mappers;

import com.example.pollingapp.DTO.UserDto.Request.UserRequestDto;
import com.example.pollingapp.DTO.UserDto.Response.UserResponseDto;
import com.example.pollingapp.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    //User registration


    //UserRequestDto to User
    User userRequestDtoToUser(UserRequestDto userRequestDto);

    //User to UserResponseDto
    UserResponseDto userToUserResponseDto(User user);

}
