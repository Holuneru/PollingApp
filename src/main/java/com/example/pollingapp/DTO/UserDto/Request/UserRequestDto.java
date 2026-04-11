package com.example.pollingapp.DTO.UserDto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotBlank
    @Size(max = 25)
    private String username;
    @NotBlank
    @Size(max = 50)
    private String email;
    @NotBlank
    @Size(max = 64)
    private String password;

}
