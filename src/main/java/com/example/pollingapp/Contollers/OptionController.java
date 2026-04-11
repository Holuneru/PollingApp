package com.example.pollingapp.Contollers;

import com.example.pollingapp.DTO.OptionDto.Request.OptionRequestDto;
import com.example.pollingapp.DTO.OptionDto.Response.OptionResponse;
import com.example.pollingapp.Service.OptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/options")
@RequiredArgsConstructor
public class OptionController {
    private final OptionService optionService;

    @PostMapping(path = "/add")
    public ResponseEntity<String> addOption(@RequestBody @Valid OptionRequestDto optionRequestDto){
        optionService.addOption(optionRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Option added successfully");
    }

    @GetMapping(path = "/poll/{pollId}")
    public List<OptionResponse> getAllOptionsByPoll(@PathVariable Long pollId){
        return optionService.getAllOptionByPoll(pollId);
    }

}
