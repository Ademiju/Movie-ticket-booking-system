package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.dtos.requests.CinemaRequest;

import com.crown.movieTicketBooking.dtos.responses.CinemaResponse;

import java.util.Set;

public interface CinemaService {
    CinemaResponse createCinema(CinemaRequest cinemaRequest);
    Set<String> findAllCinema();
    void deleteAll();
    String addMoviesToCinema(String cinemaId, String movieId);

}

