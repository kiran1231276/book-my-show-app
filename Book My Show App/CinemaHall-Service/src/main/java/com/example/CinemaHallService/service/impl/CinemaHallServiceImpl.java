package com.example.CinemaHallService.service.impl;

import com.example.CinemaHallService.dto.CinemaHallDto;
import com.example.CinemaHallService.entity.CinemaHall;
import com.example.CinemaHallService.exception.ResourceNotFoundException;
import com.example.CinemaHallService.repository.CinemaHallRepository;
import com.example.CinemaHallService.service.CinemaHallService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {

    @Autowired
    private CinemaHallRepository cinemaHallRepository;

    @Transactional
    @Override
    public CinemaHallDto createCinemaHall(CinemaHallDto cinemaHallDto) {
        cinemaHallDto.setHallId(UUID.randomUUID().toString());
        CinemaHall cinemaHall = new CinemaHall();
        mapDtoToEntity(cinemaHallDto, cinemaHall);
        CinemaHall savedCinemaHall = cinemaHallRepository.save(cinemaHall);
        return mapEntityToDto(savedCinemaHall);
    }

    @Override
    public CinemaHallDto getCinemaHallById(String hallId) {
        Optional<CinemaHall> optionalCinemaHall = cinemaHallRepository.findById(hallId);
        if (optionalCinemaHall.isPresent()) {
            return mapEntityToDto(optionalCinemaHall.get());
        } else {
            throw new ResourceNotFoundException("Cinema hall with given id is not found :" + hallId);
        }
    }

    @Override
    @Transactional
    public boolean deleteCinemaHall(String hallId) {
        return cinemaHallRepository.findById(hallId).map(cinemaHall -> {
            cinemaHallRepository.delete(cinemaHall);
            return true;
        }).orElse(false);
    }

    @Override
    public CinemaHallDto updateSpecificFieldOfCinemaHall(String hallId, Map<String, Object> fields) {
        Optional<CinemaHall> optionalCinemaHall = cinemaHallRepository.findById(hallId);
        if (optionalCinemaHall.isPresent()) {
            CinemaHall existingCinemaHall = optionalCinemaHall.get();
            applyPatch(existingCinemaHall, fields);
            CinemaHall savedCinemaHall = cinemaHallRepository.save(existingCinemaHall);
            return mapEntityToDto(savedCinemaHall);
        } else {
            throw new ResourceNotFoundException("Cinema Hall with given id is not found: " + hallId);
        }
    }

    @Override
    public List<CinemaHallDto> getAllCinemaHalls() {
        List<CinemaHall> cinemaHallList = cinemaHallRepository.findAll();
        return cinemaHallList.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CinemaHallDto> getCinemaHallsByName(String name) {
        List<CinemaHall> cinemaHallList = cinemaHallRepository.findByHallName(name);
        return cinemaHallList.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CinemaHallDto> getCinemaHallsByLocation(String location) {
        List<CinemaHall> cinemaHallList = cinemaHallRepository.findByLocation(location);
        return cinemaHallList.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Integer checkSeatAvailability(String hallId) {
        Optional<CinemaHall> optionalCinemaHall = cinemaHallRepository.findById(hallId);

        if (optionalCinemaHall.isPresent()) {
            CinemaHall cinemaHall = optionalCinemaHall.get();
            return cinemaHall.getSeatingCapacity();
        } else {

            return -1;
        }
    }

    // Helper method to map DTO to entity
    private void mapDtoToEntity(CinemaHallDto cinemaHallDto, CinemaHall cinemaHall) {
        BeanUtils.copyProperties(cinemaHallDto, cinemaHall);
    }

    // Helper method to map entity to DTO
    private CinemaHallDto mapEntityToDto(CinemaHall cinemaHall) {
        CinemaHallDto cinemaHallDto = new CinemaHallDto();
        BeanUtils.copyProperties(cinemaHall, cinemaHallDto);
        return cinemaHallDto;
    }

    // Helper method to set field dynamically using ReflectionUtils(put mapping)
    private void setField(CinemaHall cinemaHall, String fieldName, Object value) {
        Optional.ofNullable(ReflectionUtils.findField(CinemaHall.class, fieldName))
                .ifPresent(field -> {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, cinemaHall, value);
                });
    }

    // this for patch mapping
    private void applyPatch(CinemaHall existingCinemaHall, Map<String, Object> fields) {
        fields.forEach((field, value) -> {
            // Use ReflectionUtils to find and set the field
            setField(existingCinemaHall, field, value);
        });
    }
}
