package com.kodillalibrary.library.mapper;

import com.kodillalibrary.library.domain.rents.Rents;
import com.kodillalibrary.library.domain.rents.RentsDto;
import com.kodillalibrary.library.exception.ResourceNotFoundException;
import com.kodillalibrary.library.repository.CopiesRepository;
import com.kodillalibrary.library.repository.ReadersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentsMapper {
    private final CopiesRepository copiesRepository;
    private final ReadersRepository readersRepository;

    public RentsDto mapToRentsDto(Rents rent){
        return RentsDto.builder()
                .id(rent.getId())
                .copyId(rent.getCopy().getId())
                .readerId(rent.getReader().getId())
                .borrowDate(rent.getBorrowDate())
                .returnDate(rent.getReturnDate())
                .build();
    }

    public List<RentsDto> mapToRentsDtoList(List<Rents> rents){
        return rents
                .stream()
                .map(this::mapToRentsDto)
                .collect(Collectors.toList());
    }

    public Rents mapToRents(RentsDto rentsDto) {
        return Rents.builder()
                .copy(copiesRepository.findById(rentsDto.getCopyId())
                        .orElseThrow(() -> new ResourceNotFoundException("User with id: " + rentsDto.getCopyId() + " not found")))
                .reader(readersRepository.findById(rentsDto.getReaderId())
                        .orElseThrow(() -> new ResourceNotFoundException("Cart with id: " + rentsDto.getReaderId() + " not found")))
                .build();
    }
}
