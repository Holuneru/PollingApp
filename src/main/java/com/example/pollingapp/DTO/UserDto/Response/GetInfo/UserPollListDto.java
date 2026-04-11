package com.example.pollingapp.DTO.UserDto.Response.GetInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPollListDto {
    private String username;
    private List<SimplePollList> polls = new ArrayList<>();
}
