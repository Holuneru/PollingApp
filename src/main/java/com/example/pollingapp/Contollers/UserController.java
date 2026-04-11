package com.example.pollingapp.Contollers;

import com.example.pollingapp.DTO.UserDto.Request.UserRequestDto;
import com.example.pollingapp.DTO.UserDto.Response.GetInfo.UserPollListDto;
import com.example.pollingapp.DTO.UserDto.Response.UserResponseDto;
import com.example.pollingapp.DTO.UserDto.Update.UserRequestUpdateDto;
import com.example.pollingapp.DTO.UserDto.Update.UserResponseUpdate;
import com.example.pollingapp.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(path = "/{id}/polls")
    public UserPollListDto getUserPollList(@PathVariable Long id) {

        return userService.getUserPollList(id);
    }



    @PostMapping(path = "/register")
    public UserResponseDto registerUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        return userService.registrationUser(userRequestDto);
    }

    @PostMapping(path = "/updateInfo")
    public UserResponseUpdate updateUserInfo(@RequestBody @Valid UserRequestUpdateDto userRequestUpdateDto){
        return userService.userUpdate(userRequestUpdateDto);
    }


}
