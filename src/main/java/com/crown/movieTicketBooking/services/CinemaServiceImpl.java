package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.*;
import com.crown.movieTicketBooking.datas.repositories.*;
import com.crown.movieTicketBooking.dtos.requests.CinemaHallRequest;
import com.crown.movieTicketBooking.dtos.requests.CinemaRequest;
import com.crown.movieTicketBooking.dtos.requests.MovieRequest;
import com.crown.movieTicketBooking.dtos.requests.ShowRequest;
import com.crown.movieTicketBooking.dtos.responses.CinemaResponse;
import com.crown.movieTicketBooking.exceptions.MovieTicketBookingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.MINUTES;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    MovieService movieService;
    @Autowired
    CinemaHallService cinemaHallService;
    @Autowired
    ShowService showService;


    @Override
    public CinemaResponse createCinema(CinemaRequest cinemaRequest) {
        Cinema cinema = new Cinema();
        cinema.setName(cinemaRequest.getName());
        cinema.setCity(cinemaRequest.getCity());

        CinemaHallRequest cinemaHallRequest = CinemaHallRequest.builder()
                .cinemaHallName(cinemaRequest.getCinemaHallName())
                .cinemaHallCapacity(cinemaRequest.getCinemaHallCapacity())
                .price(cinemaRequest.getPrice()).build();

        CinemaHall savedCinemaHall = cinemaHallService.createCinemaHall(cinemaHallRequest);
        if(cinema.getCinemaHalls() != null){
            Set<CinemaHall> cinemaHalls = cinema.getCinemaHalls();
            cinemaHalls.add(savedCinemaHall);
            cinema.setCinemaHalls(cinemaHalls);
        }
        Set<CinemaHall> cinemaHalls = new HashSet<>();
        cinemaHalls.add(savedCinemaHall);
        cinema.setCinemaHalls(cinemaHalls);
        MovieRequest movieRequest = MovieRequest.builder().title(cinemaRequest.getTitle())
                .languages(cinemaRequest.getLanguages())
                .genres(cinemaRequest.getGenres()).build();

        Movie savedMovie = movieService.createMovie(movieRequest);
        if(cinema.getMovieList()!=null){
            cinema.getMovieList().add(savedMovie);
        }
        List<Movie> movieList = new ArrayList<>();
        movieList.add(savedMovie);
        cinema.setMovieList(movieList);
        ShowRequest showRequest = ShowRequest.builder().cinemaHall(savedCinemaHall)
                .date(cinemaRequest.getDate()).startTime(cinemaRequest.getStartTime())
                .endTime(cinemaRequest.getEndTime()).movie(savedMovie).build();
        Show savedShow = showService.createShow(showRequest);
        if(cinema.getShowTimes()!=null) {
            List<Show> shows = cinema.getShowTimes();
            shows.add(savedShow);
            cinema.setShowTimes(shows);
        }
        List<Show> shows = new ArrayList<>();
        shows.add(savedShow);
        cinema.setShowTimes(shows);
        Cinema savedCinema = cinemaRepository.save(cinema);

        CinemaResponse cinemaResponse = new CinemaResponse();
        cinemaResponse.setCity(savedCinema.getCity());
        cinemaResponse.setName(savedCinema.getName());
        cinemaResponse.setMessage("Cinema successfully created");

        return cinemaResponse;
    }


    @Override
    public Set<String> findAllCinema() {
        List<Cinema> cinemaList = cinemaRepository.findAll();
//        Set<String> cities = new HashSet<>();
//        for (Cinema cinema : cinemaList) {
//            cities.add(cinema.getCity());
//        }
        return cinemaList.stream().map(Cinema::getCity).collect(Collectors.toSet());
    }

    @Override
    public void deleteAll() {
        cinemaRepository.deleteAll();
    }

    @Override
    public String addMoviesToCinema(String movieTitle, String cinemaId) {
        Cinema cinema = cinemaRepository.findById(cinemaId).orElseThrow(()-> new MovieTicketBookingException("Cinema does not exist"));
        Movie movie = movieService.findMovieByTitle(movieTitle);
        cinema.getMovieList().add(movie);
        cinemaRepository.save(cinema);

        return "Movie successfully added";
    }




}

