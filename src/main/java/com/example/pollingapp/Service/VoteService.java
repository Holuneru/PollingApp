package com.example.pollingapp.Service;

import com.example.pollingapp.Entity.Option;
import com.example.pollingapp.Entity.PollEntity.Poll;
import com.example.pollingapp.Entity.PollEntity.PollStatus;
import com.example.pollingapp.Entity.User;
import com.example.pollingapp.Entity.Vote;
import com.example.pollingapp.Repository.OptionRepository;
import com.example.pollingapp.Repository.PollRepository;
import com.example.pollingapp.Repository.UserRepository;
import com.example.pollingapp.Repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class VoteService {
    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final OptionRepository optionRepository;
    private final PollRepository pollRepository;

    public void voteCreate(Long userId, Long optionId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Option option = optionRepository.findById(optionId)
                .orElseThrow(() -> new RuntimeException("Option not found"));
        Poll poll = pollRepository.findById(option.getPoll().getId())
                .orElseThrow(() -> new RuntimeException("Poll not found"));

        if (poll.getStatus().equals(PollStatus.CLOSED)){
            throw new RuntimeException("Poll is closed");
        }

        if (voteRepository.checkOnVoteDouble(userId, optionId).isPresent()) {
            throw new RuntimeException("User has already voted for this option in this poll.");
        }

        Vote vote = new Vote();
        vote.setUser(user);
        vote.setOption(option);
        vote.setPoll(poll);
        voteRepository.save(vote);
        log.info("User {} voted for option {} in poll {}", userId, optionId, poll.getId());
    }

}
