package com.example.pollingapp.DTO.VoteDto.Response.GetInfo.GetOptionVotesWithValues;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOptionVotesWithValuesListDto {
    private String optionText;
    private Long voteCount;
}
