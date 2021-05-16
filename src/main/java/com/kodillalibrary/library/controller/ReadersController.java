package com.kodillalibrary.library.controller;

import com.kodillalibrary.library.domain.readers.ReadersDto;
import com.kodillalibrary.library.service.ReadersDbService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/readers")
public class ReadersController {
    private final ReadersDbService readersDbService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReadersDto> getReaders(){
        return readersDbService.getReaders();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReadersDto getReader(@PathVariable Long id){
        return readersDbService.getReader(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReader(@PathVariable Long id){
        readersDbService.deleteReader(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ReadersDto updateReader(@PathVariable Long id, @RequestBody ReadersDto readersDto){
        return readersDbService.updateReader(id, readersDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createReader(@RequestBody ReadersDto readersDto){
        readersDbService.createReader(readersDto);
    }
}
