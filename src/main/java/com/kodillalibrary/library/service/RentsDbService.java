package com.kodillalibrary.library.service;

import com.kodillalibrary.library.domain.rents.Rents;
import com.kodillalibrary.library.domain.rents.RentsDto;
import com.kodillalibrary.library.exception.ResourceNotFoundException;
import com.kodillalibrary.library.mapper.RentsMapper;
import com.kodillalibrary.library.repository.RentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RentsDbService {
    private final RentsRepository rentsRepository;
    private final RentsMapper rentsMapper;

    public List<RentsDto> getRents(){
        List<Rents> rents = rentsRepository.findAll();
        return rentsMapper.mapToRentsDtoList(rents);
    }

    public RentsDto getRent(Long id){
        return rentsRepository.findById(id)
                .map(rentsMapper::mapToRentsDto)
                .orElseThrow(() -> new ResourceNotFoundException("Rent with id: " + id + " not found"));
    }

    public void deleteRent(Long id){
        rentsRepository.deleteById(id);
    }

    public RentsDto updateRent(Long id, RentsDto rentsDto){
        return rentsRepository.findById(id).map(rents -> {
            Rents updatedRent = rentsMapper.mapToRents(rentsDto);
            rentsRepository.save(updatedRent);
            return rentsMapper.mapToRentsDto(updatedRent);
        }).orElseThrow(() -> new ResourceNotFoundException("Rent with id: " + id + " not found"));
    }

    public void createRent(RentsDto rentsDto) {
        rentsRepository.save(rentsMapper.mapToRents(rentsDto));
    }
}
