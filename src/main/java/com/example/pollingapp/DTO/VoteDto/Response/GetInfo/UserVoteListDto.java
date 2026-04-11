package com.example.pollingapp.DTO.VoteDto.Response.GetInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVoteListDto {
    private String username;
    private List<SimpleVoteDto> votes = new ArrayList<>();
}
