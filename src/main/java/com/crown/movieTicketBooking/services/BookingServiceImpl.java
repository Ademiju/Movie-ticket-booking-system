package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.*;
import com.crown.movieTicketBooking.datas.repositories.CinemaRepository;
import com.crown.movieTicketBooking.datas.repositories.ShowRepository;
import com.crown.movieTicketBooking.datas.repositories.UserRepository;
import com.crown.movieTicketBooking.dtos.requests.BookingRequest;
import com.crown.movieTicketBooking.exceptions.MovieTicketBookingException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    ShowRepository showRepository;
    @Override
    public Booking bookTicket(BookingRequest bookingRequest) {
        if(!validateName(bookingRequest.getUserName())) throw new MovieTicketBookingException("Invalid name");
        if(!validateEmail(bookingRequest.getEmail())) throw new MovieTicketBookingException("Invalid Email");

        Cinema cinema = cinemaRepository.findById(bookingRequest.getCinemaId()).orElseThrow(()-> new MovieTicketBookingException("Cinema does not exist") );
        if(cinema.getShowTimes()!=null){
            Date date = Date.valueOf(bookingRequest.getDate());
            List <Show> shows = cinema.getShowTimes().stream()
                    .filter(show -> show.getDate().equals(date)).collect(Collectors.toList());

            LocalTime startTime = LocalTime.parse(bookingRequest.getStartTime());
            var result = shows.stream().filter(show -> show.getStartTime().equals(startTime)).collect(Collectors.toList());

        }
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");
//        formatter.parse(bookingRequest.getShowTime());
//        showRepository.findByDate(formatter.parse(bookingRequest.getShowTime()));
//        List<Movie> movieList = new ArrayList<>();
//
//
//        List<Movie> searchedMovie = movieList.stream().filter(movie -> movie.getTitle().equals(bookingRequest.getMovieTitle()))
//                .collect(Collectors.toList());
//        if(searchedMovie.isEmpty()) throw new MovieTicketBookingException("Movie not available in this Cinema");
//
//
//        Booking booking = new Booking();
//
        return null;
    }

    private boolean validateEmail(String email) {
        return email.matches("^[\\\\w!#$%&'*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}");
    }

    public static boolean validateName( String name ) {
        return name.matches( "[A-Z][a-z]*" );
    }
}
