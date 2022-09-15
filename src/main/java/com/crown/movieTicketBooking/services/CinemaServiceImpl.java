package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.*;
import com.crown.movieTicketBooking.datas.repositories.*;
import com.crown.movieTicketBooking.dtos.requests.*;
import com.crown.movieTicketBooking.dtos.responses.AddHallResponse;
import com.crown.movieTicketBooking.dtos.responses.CinemaResponse;
import com.crown.movieTicketBooking.dtos.responses.CreateShowResponse;
import com.crown.movieTicketBooking.exceptions.MovieTicketBookingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    MovieService movieService;
    @Autowired
    ShowService showService;
    @Autowired
    BookingService bookingService;

    @Override
    public CinemaResponse createCinema(CreateCinemaRequest cinemaRequest) {
        Cinema cinema = new Cinema(cinemaRequest.getName(), cinemaRequest.getCity(), cinemaRequest.getNumberOfViewingHalls());
        Cinema savedCinema = cinemaRepository.save(cinema);
        return CinemaResponse.builder()
                .name(savedCinema.getName())
                .city(savedCinema.getCity())
                .message("Success")
                .cinemaId(savedCinema.getId())
                .build();
    }


    @Override
    public Set<String> findAllCityWithCinema() {
        List<Cinema> cinemaList = cinemaRepository.findAll();
        return cinemaList.stream().map(Cinema::getCity).collect(Collectors.toSet());
    }

    @Override
    public AddHallResponse addViewingHall(AddHallRequest request) {
    Cinema cinema = cinemaRepository.findById(request.getCinemaId()).orElseThrow(()-> new MovieTicketBookingException("Cinema not found!"));
    if(hallSize(request.getCinemaId()) >= cinema.getNumberOfViewingHalls()){
        throw  new MovieTicketBookingException("Hall capacity cannot be exceeded!");
    }
        CinemaHall cinemaHall = new CinemaHall(request.getName(), request.getCapacity());
        CinemaHall[] halls = cinema.getCinemaHalls();
        halls[cinema.getHallCount()] = cinemaHall;
        cinema.setCinemaHalls(halls);
        cinema.setHallCount(cinema.getHallCount() + 1);

        Cinema updatedCinema = cinemaRepository.save(cinema);

         return AddHallResponse.builder()
                .name(updatedCinema.getName())
                .message("Hall added")
                .build();

    }

    @Override
    public int hallSize(String cinemaId) {
        return cinemaRepository.findById(cinemaId).get().getHallCount();
    }

    @Override
    public CreateShowResponse createShow(CreateShowRequest createShowRequest) {
        Cinema cinema = cinemaRepository.findById(createShowRequest.getCinemaId()).orElseThrow(()-> new MovieTicketBookingException("Cinema not found!"));
        CinemaHall hall = Arrays.stream(cinema.getCinemaHalls()).
                filter(x-> x.getName().equals(createShowRequest.getHallName())).findFirst().
                orElseThrow(()-> new MovieTicketBookingException("Hall name not found!"));

        Movie savedMovie = buildMovieRequest(createShowRequest);
        Show createdShow = buildShowRequest(createShowRequest, hall, savedMovie);
        cinema.getShowTimes().add(createdShow);
        cinemaRepository.save(cinema);
        return CreateShowResponse.builder()
                .message("Show successfully created!")
                .build();
    }

    @Override
    public Booking buyMovieTicket(BookingRequest request) {
        return bookingService.bookTicket(request);
    }

    private Show buildShowRequest(CreateShowRequest createShowRequest, CinemaHall hall, Movie savedMovie) {
        ShowRequest showRequest = ShowRequest.builder()
                .movie(savedMovie)
                .date(createShowRequest.getDate())
                .startTime(createShowRequest.getStartTime())
                .endTime(createShowRequest.getEndTime())
                .cinemaHall(hall)
                .price(createShowRequest.getPrice())
                .build();
        return showService.createShow(showRequest);
    }

    private Movie buildMovieRequest(CreateShowRequest createShowRequest) {
        MovieRequest movieRequest = MovieRequest.builder()
                .title(createShowRequest.getMovieTitle())
                .genres(createShowRequest.getGenres())
                .languages(createShowRequest.getLanguages())
                .build();
        return movieService.createMovie(movieRequest);
    }

    @Override
    public void deleteAll() {
        cinemaRepository.deleteAll();
    }

}

