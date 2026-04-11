package com.example.pollingapp.DTO.OptionDto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OptionRequestDto {
    @NotBlank(message = "Text cannot be empty")
    private String text;
    @NotNull(message = "Poll ID cannot be null")
    private Long pollId;
}
