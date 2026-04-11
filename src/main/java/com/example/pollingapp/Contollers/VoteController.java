package com.example.pollingapp.Contollers;

import com.example.pollingapp.Service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/votes")
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;

    @PostMapping(path = "/create")
    public ResponseEntity<String> createVote(@RequestParam Long userId, @RequestParam Long optionId) {
        voteService.voteCreate(userId, optionId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Vote registered successfully");
    }

}
