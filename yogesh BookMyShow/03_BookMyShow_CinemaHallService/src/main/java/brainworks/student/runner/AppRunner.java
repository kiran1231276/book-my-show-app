package brainworks.student.runner;



import brainworks.student.entity.CinemaHall;
import brainworks.student.repository.CinemaHallRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    CinemaHallRepository cinemaHallRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        CinemaHall cinemaHall1=new CinemaHall ();
        CinemaHall cinemaHall2=new CinemaHall ();
        CinemaHall cinemaHall3=new CinemaHall ();

        cinemaHall1.setHallId (UUID.randomUUID ().toString ());
        cinemaHall1.setName ("INOX");
        cinemaHall1.setLocation ("Dombivali");
        cinemaHall1.setScreens (1);
        cinemaHall1.setSeatType ("Diamond");
        cinemaHall1.setSeatingCapacity (100);

        cinemaHall2.setHallId (UUID.randomUUID ().toString ());
        cinemaHall2.setName ("PVR");
        cinemaHall2.setLocation ("Thane");
        cinemaHall2.setScreens (2);
        cinemaHall2.setSeatType ("Silver");
        cinemaHall2.setSeatingCapacity (200);

        cinemaHall3.setHallId (UUID.randomUUID ().toString ());
        cinemaHall3.setName ("IMAX");
        cinemaHall3.setLocation ("Powai");
        cinemaHall3.setScreens (3);
        cinemaHall3.setSeatType ("Gold");
        cinemaHall3.setSeatingCapacity (300);

//        cinemaHallRepository.save (cinemaHall1);
//        cinemaHallRepository.save (cinemaHall2);
//        cinemaHallRepository.save (cinemaHall3);

    }
}
