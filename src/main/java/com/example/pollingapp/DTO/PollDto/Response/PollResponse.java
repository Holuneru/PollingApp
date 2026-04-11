package com.example.pollingapp.DTO.PollDto.Response;

import com.example.pollingapp.Entity.PollEntity.PollStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollResponse {
    private String question;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private PollStatus status;
}
