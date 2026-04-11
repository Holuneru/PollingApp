package com.example.pollingapp.DTO.UserDto.Response.GetInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimplePollList {
    private Long id;
    private String question;
}
