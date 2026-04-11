package com.example.pollingapp.Repository;

import com.example.pollingapp.Entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    @Query("SELECT o FROM Option o LEFT JOIN FETCH o.poll WHERE o.id = :id")
    Optional<Option> findWithPoll(@Param("id") Long id);
}