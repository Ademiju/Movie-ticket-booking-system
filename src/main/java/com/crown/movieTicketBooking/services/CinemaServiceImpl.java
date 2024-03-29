package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.*;
import com.crown.movieTicketBooking.datas.repositories.*;
import com.crown.movieTicketBooking.dtos.requests.*;
import com.crown.movieTicketBooking.dtos.responses.AddHallResponse;
import com.crown.movieTicketBooking.dtos.responses.CinemaResponse;
import com.crown.movieTicketBooking.dtos.responses.CreateShowResponse;
import com.crown.movieTicketBooking.exceptions.MovieTicketBookingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

//@Service
//@Slf4j
//public class CinemaServiceImpl implements CinemaService {
//    @Autowired
//    CinemaRepository cinemaRepository;
//    @Autowired
//    CinemaHallRepository cinemaHallRepository;
//    @Autowired
//    MovieService movieService;
//    @Autowired
//    ShowService showService;
//    @Autowired
//    BookingService bookingService;
//    @Autowired
//    MovieRepository movieRepository;

//    @Override
//    public CinemaResponse createCinema(CreateCinemaRequest cinemaRequest) {
//        Cinema cinema = new Cinema(cinemaRequest.getName(), cinemaRequest.getCity(), cinemaRequest.getNumberOfViewingHalls());
//        Cinema savedCinema = cinemaRepository.save(cinema);
//        return CinemaResponse.builder()
//                .name(savedCinema.getName())
//                .city(savedCinema.getCity())
//                .message("Success")
//                .cinemaId(savedCinema.getId())
//                .build();
//    }


//    @Override
//    public Set<String> findAllCityWithCinema() {
//        List<Cinema> cinemaList = cinemaRepository.findAll();
//        return cinemaList.stream().map(Cinema::getCity).collect(Collectors.toSet());
//    }
//
//    @Override
//    public AddHallResponse addViewingHall(AddHallRequest request) {
//
//    Cinema cinema = cinemaRepository.findById(request.getCinemaId()).orElseThrow(()-> new MovieTicketBookingException("Cinema not found!"));
//    if(hallSize(request.getCinemaId()) >= cinema.getNumberOfViewingHalls()){
//        throw  new MovieTicketBookingException("Hall capacity cannot be exceeded!");
//    }
//    if(cinema.getCinemaHalls()[0] != null) {
//        CinemaHall[] halls = cinema.getCinemaHalls();
//        CinemaHall[] availableCinemaHalls = Arrays.copyOfRange(halls,0,cinema.getHallCount());
//        Optional<CinemaHall> optionalCinemaHall = Arrays.stream(availableCinemaHalls).toList()
//                .stream().filter(availableCinemaHall -> availableCinemaHall.getName().equals(request.getName())).findFirst();
//        if(optionalCinemaHall.isPresent()) throw new MovieTicketBookingException("Hall name already exist");
//    }
//        CinemaHall cinemaHall = new CinemaHall(request.getName(), request.getCapacity());
//        CinemaHall[] halls = cinema.getCinemaHalls();
//        halls[cinema.getHallCount()] = cinemaHall;
//        cinema.setCinemaHalls(halls);
//        cinema.setHallCount(cinema.getHallCount() + 1);
//
//        Cinema updatedCinema = cinemaRepository.save(cinema);
//         return AddHallResponse.builder()
//                 .cinemaName(updatedCinema.getName())
//                 .hallName(cinemaHall.getName())
//                .message(cinemaHall.getName()+" Hall added to "+updatedCinema.getName())
//                .build();
//
//    }
//
//    @Override
//    public int hallSize(Long cinemaId) {
//        return cinemaRepository.findById(cinemaId).get().getHallCount();
//    }


//    @Override
//    public CreateShowResponse createShow(CreateShowRequest createShowRequest) {
//        Cinema cinema = cinemaRepository.findById(createShowRequest.getCinemaId()).orElseThrow(()-> new MovieTicketBookingException("Cinema not found!"));
//        CinemaHall hall = Arrays.stream(cinema.getCinemaHalls()).
//                filter(cinemaHall-> cinemaHall.getName().equals(createShowRequest.getHallName())).findFirst().
//                orElseThrow(()-> new MovieTicketBookingException("Hall name not found!"));
//        Movie savedMovie = movieService.findMovieByTitle(createShowRequest.getMovieTitle());
//        Show createdShow = buildShowRequest(createShowRequest, hall, savedMovie);
//        if(cinema.getShowTimes().stream().anyMatch(show -> show.getMovie().getTitle().equals(createdShow.getMovie().getTitle())
//                && show.getCinemaHall().equals(createdShow.getCinemaHall())
//                && show.getStartTime().equals(createdShow.getStartTime())))
//            throw new MovieTicketBookingException("Show already exist, add a new show");
//        cinema.getShowTimes().add(createdShow);
//        Cinema savedCinema = cinemaRepository.save(cinema);
//        savedMovie.getCinemaList().add(savedCinema);
//        movieRepository.save(savedMovie);
//        return CreateShowResponse.builder()
//                .message("Show successfully created!")
//                .build();
//    }
//    @Override
//    public Booking buyMovieTicket(BookingRequest request) {
//        return bookingService.bookTicket(request);
//    }

//    private Show buildShowRequest(CreateShowRequest createShowRequest, CinemaHall hall, Movie savedMovie) {
//        ShowRequest showRequest = ShowRequest.builder()
//                .movie(savedMovie)
//                .date(createShowRequest.getDate())
//                .startTime(createShowRequest.getStartTime())
//                .endTime(createShowRequest.getEndTime())
//                .cinemaHall(hall)
//                .price(createShowRequest.getPrice())
//                .build();
//        return showService.createShow(showRequest);
//    }

//    @Override
//    public void deleteAll() {
//        cinemaRepository.deleteAll();
//    }
//
//}

