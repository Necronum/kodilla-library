package com.kodillalibrary.library.domain.readers;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ReadersDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate creationDate;
    private List<Long> rentsId;
}
