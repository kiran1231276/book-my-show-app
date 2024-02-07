package brainworks.student.service;

import brainworks.student.payload.CinemaHallDto;

import java.util.List;
import java.util.Map;

public interface CinemaHallService {
    CinemaHallDto createCinemaHall(CinemaHallDto cinemaHallDto);
    Boolean deleteCinemaHall (String hallId);
    CinemaHallDto updateSpecificField(String userId, Map<String, Object> fields);
    List<CinemaHallDto> getAllCinemaHall();
    List<CinemaHallDto> getCinemaHallByName(String hallName);
    CinemaHallDto getCinemaHallById(String hallId);

    CinemaHallDto checkSeatAvailability(String CinemahHallId);
}
