package com.kodillalibrary.library.mapper;

import com.kodillalibrary.library.domain.books.Books;
import com.kodillalibrary.library.domain.books.BooksDto;
import com.kodillalibrary.library.domain.copies.Copies;
import com.kodillalibrary.library.domain.readers.Readers;
import com.kodillalibrary.library.domain.readers.ReadersDto;
import com.kodillalibrary.library.exception.ResourceNotFoundException;
import com.kodillalibrary.library.repository.CopiesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BooksMapper {
    private final CopiesRepository copiesRepository;

    public BooksDto mapToBooksDto(Books book){
        return BooksDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .yearOfPublish(book.getYearOfPublish())
                .copiesId(book.getCopiesList().stream()
                    .map(Copies::getId)
                    .collect(Collectors.toList()))
                .build();
    }

    public List<BooksDto> mapToBooksDtoList(List<Books> books){
        return books
                .stream()
                .map(this::mapToBooksDto)
                .collect(Collectors.toList());
    }

    public Books mapToBooks(BooksDto booksDto) throws ResourceNotFoundException {
        return Books.builder()
                .copiesList(booksDto.getCopiesId().stream()
                        .map(copiesRepository::findById)
                        .map(Optional::get)
                        .collect(Collectors.toList()))
                .build();
    }
}
