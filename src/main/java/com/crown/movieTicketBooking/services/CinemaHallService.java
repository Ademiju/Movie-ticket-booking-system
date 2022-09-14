package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.CinemaHall;
import com.crown.movieTicketBooking.dtos.requests.CinemaHallRequest;
import com.crown.movieTicketBooking.dtos.requests.CinemaRequest;

public interface CinemaHallService {
    CinemaHall createCinemaHall(CinemaHallRequest cinemaHallRequest);
}
