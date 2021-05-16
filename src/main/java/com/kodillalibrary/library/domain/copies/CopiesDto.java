package com.kodillalibrary.library.domain.copies;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CopiesDto {
    private Long id;
    private Long titleId;
    private String status;
}
