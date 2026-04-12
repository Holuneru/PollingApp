package com.example.pollingapp.Repository;

import com.example.pollingapp.Entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Query("SELECT v FROM Vote v WHERE v.user.id = :userId AND v.option.id = :optionId")
    Optional<Vote> checkOnVoteDouble(@Param("userId") Long userId, @Param("optionId") Long optionId);

    @Query("SELECT COUNT(v) FROM Vote v WHERE v.option.id = :optionId")
    Long countVotesByOptionId(@Param("optionId") Long optionId);


//    @Query("SELECT COUNT(v) FROM Vote v WHERE v.poll.id = :pollId")
//    Long countVotesByPollId(@Param("pollId") Long pollId);
}