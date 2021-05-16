package com.kodillalibrary.library.controller;

import com.kodillalibrary.library.domain.books.BooksDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/library")
public class BooksController {
    public List<BooksDto> getBook(){
        return new ArrayList<>();
    }

    public BooksDto getBook(Long id){
        return new BooksDto(1L, "Mack", "Milan", Year.of(1999));
    }

    public void deleteBook(Long id){

    }

    public BooksDto updateBook(BooksDto booksDto){
        Year publishDate = booksDto.getYearOfPublish();
        return new BooksDto(1L, "Edited", "Edited", publishDate);
    }

    public void createBook(BooksDto booksDto){

    }
}
