package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.Cinema;
import com.crown.movieTicketBooking.datas.models.Movie;
import com.crown.movieTicketBooking.datas.models.Show;
import com.crown.movieTicketBooking.datas.repositories.CinemaRepository;
import com.crown.movieTicketBooking.datas.repositories.MovieRepository;
import com.crown.movieTicketBooking.dtos.requests.MovieRequest;
import com.crown.movieTicketBooking.dtos.responses.MovieInfoResponse;
import com.crown.movieTicketBooking.exceptions.MovieTicketBookingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public Movie createMovie(MovieRequest movieRequest) {

        Optional<Movie> optionalMovie = movieRepository.findMovieByTitle(movieRequest.getTitle().toLowerCase());
        if (optionalMovie.isPresent() )throw new MovieTicketBookingException("Movie already exist");
        Movie movie = new Movie();
        movie.setTitle(movieRequest.getTitle().toLowerCase());
        String[] genres = movieRequest.getGenres().toLowerCase().split(",");
        Set<String> genreSet = new HashSet<>(Arrays.asList(genres));
        movie.setGenre(genreSet);
        String[] languages = movieRequest.getLanguages().toLowerCase().split(",");
        Set<String> languageSet = new HashSet<>(Arrays.asList(languages));
        movie.setLanguage(languageSet);
        return movieRepository.save(movie);

    }

    @Override
    public Movie findMovieByTitle(String movieTitle) {
        return movieRepository.findMovieByTitle(movieTitle.toLowerCase()).orElseThrow(()-> new MovieTicketBookingException("Movie not available at the moment"));
    }

    @Override
    public List<Movie> findMovieByGenre(String genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre().contains(genre.toLowerCase())).collect(Collectors.toList());
    }
    @Override
    public List<Movie> findMovieByLanguage(String language) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getLanguage().contains(language.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public List<Movie> findMovieByCity(String city) {
        List<Cinema> cinemaList = cinemaRepository.findByCity(city.toLowerCase());
        if(cinemaList.isEmpty()) throw new MovieTicketBookingException("No cinema in this city");
        return null;
    }

    @Override
    public Movie update(Movie movie) {
        Optional<Movie> optionalMovie = movieRepository.findMovieByTitle(movie.getTitle().toLowerCase());
        if (optionalMovie.isEmpty())throw new MovieTicketBookingException("Movie does not exist!");
        Movie foundMovie = optionalMovie.get();
       Movie mappedMovie = modelMapper.map(foundMovie,Movie.class);
        System.out.println(mappedMovie.getCinemaList().size());
       return movieRepository.save(mappedMovie);


    }

    @Override
    public void deleteAll() {
        movieRepository.deleteAll();
    }

    @Override
    public MovieInfoResponse displayCinemasAndShows(String movieTitle) {
        Movie movie = movieRepository.findMovieByTitle(movieTitle).orElseThrow(() -> new MovieTicketBookingException("Movie not found"));
        List <Show> shows = new ArrayList<>();
        for (Cinema cinema : movie.getCinemaList()) {
            shows.addAll(cinema.getShowTimes());
        }
        return MovieInfoResponse.builder()
                .cinemaList(movie.getCinemaList())
                .showList(shows)
                .build();
    }
}