package com.kodillalibrary.library.controller;

import com.kodillalibrary.library.domain.books.BooksDto;
import com.kodillalibrary.library.service.BooksDbService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/books")
public class BooksController {
    private final BooksDbService booksDbService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BooksDto> getBooks(){
        return booksDbService.getBooks();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BooksDto getBook(@PathVariable Long id){
        return booksDbService.getBook(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id){
        booksDbService.deleteBook(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BooksDto updateBook(@PathVariable Long id, @RequestBody BooksDto booksDto){
        return booksDbService.updateBook(id, booksDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody BooksDto booksDto){
        booksDbService.createBook(booksDto);
    }
}
