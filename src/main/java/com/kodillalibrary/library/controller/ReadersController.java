package com.kodillalibrary.library.controller;

import com.kodillalibrary.library.domain.readers.ReadersDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/library")
public class ReadersController {
    public List<ReadersDto> getReaders(){
        return new ArrayList<>();
    }

    public ReadersDto getReader(Long id){
        return new ReadersDto(1L, "Mack", "Milan", LocalDate.now());
    }

    public void deleteReader(Long id){

    }

    public ReadersDto updateReader(ReadersDto readersDto){
        LocalDate creationDate = readersDto.getCreationDate();
        return new ReadersDto(1L, "Edited", "Edited", creationDate);
    }

    public void createReader(ReadersDto readersDto){

    }
}
