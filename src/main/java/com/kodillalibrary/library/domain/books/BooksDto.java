package com.kodillalibrary.library.domain.books;

import lombok.Builder;
import lombok.Data;

import java.time.Year;
import java.util.List;

@Data
@Builder
public class BooksDto {
    private Long id;
    private String title;
    private String author;
    private Year yearOfPublish;
    private List<Long> copiesId;
}
