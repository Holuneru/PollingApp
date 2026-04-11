package com.example.pollingapp.Service.Schedulers;

import com.example.pollingapp.Entity.PollEntity.Poll;
import com.example.pollingapp.Entity.PollEntity.PollStatus;
import com.example.pollingapp.Repository.PollRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PollScheduler {

    private final PollRepository pollRepository;

    public PollScheduler(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Scheduled(cron = "0 0 1 * * ?") // Runs at 1 AM every day
    public void closeExpiredPolls() {
        List<Poll> activePolls = pollRepository.findOnlyACTIVE();
        LocalDateTime now = LocalDateTime.now();

        for (Poll poll : activePolls) {
            if (now.isAfter(poll.getExpiresAt())) {
                poll.setStatus(PollStatus.CLOSED);
                pollRepository.save(poll);
            }
        }
    }
}
