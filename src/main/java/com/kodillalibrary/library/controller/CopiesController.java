package com.kodillalibrary.library.controller;

import com.kodillalibrary.library.domain.copies.CopiesDto;
import com.kodillalibrary.library.service.CopiesDbService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/copies")
public class CopiesController {
    private final CopiesDbService copiesDbService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CopiesDto> getCopies(){
        return copiesDbService.getCopies();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CopiesDto getCopy(@PathVariable Long id){
        return copiesDbService.getCopy(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCopy(@PathVariable Long id){
        copiesDbService.deleteCopy(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CopiesDto updateCopy(@PathVariable Long id, @RequestBody CopiesDto copiesDto){
        return copiesDbService.updateCopy(id, copiesDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCopy(@RequestBody CopiesDto copiesDto){
        copiesDbService.createCopy(copiesDto);
    }
}
