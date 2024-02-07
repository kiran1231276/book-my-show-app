package brainworks.student.runner;


import brainworks.student.entity.Movie;

import brainworks.student.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    MoviesRepository moviesRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> genre= new ArrayList<> ();
        genre.add ("Science");
        genre.add ("Fiction");
        genre.add ("Comedy");

        Movie movie1=new Movie ();
        movie1.setName ("Rockstar");
        movie1.setCategory ("Drama");
        movie1.setPoster ("string");
        movie1.setGenre (genre);
        movie1.setCountry ("India");
        movie1.setReleaseDate (LocalDate.parse ("2024-01-15"));
        movie1.setRatings ("*******");
        String string = UUID.randomUUID ().toString ();
        movie1.setMovieId (string);

        Movie movie2=new Movie ();
        movie2.setName ("Dil chahata hai....");
        movie2.setCategory ("Drama");
        movie2.setPoster ("string");
        movie2.setGenre (genre);
        movie2.setCountry ("India");
        movie2.setReleaseDate (LocalDate.parse ("2024-01-15"));
        movie2.setRatings ("***********");
        String string2 = UUID.randomUUID ().toString ();
        movie2.setMovieId (string2);


        Movie movie3 = new Movie ();
        movie3.setName ("Zindagi na milegi dobara.....");
        movie3.setCategory ("Drama");
        movie3.setPoster ("string");
        movie3.setGenre (genre);
        movie3.setCountry ("India");
        movie3.setReleaseDate (LocalDate.parse ("2024-01-15"));
        movie3.setRatings ("***********");
        String string3 = UUID.randomUUID ().toString ();
        movie3.setMovieId (string3);

//        moviesRepository.save (movie1);
//        moviesRepository.save (movie2);
//        moviesRepository.save (movie3);


    }
}
