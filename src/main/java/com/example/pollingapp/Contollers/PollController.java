package com.example.pollingapp.Contollers;

import com.example.pollingapp.DTO.PollDto.Request.PollRequest;
import com.example.pollingapp.DTO.PollDto.Response.PollResponse;
import com.example.pollingapp.Service.PollService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/polls")
@RequiredArgsConstructor
public class PollController {
    private final PollService pollService;

    @PostMapping(path = "/create")
    public PollResponse createPoll(@RequestBody @Valid PollRequest pollRequest) {
        return pollService.createPoll(pollRequest);
    }
}
