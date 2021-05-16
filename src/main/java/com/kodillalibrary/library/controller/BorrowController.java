package com.kodillalibrary.library.controller;

import com.kodillalibrary.library.domain.borrow.BorrowDto;
import com.kodillalibrary.library.domain.readers.ReadersDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/library")
public class BorrowController {
    public List<BorrowDto> getBorrow(){
        return new ArrayList<>();
    }

    public BorrowDto getBorrow(Long id){
        return new BorrowDto(1L, 1L, 1L,
                LocalDate.now(), LocalDate.of(2021,4,1));
    }

    public void deleteBorrow(Long id){

    }

    public BorrowDto updateBorrow(BorrowDto borrowDto){
        LocalDate borrowDate = borrowDto.getBorrowDate();
        return new BorrowDto(1L, 1L, 1L,
                borrowDate, LocalDate.of(2021,4,1));
    }

    public void createBorrow(BorrowDto borrowDto){

    }
}
