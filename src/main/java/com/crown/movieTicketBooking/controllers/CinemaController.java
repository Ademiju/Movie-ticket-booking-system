package com.crown.movieTicketBooking.controllers;

import com.crown.movieTicketBooking.dtos.requests.CinemaRequest;
import com.crown.movieTicketBooking.dtos.responses.ApiResponse;
import com.crown.movieTicketBooking.exceptions.MovieTicketBookingException;
import com.crown.movieTicketBooking.services.CinemaHallService;
import com.crown.movieTicketBooking.services.CinemaService;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/movie-ticket-booking")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;
    @PostMapping("/createCinema/")

    public ResponseEntity<?> createCinema(@RequestBody CinemaRequest cinemaRequest ) {
        try {
            return new ResponseEntity<>(cinemaService.createCinema(cinemaRequest), HttpStatus.CREATED);
        } catch (MovieTicketBookingException error) {
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
