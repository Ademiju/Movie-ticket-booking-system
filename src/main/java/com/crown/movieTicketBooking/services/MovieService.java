package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.Movie;
import com.crown.movieTicketBooking.dtos.requests.MovieRequest;
import com.crown.movieTicketBooking.dtos.responses.MovieInformation;

import java.util.List;

public interface MovieService {
    Movie createMovie(MovieRequest movieRequest);
    Movie findMovieByTitle(String movieTitle);
    List<Movie> findMovieByGenre(String genre);
    List<Movie> findMovieByLanguage(String language);
    List<Movie> findMovieByCity(String city);
    MovieInformation selectMovie(String movieTitle);

    void deleteAll();

}

