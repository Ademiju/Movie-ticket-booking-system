package com.crown.movieTicketBooking.datas.repositories;

import com.crown.movieTicketBooking.datas.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends MongoRepository<Movie,String> {

    Optional<Movie> findMovieByTitle(String title);

    List<Movie> findMovieByGenre(String genre);
}
