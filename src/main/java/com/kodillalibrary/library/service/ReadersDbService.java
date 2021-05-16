package com.kodillalibrary.library.service;

import com.kodillalibrary.library.domain.readers.Readers;
import com.kodillalibrary.library.domain.readers.ReadersDto;
import com.kodillalibrary.library.exception.ResourceNotFoundException;
import com.kodillalibrary.library.mapper.ReadersMapper;
import com.kodillalibrary.library.repository.ReadersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ReadersDbService {
    private final ReadersRepository readersRepository;
    private final ReadersMapper readersMapper;

    public List<ReadersDto> getReaders(){
        List<Readers> readers = readersRepository.findAll();
        return readersMapper.mapToReadersDtoList(readers);
    }

    public ReadersDto getReader(Long id){
        return readersRepository.findById(id)
                .map(readersMapper::mapToReadersDto)
                .orElseThrow(() -> new ResourceNotFoundException("Reader with id: " + id + " not found"));
    }

    public void deleteReader(Long id){
        readersRepository.deleteById(id);
    }

    public ReadersDto updateReader(Long id, ReadersDto readersDto){
        return readersRepository.findById(id).map(readers -> {
            Readers updatedReader = readersMapper.mapToReaders(readersDto);
            readersRepository.save(updatedReader);
            return readersMapper.mapToReadersDto(updatedReader);
        }).orElseThrow(() -> new ResourceNotFoundException("Reader with id: " + id + " not found"));
    }

    public void createReader(ReadersDto readersDto) {
        readersRepository.save(readersMapper.mapToReaders(readersDto));
    }
}
