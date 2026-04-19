package com.example.pollingapp.Service;

import com.example.pollingapp.DTO.OptionDto.Request.OptionRequestDto;
import com.example.pollingapp.DTO.OptionDto.Response.OptionResponse;
import com.example.pollingapp.Entity.Option;
import com.example.pollingapp.Entity.PollEntity.Poll;
import com.example.pollingapp.Entity.PollEntity.PollStatus;
import com.example.pollingapp.Mappers.OptionMapper;
import com.example.pollingapp.Repository.OptionRepository;
import com.example.pollingapp.Repository.PollRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OptionService {
    private final OptionRepository optionRepository;
    private final PollRepository pollRepository;
    private final OptionMapper optionMapper;

    public void addOption(OptionRequestDto optionRequestDto){

        Poll poll = pollRepository.findWithOptions(optionRequestDto.getPollId())
                .orElseThrow(
                        () -> new RuntimeException("Poll not found with ID: " + optionRequestDto.getPollId())
                );



        if (poll.getStatus().equals(PollStatus.CLOSED)){
            throw new RuntimeException("Poll is closed");
        }

        Option option = new Option();
        option.setText(optionRequestDto.getText());
        option.setPoll(poll);
        optionRepository.save(option);
        log.info("Option added successfully");
    }

    public List<OptionResponse> getAllOptionByPoll(Long pollId){
        Poll poll = pollRepository.findWithOptions(pollId)
                .orElseThrow(
                        () -> new RuntimeException("Poll not found with ID: " + pollId)
                );

        if (poll.getStatus().equals(PollStatus.CLOSED)){
            throw new RuntimeException("Poll is closed");
        }

        return poll.getOptions().stream()
                .map(optionMapper::toResponse)
                .toList();


    }
}
