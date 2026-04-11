package com.example.pollingapp.Service;

import com.example.pollingapp.DTO.PollDto.Request.PollRequest;
import com.example.pollingapp.DTO.PollDto.Response.PollResponse;
import com.example.pollingapp.Entity.PollEntity.Poll;
import com.example.pollingapp.Entity.PollEntity.PollStatus;
import com.example.pollingapp.Entity.User;
import com.example.pollingapp.Mappers.PollMapper;
import com.example.pollingapp.Repository.PollRepository;
import com.example.pollingapp.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class PollService {
    private final PollRepository pollRepository;
    private final PollMapper pollMapper;
    private final UserRepository userRepository;

    public PollResponse createPoll(PollRequest pollRequest) {
        User user = userRepository.findByUsername(pollRequest.getUsernameCreator())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Poll poll = pollMapper.pollRequestToPoll(pollRequest);
        poll.setCreatedAt(LocalDateTime.now());
        poll.setExpiresAt(LocalDateTime.now().plusDays(5));
        poll.setStatus(PollStatus.ACTIVE);
        poll.setCreatedBy(user);
        Poll savedPoll = pollRepository.save(poll);

        log.info("Poll with id: {} created successfully by user: {}", savedPoll.getId(), user.getUsername());
        return new PollResponse(savedPoll.getQuestion(),
                savedPoll.getCreatedAt(),
                savedPoll.getExpiresAt(),
                savedPoll.getStatus());


    }

}
