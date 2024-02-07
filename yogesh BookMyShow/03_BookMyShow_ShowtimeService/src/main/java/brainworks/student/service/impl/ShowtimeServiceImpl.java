package brainworks.student.service.impl;

import brainworks.student.entity.Showtime;
import brainworks.student.exception.ResourceNotFoundException;
import brainworks.student.payload.ShowtimeDto;
import brainworks.student.repository.ShowtimeRepository;
import brainworks.student.service.ShowtimeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
@Service
public class ShowtimeServiceImpl implements ShowtimeService {
    @Autowired
    ShowtimeRepository showtimeRepository;
    @Override
    public ShowtimeDto createShowTime(ShowtimeDto showtimeDto) {
        showtimeDto.setShowtimeId (UUID.randomUUID ().toString ());
        Showtime booking=new Showtime ();
        BeanUtils.copyProperties (showtimeDto,booking);
        Showtime saved = showtimeRepository.save (booking);
        BeanUtils.copyProperties (saved,showtimeDto);
        return showtimeDto;
    }

    @Override
    public ShowtimeDto findShowtimeById(String showtimeId) {
        Showtime showtime = showtimeRepository.findById (showtimeId)
                .orElseThrow (() -> new ResourceNotFoundException ("Shoetime", "showtimeId", showtimeId));
        ShowtimeDto showtimeDto=new ShowtimeDto ();
        BeanUtils.copyProperties (showtime,showtimeDto);
        return showtimeDto;
    }

    @Override
    public List<ShowtimeDto> getShowtimeDetails() {
        return null;
    }
}
