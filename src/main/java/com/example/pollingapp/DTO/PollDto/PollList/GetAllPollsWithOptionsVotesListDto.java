package com.example.pollingapp.DTO.PollDto.PollList;

import com.example.pollingapp.DTO.VoteDto.Response.GetInfo.GetOptionVotesWithValues.GetOptionVotesWithValuesListDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPollsWithOptionsVotesListDto {
    private String pollName;
    private List<GetOptionVotesWithValuesListDto> options = new ArrayList<>();
}
