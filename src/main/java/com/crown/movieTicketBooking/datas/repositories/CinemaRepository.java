package com.crown.movieTicketBooking.datas.repositories;

import com.crown.movieTicketBooking.datas.models.Cinema;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CinemaRepository extends MongoRepository<Cinema,String > {
    List<Cinema> findByName(String cinemaName);

    List<Cinema> findByCity(String city);
}
