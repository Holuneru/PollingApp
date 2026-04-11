package com.example.pollingapp.Service;

import com.example.pollingapp.DTO.UserDto.Request.UserRequestDto;
import com.example.pollingapp.DTO.UserDto.Response.GetInfo.SimplePollList;
import com.example.pollingapp.DTO.UserDto.Response.GetInfo.UserPollListDto;
import com.example.pollingapp.DTO.UserDto.Response.UserResponseDto;
import com.example.pollingapp.Entity.User;
import com.example.pollingapp.Mappers.UserMapper;
import com.example.pollingapp.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public UserPollListDto getUserPollList(Long id){
        User user = userRepository.findWithPollList(id)
                .orElseThrow(
                        () -> new RuntimeException("User not found")
                );

        UserPollListDto userPollListDto = new UserPollListDto();
        userPollListDto.setUsername(user.getUsername());

        List<SimplePollList> polls = user.getPolls()
                .stream().map(p -> new SimplePollList(p.getId(), p.getQuestion()))
                .toList();

        userPollListDto.setPolls(polls);
        return userPollListDto;



    }
}
