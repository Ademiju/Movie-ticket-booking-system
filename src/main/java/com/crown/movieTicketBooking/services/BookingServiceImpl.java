package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.*;
//import com.crown.movieTicketBooking.datas.repositories.BookingRepository;
//import com.crown.movieTicketBooking.datas.repositories.CinemaRepository;
//import com.crown.movieTicketBooking.datas.repositories.ShowRepository;
import com.crown.movieTicketBooking.dtos.requests.BookingRequest;
import com.crown.movieTicketBooking.exceptions.MovieTicketBookingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookingServiceImpl implements BookingService{
//    @Autowired
//    CinemaRepository cinemaRepository;
//    @Autowired
//    ShowRepository showRepository;
//    @Autowired
//    BookingRepository bookingRepository;
//    @Override
//    public Booking bookTicket(BookingRequest bookingRequest) {
//        if (!validateName(bookingRequest.getUserName())) throw new MovieTicketBookingException("Invalid name");
//        if(!validateEmail(bookingRequest.getEmail())) throw new MovieTicketBookingException("Invalid Email");
//
//        Cinema cinema = cinemaRepository.findById(bookingRequest.getCinemaId()).orElseThrow(() -> new MovieTicketBookingException("Cinema does not exist"));
//        if (cinema.getShowTimes() != null) {
//            Date date = Date.valueOf(bookingRequest.getDate());
//            List<Show> shows = cinema.getShowTimes().stream()
//                    .filter(show -> show.getDate().equals(date)).collect(Collectors.toList());
//
//            LocalTime startTime = LocalTime.parse(bookingRequest.getStartTime());
//            List<Show> showList = shows.stream().filter(show -> show.getStartTime().equals(startTime)).collect(Collectors.toList());
//            Show foundShow = showList.stream().filter(show -> show.getMovie().getTitle().equals(bookingRequest.getMovieTitle())).
//                    filter(show -> show.getMovie().getLanguage().
//                            contains(bookingRequest.getLanguage())).findFirst().
//                    orElseThrow(() -> new MovieTicketBookingException("Show not available..."));
//            boolean[] seats = foundShow.getCinemaHall().getSeats();
//            if (foundShow.getCinemaHall().getOccupiedSeats() >= foundShow.getCinemaHall().getCapacity()) {
//                throw new MovieTicketBookingException("All seats are occupied");
//            }
//            seats[foundShow.getCinemaHall().getOccupiedSeats()] = true;
//            Booking book = Booking.builder()
//                    .ticketPrice(foundShow.getPrice())
//                    .movieDuration(foundShow.getDuration())
//                    .bookingStatus(Status.SUCCESSFUL)
//                    .show(foundShow)
//                    .build();
//            return bookingRepository.save(book);
//        }
//        throw new MovieTicketBookingException("Booking Unsuccessful");
//    }

    private boolean validateEmail(String email) {
        return email.matches("^[\\\\w!#$%&'*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}");
    }

    public static boolean validateName( String name ) {
        return name.matches( "[A-Z][a-z]*" );
    }
}
