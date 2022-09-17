package com.crown.movieTicketBooking.controllers;

import com.crown.movieTicketBooking.dtos.requests.MovieRequest;
import com.crown.movieTicketBooking.dtos.responses.ApiResponse;
import com.crown.movieTicketBooking.exceptions.MovieTicketBookingException;
import com.crown.movieTicketBooking.services.MovieService;
import com.mongodb.internal.bulk.UpdateRequest;
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


    @GetMapping("/display-movie")

    public ResponseEntity<?>  displayCinemasAndShows(@RequestParam String movieTitle) {
        try {
            return new ResponseEntity<>(movieService.displayCinemasAndShows(movieTitle), HttpStatus.CREATED);
        } catch (MovieTicketBookingException error) {
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/find-by-title")

    public ResponseEntity<?> findMovieByTitle(@RequestParam String movieTitle) {
        try {
            return new ResponseEntity<>(movieService.findMovieByTitle(movieTitle), HttpStatus.CREATED);
        } catch (MovieTicketBookingException error) {
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find-by-lang")

    public ResponseEntity<?> findMovieByLanguage(@RequestParam String language) {
        try {
            return new ResponseEntity<>(movieService.findMovieByLanguage(language), HttpStatus.CREATED);
        } catch (MovieTicketBookingException error) {
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find-by-genre")

    public ResponseEntity<?> findMovieByGenre(@RequestParam String genre) {
        try {
            return new ResponseEntity<>(movieService.findMovieByGenre(genre), HttpStatus.CREATED);
        } catch (MovieTicketBookingException error) {
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/find-by-city")

    public ResponseEntity<?> findMovieByCity(@RequestParam String city) {
        try {
            return new ResponseEntity<>(movieService.findMovieByCity(city), HttpStatus.CREATED);
        } catch (MovieTicketBookingException error) {
            return new ResponseEntity<>(new ApiResponse(false, error.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }



}
