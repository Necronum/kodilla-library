package com.kodillalibrary.library.domain.rents;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RentsDto {
    private Long id;
    private Long copyId;
    private Long readerId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
