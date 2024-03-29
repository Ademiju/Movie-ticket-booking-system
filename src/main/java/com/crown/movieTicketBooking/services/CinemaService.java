package com.crown.movieTicketBooking.services;

//import com.crown.movieTicketBooking.datas.models.Booking;
//import com.crown.movieTicketBooking.datas.models.Movie;
import com.crown.movieTicketBooking.dtos.requests.*;

import com.crown.movieTicketBooking.dtos.responses.AddHallResponse;
import com.crown.movieTicketBooking.dtos.responses.CinemaResponse;
import com.crown.movieTicketBooking.dtos.responses.CreateShowResponse;

import java.util.Set;

public interface CinemaService {
    CinemaResponse createCinema(CreateCinemaRequest cinemaRequest);
    Set<String> findAllCityWithCinema();
    void deleteAll();
    AddHallResponse addViewingHall(AddHallRequest request);

    int hallSize(Long cinemaId);
//    CreateShowResponse createShow(CreateShowRequest createShowRequest);
//    Booking buyMovieTicket(BookingRequest request);
}

