package com.kodillalibrary.library.domain.books;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.Year;

@Data
@Builder
public class BooksDto {
    private Long id;
    private String title;
    private String author;
    private Year yearOfPublish;
}
