package com.kodillalibrary.library.service;

import com.kodillalibrary.library.domain.copies.Copies;
import com.kodillalibrary.library.domain.copies.CopiesDto;
import com.kodillalibrary.library.exception.ResourceNotFoundException;
import com.kodillalibrary.library.mapper.CopiesMapper;
import com.kodillalibrary.library.repository.CopiesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CopiesDbService {
    private final CopiesMapper copiesMapper;
    private final CopiesRepository copiesRepository;

    public List<CopiesDto> getCopies(){
        List<Copies> copies = copiesRepository.findAll();
        return copiesMapper.mapToCopiesDtoList(copies);
    }

    public CopiesDto getCopy(Long id){
        return copiesRepository.findById(id)
                .map(copiesMapper::mapToCopiesDto)
                .orElseThrow(() -> new ResourceNotFoundException("Copy with id: " + id + " not found"));
    }

    public void deleteCopy(Long id){
        copiesRepository.deleteById(id);
    }

    public CopiesDto updateCopy(Long id, CopiesDto copiesDto){
        return copiesRepository.findById(id).map(copies -> {
            Copies updatedCopy = copiesMapper.mapToCopy(copiesDto);
            copiesRepository.save(updatedCopy);
            return copiesMapper.mapToCopiesDto(updatedCopy);
        }).orElseThrow(() -> new ResourceNotFoundException("Copy with id: " + id + " not found"));
    }

    public void createCopy(CopiesDto copiesDto) {
        copiesRepository.save(copiesMapper.mapToCopy(copiesDto));
    }
}
