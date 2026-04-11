package com.example.pollingapp.DTO.UserDto.Update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseUpdate {
    private String newUsername;
    private String newEmail;
}
