package com.crown.movieTicketBooking.datas.repositories;

import com.crown.movieTicketBooking.datas.models.CinemaHall;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CinemaHallRepository extends MongoRepository<CinemaHall, String> {
    Optional<CinemaHall> findByName(String name);
}
