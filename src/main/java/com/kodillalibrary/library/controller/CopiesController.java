package com.kodillalibrary.library.controller;

import com.kodillalibrary.library.domain.copies.CopiesDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/library")
public class CopiesController {
    public List<CopiesDto> getCopies(){
        return new ArrayList<>();
    }

    public CopiesDto getCopy(Long id){
        return new CopiesDto(1L, 1L, "borrowed");
    }

    public void deleteCopy(Long id){

    }

    public CopiesDto updateCopy(CopiesDto copiesDto){
        return new CopiesDto(1L, 1L, "lost");
    }

    public void createCopy(CopiesDto copiesDto){

    }
}
