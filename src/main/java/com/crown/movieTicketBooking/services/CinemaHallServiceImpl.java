package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.CinemaHall;
import com.crown.movieTicketBooking.datas.models.Seat;
import com.crown.movieTicketBooking.datas.repositories.CinemaHallRepository;
import com.crown.movieTicketBooking.datas.repositories.SeatRepository;
import com.crown.movieTicketBooking.dtos.requests.CinemaHallRequest;
import com.crown.movieTicketBooking.exceptions.MovieTicketBookingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CinemaHallServiceImpl implements CinemaHallService{
    @Autowired
    CinemaHallRepository cinemaHallRepository;
    @Autowired
    SeatRepository seatRepository;

    @Override
    public CinemaHall createCinemaHall(CinemaHallRequest cinemaHallRequest) {
        Optional<CinemaHall> optionalCinemaHall = cinemaHallRepository.findByName(cinemaHallRequest.getCinemaHallName().toLowerCase());
        if (optionalCinemaHall.isPresent() )throw new MovieTicketBookingException("CinemaHall already exist");
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setName(cinemaHallRequest.getCinemaHallName().toUpperCase());
        cinemaHall.setCapacity(cinemaHallRequest.getCinemaHallCapacity());
        Seat seat = new Seat();
        String[] seats = new String[cinemaHallRequest.getCinemaHallCapacity()];
        Arrays.fill(seats,"AVAILABLE");
        seat.setSeats(seats);
        seat.setPrice(BigDecimal.valueOf(cinemaHallRequest.getPrice()));
        seatRepository.save(seat);
        cinemaHall.setSeat(seat);
        return cinemaHallRepository.save(cinemaHall);
    }
}
