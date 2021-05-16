package com.kodillalibrary.library.mapper;

import com.kodillalibrary.library.domain.copies.Copies;
import com.kodillalibrary.library.domain.copies.CopiesDto;
import com.kodillalibrary.library.exception.ResourceNotFoundException;
import com.kodillalibrary.library.repository.BooksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CopiesMapper {
    private final BooksRepository booksRepository;

    public CopiesDto mapToCopiesDto(Copies copy){
        return CopiesDto.builder()
                .id(copy.getId())
                .titleId(copy.getBook().getId())
                .status(copy.getStatus().toString())
                .build();
    }

    public List<CopiesDto> mapToCopiesDtoList(List<Copies> copies){
        return copies
                .stream()
                .map(this::mapToCopiesDto)
                .collect(Collectors.toList());
    }

    public Copies mapToCopy(CopiesDto copiesDto) {
        return Copies.builder()
                .book(booksRepository.findById(copiesDto.getTitleId())
                        .orElseThrow(() -> new ResourceNotFoundException("User with id: " + copiesDto.getTitleId() + " not found")))
                .build();
    }
}
