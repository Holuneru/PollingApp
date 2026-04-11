package com.example.pollingapp.Contollers;

import com.example.pollingapp.DTO.OptionDto.Request.OptionRequestDto;
import com.example.pollingapp.Service.OptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
