package com.example.pollingapp.DTO.VoteDto.Response.GetInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleVoteDto {
    private String pollQuestion;
    private String optionText;
}
