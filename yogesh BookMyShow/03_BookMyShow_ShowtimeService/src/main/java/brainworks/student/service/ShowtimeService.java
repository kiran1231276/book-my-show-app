package brainworks.student.service;

import brainworks.student.payload.ShowtimeDto;

import java.util.List;

public interface ShowtimeService {
    ShowtimeDto createShowTime(ShowtimeDto showtimeDto);
    ShowtimeDto findShowtimeById(String showtimeId);
    List<ShowtimeDto> getShowtimeDetails();

}
