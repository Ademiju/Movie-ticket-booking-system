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


//    @Override
//    public CinemaResponse createCinema(CinemaRequest cinemaRequest) {
//        Cinema cinema = new Cinema();
//        cinema.setName(cinemaRequest.getName());
//        cinema.setCity(cinemaRequest.getCity());
//
//        CinemaHallRequest cinemaHallRequest = CinemaHallRequest.builder()
//                .cinemaHallName(cinemaRequest.getCinemaHallName())
//                .cinemaHallCapacity(cinemaRequest.getCinemaHallCapacity())
//                .price(cinemaRequest.getPrice()).build();
//
//        CinemaHall savedCinemaHall = cinemaHallService.createCinemaHall(cinemaHallRequest);
//        if(cinema.getCinemaHalls() != null){
//            Set<CinemaHall> cinemaHalls = cinema.getCinemaHalls();
//            cinemaHalls.add(savedCinemaHall);
//            cinema.setCinemaHalls(cinemaHalls);
//        }
//        Set<CinemaHall> cinemaHalls = new HashSet<>();
//        cinemaHalls.add(savedCinemaHall);
//        cinema.setCinemaHalls(cinemaHalls);
//        MovieRequest movieRequest = MovieRequest.builder().title(cinemaRequest.getTitle())
//                .languages(cinemaRequest.getLanguages())
//                .genres(cinemaRequest.getGenres()).build();
//
//        Movie savedMovie = movieService.createMovie(movieRequest);
//        if(cinema.getMovieList()!=null){
//            cinema.getMovieList().add(savedMovie);
//        }
//        List<Movie> movieList = new ArrayList<>();
//        movieList.add(savedMovie);
//        cinema.setMovieList(movieList);
//        ShowRequest showRequest = ShowRequest.builder().cinemaHall(savedCinemaHall)
//                .date(cinemaRequest.getDate()).startTime(cinemaRequest.getStartTime())
//                .endTime(cinemaRequest.getEndTime()).movie(savedMovie).build();
//        Show savedShow = showService.createShow(showRequest);
//        if(cinema.getShowTimes()!=null) {
//            List<Show> shows = cinema.getShowTimes();
//            shows.add(savedShow);
//            cinema.setShowTimes(shows);
//        }
//        List<Show> shows = new ArrayList<>();
//        shows.add(savedShow);
//        cinema.setShowTimes(shows);
//        Cinema savedCinema = cinemaRepository.save(cinema);
//
//        CinemaResponse cinemaResponse = new CinemaResponse();
//        cinemaResponse.setCity(savedCinema.getCity());
//        cinemaResponse.setName(savedCinema.getName());
//        cinemaResponse.setMessage("Cinema successfully created");
//
//        return cinemaResponse;
//    }


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

//    @Override
//    public String addMoviesToCinema(String movieTitle, String cinemaId) {
//        Cinema cinema = cinemaRepository.findById(cinemaId).orElseThrow(()-> new MovieTicketBookingException("Cinema does not exist"));
//        Movie movie = movieService.findMovieByTitle(movieTitle);
//        cinema.getMovieList().add(movie);
//        cinemaRepository.save(cinema);
//
//        return "Movie successfully added";
//    }




}

