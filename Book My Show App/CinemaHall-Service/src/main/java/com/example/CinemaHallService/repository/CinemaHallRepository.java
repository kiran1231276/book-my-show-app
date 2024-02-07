package com.example.CinemaHallService.repository;

import com.example.CinemaHallService.entity.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaHallRepository extends JpaRepository<CinemaHall, String > {

    List<CinemaHall> findByLocation(String location);
    List<CinemaHall> findByHallName(String hallName);
}
