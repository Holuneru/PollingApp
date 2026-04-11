package com.example.pollingapp.DTO.PollDto.Request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollRequest {
    @NotBlank(message = "Question cannot be empty")
    @Size(max = 255, message = "Question must not exceed 255 characters")
    private String question;

    @NotBlank(message = "Username cannot be empty")
    private String usernameCreator;

    @NotNull
    @Positive
    @Max(value = 31, message = "Validity period cannot exceed 31 days")
    private Integer validityPeriodDay;



}
