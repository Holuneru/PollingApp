package com.example.pollingapp.DTO.VoteDto.Response.GetInfo.GetSumVotesInPoll;

import lombok.Data;

@Data
public class SumVotesInPollDto {
    private String pollName;
    private Long votesSum;
}
