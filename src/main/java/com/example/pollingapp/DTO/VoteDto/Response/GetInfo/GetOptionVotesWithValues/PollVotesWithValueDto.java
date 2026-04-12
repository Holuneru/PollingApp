package com.example.pollingapp.DTO.VoteDto.Response.GetInfo.GetOptionVotesWithValues;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollVotesWithValueDto {
    private String pollQuestion;
    private List<GetOptionVotesWithValuesListDto> optionVotesWithValuesList = new ArrayList<>();
}
