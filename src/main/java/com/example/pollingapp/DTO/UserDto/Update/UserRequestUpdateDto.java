package com.example.pollingapp.DTO.UserDto.Update;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestUpdateDto {

    @NotBlank(message = "Username is required")
    private String oldUserName; //Нынешний username
    @NotBlank(message = "Email is required")
    private String password; //Нынешний пароль

    private String new_username;

    private String new_email;

    private String new_password;

}
