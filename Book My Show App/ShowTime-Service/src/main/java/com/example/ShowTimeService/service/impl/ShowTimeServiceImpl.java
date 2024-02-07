package com.example.ShowTimeService.service.impl;

import com.example.ShowTimeService.dto.SeatInfoDto;
import com.example.ShowTimeService.dto.ShowTimeDto;
import com.example.ShowTimeService.entity.ShowTime;
import com.example.ShowTimeService.exception.ResourceNotFoundException;
import com.example.ShowTimeService.external.service.HallServiceClient;
import com.example.ShowTimeService.repository.ShowTimeRepository;
import com.example.ShowTimeService.service.ShowTimeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Field;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ShowTimeServiceImpl implements ShowTimeService {
    @Autowired
    private ShowTimeRepository showTimeRepository;

    @Autowired
    private HallServiceClient hallServiceClient;

    @Transactional
    @Override
    public ShowTimeDto createShowTime(@Valid @RequestBody ShowTimeDto showTimeDto) {
        showTimeDto.setShowTimeId(UUID.randomUUID().toString());

        // Extracting hallId from the ShowTimeDto
        String hallId = showTimeDto.getHallId();

        // Fetching seating capacity from the Hall service using the Feign client
        SeatInfoDto seatCapacity = hallServiceClient.getSeatCapacity(hallId);

        // Setting the available seats in the ShowTimeDto
        showTimeDto.setAvailableSeats(seatCapacity.getSeatingCapacity());

        ShowTime showTime = new ShowTime();
        mapDtoToEntity(showTimeDto,showTime);
        ShowTime savedShowTime = showTimeRepository.save(showTime);
        return mapEntityToDto(savedShowTime);
    }

    @Override
    public ShowTimeDto updateShowTime(String showTimeId, ShowTimeDto showTimeDto) {
        Optional<ShowTime> optionalShowTime = showTimeRepository.findById(showTimeId);
        if (optionalShowTime.isPresent()) {
            ShowTime existingShowTime = optionalShowTime.get();

            existingShowTime.setAvailableSeats(showTimeDto.getAvailableSeats());

            ShowTime savedShowTime = showTimeRepository.save(existingShowTime);
            return mapEntityToDto(savedShowTime);
        } else {
            throw new ResourceNotFoundException("Show time with given id not found: " + showTimeId);
        }
    }


    @Override
    public ShowTimeDto updateSpecificFieldOfShowTime(String showTimeId, Map<String, Object> fields) {
        Optional<ShowTime> optionalShowTime = showTimeRepository.findById(showTimeId);
        if (optionalShowTime.isPresent()) {
            ShowTime existingShowTime = optionalShowTime.get();
            applyPatch(existingShowTime, fields);
            ShowTime savedShowTime = showTimeRepository.save(existingShowTime);
            return mapEntityToDto(savedShowTime);
        } else {
            throw new ResourceNotFoundException("show time with given id is not found: " + showTimeId);
        }
    }

    @Override
    public ShowTimeDto getShowTimeById(String showTimeId) {
        Optional<ShowTime> optionalShowTime = showTimeRepository.findById(showTimeId);
        if (optionalShowTime.isPresent()) {
            return mapEntityToDto(optionalShowTime.get());
        } else {
            throw new ResourceNotFoundException("Show time with given id is not found :" + showTimeId);
        }
    }

    @Override
    public List<ShowTimeDto> getAllShowTime(){
        List<ShowTime> showTimeList = showTimeRepository.findAll();
        return showTimeList.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShowTimeDto getAvailableSeats(String showTimeId) {
        Optional<ShowTime> optionalShowTime = showTimeRepository.findById(showTimeId);
        if (optionalShowTime.isPresent()) {
            return mapEntityToDto(optionalShowTime.get());
        } else {
            throw new ResourceNotFoundException("Show time with given id not found: " + showTimeId);
        }
    }





    /*@Autowired
    private MovieClient movieClient;

    @Override
    public List<ShowTimeDto> getShowTimesByMovieId(String movieId) {
        // Use Feign client to get movie details from MovieService
        MovieDto movie = movieClient.getMovieById(movieId);

        // Your logic to retrieve show times based on movie details
        List<ShowTimeDto> showTimeList = showTimeRepository.findShowTimesByMovieId(movieId);

        // Map entities to DTOs and set movie details
        List<ShowTimeDto> showTimeDtoList = showTimeList.stream()
                .map(showTime -> {
                    ShowTimeDto showTimeDto = mapEntityToDto(showTime);
                    showTimeDto.setMovieDetails(movie);
                    return showTimeDto;
                })
                .collect(Collectors.toList());

        return showTimeDtoList;
    }*/

  /*  private ShowTimeDto mapEntityToDto(ShowTime showTime) {
        ShowTimeDto showTimeDto = new ShowTimeDto();
        BeanUtils.copyProperties(showTime, showTimeDto);
        return showTimeDto;
    }*/


//    @Override
//    public List<ShowTimeDto> getShowTimesByMovieId(String movieId) {
//        List<ShowTimeDto> showTimesByMovieId = showTimeRepository.findShowTimesByMovieId(movieId);
//        return showTimesByMovieId;
//    }


//    @Override
//    public List<ShowTimeDto> getShowTimesByCinemaHallId(String hallId) {
//        List<ShowTimeDto> showTimesByCinemaHallId = showTimeRepository.findShowTimesByCinemaHallId(hallId);
//        return showTimesByCinemaHallId;
//    }



    /*@Override
    public ShowTimeDetailsDto getShowTimeDetails(String showTimeId) {
        ShowTime showTime = showTimeRepository.findById(showTimeId)
                .orElseThrow(() -> new ResourceNotFoundException("Show time with given id not found: " + showTimeId));

        // Use the Feign Client to fetch Movie details
        MovieDto movie = movieClient.getMovieById(showTime.getMovieId());

        // Use the Feign Client to fetch CinemaHall details
        CinemaHallDto cinemaHall = cinemaHallClient.getCinemaHallById(showTime.getHallId());

        ShowTimeDetailsDto showTimeDetailsDto = new ShowTimeDetailsDto();
        BeanUtils.copyProperties(showTime, showTimeDetailsDto);
        showTimeDetailsDto.setMovieDetails(movie);
        showTimeDetailsDto.setHallDetails(cinemaHall);

        return showTimeDetailsDto;
    }*/

    /*// Add a method to map CinemaHall to CinemaHallDto if it doesn't exist
    private CinemaHallDto mapCinemaHallToDto(CinemaHall cinemaHall) {
        CinemaHallDto cinemaHallDto = new CinemaHallDto();
        BeanUtils.copyProperties(cinemaHall, cinemaHallDto);
        return cinemaHallDto;
    }*/




    // Helper method to map DTO to entity
    private void mapDtoToEntity(ShowTimeDto showTimeDto, ShowTime showTime) {
        BeanUtils.copyProperties(showTimeDto, showTime);
    }

    // Helper method to map entity to DTO
    private ShowTimeDto mapEntityToDto(ShowTime showTime) {
        ShowTimeDto showTimeDto = new ShowTimeDto();
        BeanUtils.copyProperties(showTime, showTimeDto);
        return showTimeDto;
    }

    // Helper method to set field dynamically using ReflectionUtils
    private void setField(ShowTime showTime, String fieldName, Object value) {
        Field field = ReflectionUtils.findField(ShowTime.class, fieldName);

        if (field != null) {
            field.setAccessible(true);

            // Convert value to LocalTime if the field is of type LocalTime
            if (field.getType() == LocalTime.class && value instanceof String) {
                value = LocalTime.parse((String) value);
            }

            ReflectionUtils.setField(field, showTime, value);
        }
    }

    // this for patch mapping
    private void applyPatch(ShowTime existingShowTime, Map<String, Object> fields) {
        fields.forEach((field, value) -> {
            // Use ReflectionUtils to find and set the field
            setField(existingShowTime, field, value);
        });
    }
}
