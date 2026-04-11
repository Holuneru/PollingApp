package com.example.pollingapp.Mappers;

import com.example.pollingapp.DTO.OptionDto.Response.OptionResponse;
import com.example.pollingapp.Entity.Option;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OptionMapper {
    OptionResponse toResponse(Option option);
}
