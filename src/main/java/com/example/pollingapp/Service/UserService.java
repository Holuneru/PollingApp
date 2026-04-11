package com.example.pollingapp.Service;

import com.example.pollingapp.DTO.UserDto.Request.UserRequestDto;
import com.example.pollingapp.DTO.UserDto.Response.GetInfo.SimplePollList;
import com.example.pollingapp.DTO.UserDto.Response.GetInfo.UserPollListDto;
import com.example.pollingapp.DTO.UserDto.Response.UserResponseDto;
import com.example.pollingapp.DTO.UserDto.Update.UserRequestUpdateDto;
import com.example.pollingapp.DTO.UserDto.Update.UserResponseUpdate;
import com.example.pollingapp.Entity.User;
import com.example.pollingapp.Mappers.UserMapper;
import com.example.pollingapp.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Transactional
    public UserResponseUpdate userUpdate(UserRequestUpdateDto userRequestUpdateDto){
        User user = userRepository.authenticationUser(
                userRequestUpdateDto.getOldUserName(),
                userRequestUpdateDto.getPassword()
        ).orElseThrow(() -> new RuntimeException("User not found"));

        UserResponseUpdate updateResponse = new UserResponseUpdate();

        if (userRequestUpdateDto.getNew_username() != null && !userRequestUpdateDto.getNew_username().isBlank()) {

            Optional<User> checkUsername = userRepository.findByUsername(userRequestUpdateDto.getNew_username());

            if (checkUsername.isPresent()) {
                updateResponse.setNewUsername("Username already exists");
            }else {
                user.setUsername(userRequestUpdateDto.getNew_username());
                updateResponse.setNewUsername(userRequestUpdateDto.getNew_username());
            }

        }

        if (userRequestUpdateDto.getNew_email() != null && !userRequestUpdateDto.getNew_email().isBlank()) {
            Optional<User> checkEmail = userRepository.findByEmail(userRequestUpdateDto.getNew_email());
            if (checkEmail.isPresent() && !Objects.equals(checkEmail.get().getId(), user.getId())) {
                updateResponse.setNewEmail("Email already exists");
            }else {
                user.setEmail(userRequestUpdateDto.getNew_email());
                updateResponse.setNewEmail(userRequestUpdateDto.getNew_email());
            }

        }

        if (userRequestUpdateDto.getNew_password() != null && !userRequestUpdateDto.getNew_password().isBlank()) {
            user.setPassword(userRequestUpdateDto.getNew_password());
        }

        userRepository.save(user);
        log.info("User with id: {} updated successfully", user.getId());

        return updateResponse;

    }

}
