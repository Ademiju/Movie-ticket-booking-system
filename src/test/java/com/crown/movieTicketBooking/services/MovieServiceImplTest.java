package com.crown.movieTicketBooking.services;

//import com.crown.movieTicketBooking.datas.models.Cinema;
//import com.crown.movieTicketBooking.datas.models.Movie;
//import com.crown.movieTicketBooking.datas.models.Show;
import com.crown.movieTicketBooking.dtos.requests.CreateCinemaRequest;
import com.crown.movieTicketBooking.dtos.requests.MovieRequest;
import com.crown.movieTicketBooking.dtos.responses.CinemaResponse;
//import com.crown.movieTicketBooking.dtos.responses.MovieInfoResponse;
import com.crown.movieTicketBooking.exceptions.MovieTicketBookingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieServiceImplTest {

    @Autowired
    MovieService movieService;
    @Autowired
    CinemaService cinemaService;

    MovieRequest movieRequest;
    MovieRequest movieRequest2;
//    Movie movie;
//    Movie movie2;



//    @BeforeEach
//    void setUp(){
//         movieRequest = MovieRequest.builder().title("Coming to America")
//                 .genres("Thriller,Comedy").languages("English,French,Spanish").build();
//         movieRequest2 = MovieRequest.builder().title("Blood sisters")
//                 .genres("Drama,Thriller,Action").languages("English").build();
//
//         movie = movieService.createMovie(movieRequest);
//         movie2 = movieService.createMovie(movieRequest2);
//
//    }

//    @Test
//    void movieCanBeCreated(){
//        assertEquals("coming to america", movie.getTitle());
//        assertEquals("blood sisters", movie2.getTitle());
//
//        assertEquals(2, movie.getGenre().size());
//        assertEquals(3, movie2.getGenre().size());
//
//    }
//    @Test
//    void createMovieThatAlreadyExistThrowsException(){
//        assertThatThrownBy(()->movieService.createMovie(movieRequest))
//                .isInstanceOf(MovieTicketBookingException.class)
//                .hasMessage("Movie already exist");
//    }
//
//
//    @Test
//    void findMovieByTitleTest(){
//        Movie found = movieService.findMovieByTitle("Coming to America");
//        assertEquals("coming to america", found.getTitle());
//    }

//    @Test
//    void findMovieByGenreTest(){
//        List <Movie> thrillerMovies = movieService.findMovieByGenre("Thriller");
//        List <Movie> dramaMovies = movieService.findMovieByGenre("drama");
//        assertEquals(2, thrillerMovies.size());
//        assertEquals(1,dramaMovies.size());
//
//    }

//    @Test
//    void findMovieByLanguageTest(){
//        List<Movie> movies = movieService.findMovieByLanguage("english");
//        assertEquals(2, movies.size());
//    }

    @Test
    void findMovieByCityTest(){
//        cinemaService.createCinema(cinemaRequest);
//
//        cinemaService.addMoviesToCinema(movieRequest);
//        cinemaService.addMoviesToCinema(movieRequest2);
//        cinemaService.addMoviesToCinema(movieRequest3);
//        List<List<Movie>> movies = movieService.findMovieByCity("abuja");
//
//        assertEquals(2, movies.size());
    }

//    @Test
//    void  testThatCinemasShowingMovieCanBeViewed(){
//        CreateCinemaRequest cinemaRequest = CreateCinemaRequest.builder().name("360Views").city("Lagos").numberOfViewingHalls(3).build();
//        CinemaResponse response1 = cinemaService.createCinema(cinemaRequest);
//
//        Show show1 = Show.builder()
//                .movie(movie)
//                .build();
//        List<Show > shows = new ArrayList<>();
//        shows.add(show1);
//
//        Cinema cinema1 = Cinema.builder()
//                .id(response1.getCinemaId())
//                .name(cinemaRequest.getName())
//                .city(cinemaRequest.getCity())
//                .showTimes(shows)
//                .numberOfViewingHalls(cinemaRequest.getNumberOfViewingHalls())
//                .build();
//        CreateCinemaRequest cinemaRequest1 = CreateCinemaRequest.builder().name("Silverbird").city("Lagos").numberOfViewingHalls(3).build();
//        CinemaResponse response2 = cinemaService.createCinema(cinemaRequest1);
//
//        Show show2 = Show.builder()
//                .movie(movie)
//                .build();
//        List<Show > shows2 = new ArrayList<>();
//        shows.add(show2);
//
//        Cinema cinema2 = Cinema.builder()
//                .id(response2.getCinemaId())
//                .name(cinemaRequest1.getName())
//                .city(cinemaRequest1.getCity())
//                .showTimes(shows2)
//                .numberOfViewingHalls(cinemaRequest1.getNumberOfViewingHalls())
//                .build();
//        cinema2.getShowTimes().add(show2);
//
//        movie.getCinemaList().add(cinema1);
//        movie.getCinemaList().add(cinema2);
//        Movie updatedMovie = movieService.update(movie.getTitle());
//        MovieInfoResponse response= movieService.displayCinemasAndShows(updatedMovie.getTitle());
//        assertEquals(2, movie.getCinemaList().size() );
//    }
    @AfterEach
    void tearDown(){
        movieService.deleteAll();
        cinemaService.deleteAll();
    }
}