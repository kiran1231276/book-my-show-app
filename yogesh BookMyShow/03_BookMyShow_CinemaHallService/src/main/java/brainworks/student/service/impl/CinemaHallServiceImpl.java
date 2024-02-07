package brainworks.student.service.impl;

import brainworks.student.service.CinemaHallService;
import brainworks.student.entity.CinemaHall;
import brainworks.student.exception.ResourceNotFoundException;
import brainworks.student.payload.CinemaHallDto;
import brainworks.student.repository.CinemaHallRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    @Autowired
    CinemaHallRepository cinemaHallRepository;

    @Override
    public CinemaHallDto createCinemaHall(CinemaHallDto cinemaHallDto) {
        cinemaHallDto.setHallId (UUID.randomUUID ().toString ());
        CinemaHall cinemaHall=new CinemaHall ();
        BeanUtils.copyProperties (cinemaHallDto,cinemaHall);
        CinemaHall save = cinemaHallRepository.save (cinemaHall);
        BeanUtils.copyProperties (save,cinemaHallDto);
        return cinemaHallDto;
    }

    @Override
    public Boolean deleteCinemaHall(String hallId) {
        CinemaHall cinemaHall = cinemaHallRepository.findById (hallId)
                .orElseThrow (() -> new ResourceNotFoundException ("CinemaHall", "CinemaId", hallId));
        return cinemaHall!=null;
    }

    @Override
    public CinemaHallDto updateSpecificField(String userId, Map<String, Object> fields) {

        CinemaHall user = this.cinemaHallRepository.findById (userId)
                .orElseThrow (() -> new ResourceNotFoundException ("User", "uId", userId));
        fields.forEach ((key, value) -> {
            Field field = ReflectionUtils.findField (CinemaHall.class, key);
            Optional<Field> optionalField = Optional.ofNullable (field);
            if (optionalField.isPresent ()) {
                field.setAccessible (true);
                ReflectionUtils.setField (field, user, value);
            } else {
                // Handle the case where the field is not found.
                // You may want to log a warning or throw an exception.
                System.err.println ("Field not found: " + key);
            }
        });
        CinemaHall savedUser = cinemaHallRepository.save (user);
        CinemaHallDto userDto = new CinemaHallDto ();
        BeanUtils.copyProperties (savedUser, userDto);
        return userDto;
    }

    @Override
    public List<CinemaHallDto> getAllCinemaHall() {
        List<CinemaHallDto> cinemaHallDtoList=new ArrayList<> ();
        List<CinemaHall> cinemaHalls = cinemaHallRepository.findAll ();
        List<CinemaHall> collect = cinemaHalls.stream ()
                .map (cinemaHall -> {
            CinemaHallDto cinemaHallDto = new CinemaHallDto ();
            BeanUtils.copyProperties (cinemaHall, cinemaHallDto);
            cinemaHallDtoList.add (cinemaHallDto);
            return cinemaHall;
        }).collect (Collectors.toList ());
        return cinemaHallDtoList;
    }

    @Override
    public List<CinemaHallDto> getCinemaHallByName(String hallName) {
        List<CinemaHall> cinemaHallList = cinemaHallRepository.findByName (hallName);
        List<CinemaHallDto> cinemaHallDtoList=new ArrayList<> ();
        for(CinemaHall cinemaHall:cinemaHallList){
            CinemaHallDto cinemaHallDto=new CinemaHallDto ();
            BeanUtils.copyProperties (cinemaHall,cinemaHallDto);
            cinemaHallDtoList.add (cinemaHallDto);
        }
        return cinemaHallDtoList;
    }

    @Override
    public CinemaHallDto getCinemaHallById(String hallId) {
        CinemaHall cinemaHall = cinemaHallRepository.findById (hallId)
                .orElseThrow (() -> new ResourceNotFoundException ("CinemaHall", "hallId", hallId));
        CinemaHallDto cinemaHallDto=new CinemaHallDto ();
        BeanUtils.copyProperties (cinemaHall,cinemaHallDto);
        return cinemaHallDto;
    }

    @Override
    public CinemaHallDto checkSeatAvailability(String CinemahHallId) {
        return null;
    }
}
