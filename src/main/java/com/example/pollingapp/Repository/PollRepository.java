package com.example.pollingapp.Repository;

import com.example.pollingapp.Entity.PollEntity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
    @Query("SELECT p FROM Poll p LEFT JOIN FETCH p.options WHERE p.id = :pollId")
    Optional<Poll> findWithOptions(@Param("pollId") Long pollId);
}