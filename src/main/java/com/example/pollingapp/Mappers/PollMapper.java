package com.example.pollingapp.Mappers;

import com.example.pollingapp.DTO.PollDto.Request.PollRequest;
import com.example.pollingapp.Entity.PollEntity.Poll;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PollMapper {
    Poll pollRequestToPoll(PollRequest pollRequest);

}
