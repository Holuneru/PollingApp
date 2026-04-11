package com.example.pollingapp.DTO.PollDto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollResponse {
    private String question;
    private String createdBy;
    private String createdAt;
    private String expiresAt;
    private String status;
}
