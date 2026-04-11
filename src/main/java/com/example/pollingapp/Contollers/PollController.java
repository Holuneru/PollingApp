package com.example.pollingapp.Contollers;

import com.example.pollingapp.DTO.PollDto.Request.PollRequest;
import com.example.pollingapp.DTO.PollDto.Response.PollResponse;
import com.example.pollingapp.Service.PollService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/polls")
@RequiredArgsConstructor
public class PollController {
    private final PollService pollService;

    @PostMapping(path = "/create")
    public PollResponse createPoll(@RequestBody @Valid PollRequest pollRequest) {
        return pollService.createPoll(pollRequest);
    }

    @PutMapping(path = "/close/poll/{pollId}/owner/{ownerId}")
    public ResponseEntity<String> closePoll(@PathVariable Long pollId, @PathVariable Long ownerId){
        pollService.closePoll(pollId, ownerId);
        return ResponseEntity.ok("Poll closed successfully");
    }

}
