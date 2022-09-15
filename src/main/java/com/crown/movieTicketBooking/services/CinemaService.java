package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.Booking;
import com.crown.movieTicketBooking.dtos.requests.AddHallRequest;
import com.crown.movieTicketBooking.dtos.requests.BookingRequest;
import com.crown.movieTicketBooking.dtos.requests.CreateCinemaRequest;

import com.crown.movieTicketBooking.dtos.requests.CreateShowRequest;
import com.crown.movieTicketBooking.dtos.responses.AddHallResponse;
import com.crown.movieTicketBooking.dtos.responses.CinemaResponse;
import com.crown.movieTicketBooking.dtos.responses.CreateShowResponse;

import java.util.Set;

public interface CinemaService {
    CinemaResponse createCinema(CreateCinemaRequest cinemaRequest);
    Set<String> findAllCityWithCinema();
    void deleteAll();
    AddHallResponse addViewingHall(AddHallRequest request);

    int hallSize(String cinemaId);
    CreateShowResponse createShow(CreateShowRequest createShowRequest);
    Booking buyMovieTicket(BookingRequest request);
}

