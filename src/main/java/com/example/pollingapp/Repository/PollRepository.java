package com.example.pollingapp.Repository;

import com.example.pollingapp.Entity.PollEntity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
}