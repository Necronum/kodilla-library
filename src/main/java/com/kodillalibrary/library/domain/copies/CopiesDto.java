package com.kodillalibrary.library.domain.copies;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CopiesDto {
    private Long id;
    private Long titleId;
    private String status;
}
