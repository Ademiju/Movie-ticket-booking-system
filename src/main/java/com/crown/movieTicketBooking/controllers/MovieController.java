package com.crown.movieTicketBooking.controllers;

import com.crown.movieTicketBooking.dtos.requests.MovieRequest;
import com.crown.movieTicketBooking.dtos.responses.ApiResponse;
import com.crown.movieTicketBooking.dtos.responses.MovieInfoResponse;
import com.crown.movieTicketBooking.exceptions.MovieTicketBookingException;
import com.crown.movieTicketBooking.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/movie-ticket-booking")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/create-movie")

    public ResponseEntity<?> createMovie(@RequestBody MovieRequest movieRequest) {
        try {
            return new ResponseEntity<>(movieService.createMovie(movieRequest), HttpStatus.CREATED);
        } catch (MovieTicketBookingException error) {
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/update-movie/{movieTitle}")

    public ResponseEntity<?>  displayCinemasAndShows(@PathVariable String movieTitle) {
        try {
            return new ResponseEntity<>(movieService.displayCinemasAndShows(movieTitle), HttpStatus.CREATED);
        } catch (MovieTicketBookingException error) {
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @PatchMapping("/update-movie")

    public ResponseEntity<?> updateMovie(@RequestBody MovieRequest movieRequest) {
        try {
            return new ResponseEntity<>(movieService.createMovie(movieRequest), HttpStatus.CREATED);
        } catch (MovieTicketBookingException error) {
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
