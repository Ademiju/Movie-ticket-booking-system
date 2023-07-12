package com.crown.movieTicketBooking.controllers;

import com.crown.movieTicketBooking.dtos.requests.AddHallRequest;
import com.crown.movieTicketBooking.dtos.requests.BookingRequest;
import com.crown.movieTicketBooking.dtos.requests.CreateCinemaRequest;
import com.crown.movieTicketBooking.dtos.requests.CreateShowRequest;
import com.crown.movieTicketBooking.dtos.responses.ApiResponse;
import com.crown.movieTicketBooking.exceptions.MovieTicketBookingException;
import com.crown.movieTicketBooking.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/movie-ticket-booking")
public class CinemaController {
//    @Autowired
//    private CinemaService cinemaService;

//    @PostMapping("/create-cinema/")
//
//    public ResponseEntity<?> createCinema(@RequestBody CreateCinemaRequest cinemaRequest ) {
//        try {
//            return new ResponseEntity<>(cinemaService.createCinema(cinemaRequest), HttpStatus.CREATED);
//        } catch (MovieTicketBookingException error) {
//            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
//        }
//    }
//    @GetMapping("/cities-with-cinema/")
//
//    public ResponseEntity<?> findCityWithCinema() {
//        try {
//            return new ResponseEntity<>(cinemaService.findAllCityWithCinema(), HttpStatus.CREATED);
//        } catch (MovieTicketBookingException error) {
//            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
//        }
//    }

//    @PostMapping("/add-hall/")
//
//    public ResponseEntity<?> addViewingHall(@RequestBody AddHallRequest request) {
//        try {
//            return new ResponseEntity<>(cinemaService.addViewingHall(request), HttpStatus.CREATED);
//        } catch (MovieTicketBookingException error) {
//            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
//        }
//    }

//    @PostMapping("/create-show/")
//
//    public ResponseEntity<?> createShow(@RequestBody CreateShowRequest createShowRequest) {
//        try {
//            return new ResponseEntity<>(cinemaService.createShow(createShowRequest), HttpStatus.CREATED);
//        } catch (MovieTicketBookingException error) {
//            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
//        }
//    }

//    @PostMapping("/book-show/")
//
//    public ResponseEntity<?> bookShow(@RequestBody BookingRequest bookingRequest) {
//        try {
//            return new ResponseEntity<>(cinemaService.buyMovieTicket(bookingRequest), HttpStatus.CREATED);
//        } catch (MovieTicketBookingException error) {
//            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
//        }
//    }

}
