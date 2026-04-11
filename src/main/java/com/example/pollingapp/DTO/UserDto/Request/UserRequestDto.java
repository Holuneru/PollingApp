package com.example.pollingapp.DTO.UserDto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    @NotBlank(message = "Username cannot be empty")
    @Size(max = 25, message = "Username must not exceed 25 characters")
    private String username;
    @NotBlank(message = "Email cannot be empty")
    @Size(max = 50, message = "Email must not exceed 50 characters")
    private String email;
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, max = 64, message = "Password must be between 6 and 64 characters")
    private String password;

}
