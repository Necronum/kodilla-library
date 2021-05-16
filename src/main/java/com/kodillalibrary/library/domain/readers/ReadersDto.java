package com.kodillalibrary.library.domain.readers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ReadersDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate creationDate;
}
