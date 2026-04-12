package com.example.pollingapp.Contollers;

import com.example.pollingapp.DTO.VoteDto.Response.GetInfo.GetOptionVotesWithValues.PollVotesWithValueDto;
import com.example.pollingapp.DTO.VoteDto.Response.GetInfo.UserVoteListDto;
import com.example.pollingapp.Service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/votes")
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;


    @GetMapping(path = "/user/{userId}/list")
    public UserVoteListDto getUserVoteList(@PathVariable Long userId){
        return voteService.getUserVoteList(userId);
    }


    @GetMapping(path = "/poll/{pollId}/options/values")
    public PollVotesWithValueDto getOptionsValuesByPoll(@PathVariable Long pollId){
        return voteService.getValueOptionsByPoll(pollId);
    }


    @PostMapping(path = "/create")
    public ResponseEntity<String> createVote(@RequestParam Long userId, @RequestParam Long optionId) {
        voteService.voteCreate(userId, optionId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Vote registered successfully");
    }

    @DeleteMapping(path = "/user/{userId}/option/{optionId}/cancelVote")
    public ResponseEntity<String> cancelVote(@PathVariable Long userId, @PathVariable Long optionId){
        voteService.cancelVote(userId,optionId);
        return ResponseEntity.ok("Vote canceled successfully");
    }

}
