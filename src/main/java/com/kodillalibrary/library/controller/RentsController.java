package com.kodillalibrary.library.controller;

import com.kodillalibrary.library.domain.rents.RentsDto;
import com.kodillalibrary.library.service.RentsDbService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/rents")
public class RentsController {
    private final RentsDbService rentsDbService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RentsDto> getRents(){
        return rentsDbService.getRents();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RentsDto getRent(@PathVariable Long id){
        return rentsDbService.getRent(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRent(@PathVariable Long id){
        rentsDbService.deleteRent(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public RentsDto updateRent(@PathVariable Long id, @RequestBody RentsDto rentsDto){
        return rentsDbService.updateRent(id, rentsDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRent(@RequestBody RentsDto rentsDto){
        rentsDbService.createRent(rentsDto);
    }
}
