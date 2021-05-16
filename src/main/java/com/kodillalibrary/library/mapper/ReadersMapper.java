package com.kodillalibrary.library.mapper;

import com.kodillalibrary.library.domain.copies.Copies;
import com.kodillalibrary.library.domain.copies.CopiesDto;
import com.kodillalibrary.library.domain.readers.Readers;
import com.kodillalibrary.library.domain.readers.ReadersDto;
import com.kodillalibrary.library.domain.rents.Rents;
import com.kodillalibrary.library.exception.ResourceNotFoundException;
import com.kodillalibrary.library.repository.RentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReadersMapper {
    private final RentsRepository rentsRepository;

    public ReadersDto mapToReadersDto(Readers readers){
        return ReadersDto.builder()
                .id(readers.getId())
                .firstName(readers.getFirstName())
                .lastName(readers.getLastName())
                .creationDate(readers.getCreationDate())
                .rentsId(readers.getRentsList().stream()
                        .map(Rents::getId)
                        .collect(Collectors.toList()))
                .build();
    }

    public List<ReadersDto> mapToReadersDtoList(List<Readers> readers){
        return readers
                .stream()
                .map(this::mapToReadersDto)
                .collect(Collectors.toList());
    }

    public Readers mapToReaders(ReadersDto readersDto) throws ResourceNotFoundException{
        return Readers.builder()
                .rentsList(readersDto.getRentsId().stream()
                    .map(rentsRepository::findById)
                    .map(Optional::get)
                    .collect(Collectors.toList()))
                .build();
    }
}
