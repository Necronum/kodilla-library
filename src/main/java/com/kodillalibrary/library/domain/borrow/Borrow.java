package com.kodillalibrary.library.domain.borrow;

import java.time.LocalDate;

public class Borrow {
    private Long id;
    private Long copyId;
    private Long readerId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
