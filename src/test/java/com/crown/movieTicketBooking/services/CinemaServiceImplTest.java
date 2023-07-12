package com.crown.movieTicketBooking.services;

//import com.crown.movieTicketBooking.datas.models.Booking;
//import com.crown.movieTicketBooking.datas.models.Movie;
import com.crown.movieTicketBooking.dtos.requests.*;
import com.crown.movieTicketBooking.dtos.responses.CinemaResponse;
import com.crown.movieTicketBooking.dtos.responses.CreateShowResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CinemaServiceImplTest {
    @Autowired
    CinemaService cinemaService;
    @Autowired
    MovieService movieService;
    @Autowired
    BookingService bookingService;
    BookingRequest bookingRequest;
    CreateCinemaRequest cinemaRequest;
    MovieRequest movieRequest;
    MovieRequest movieRequest2;
//    Movie movie;
//    Movie movie2;


//    @BeforeEach
//    void setUp(){
//        createCinema();
//        movieRequest = MovieRequest.builder().title("Coming to America")
//                .genres("Thriller,Comedy").languages("English,French,Spanish").build();
//        movieRequest2 = MovieRequest.builder().title("Blood sisters")
//                .genres("Drama,Thriller,Action").languages("English").build();
//
//        movie = movieService.createMovie(movieRequest);
//        movie2 = movieService.createMovie(movieRequest2);
//    }
@Test
    void cinemaCanBeCreatedTest(){

    CinemaResponse cinemaResponse = cinemaService.createCinema(cinemaRequest);
    assertEquals("Success",cinemaResponse.getMessage());
}

@Test
    void cinemaCanAddHall(){
    CinemaResponse response = cinemaService.createCinema(cinemaRequest);
    AddHallRequest request = AddHallRequest.builder().name("Hall1").capacity(300).cinemaId(response.getCinemaId()).build();
    cinemaService.addViewingHall(request);
    assertEquals(1, cinemaService.hallSize(request.getCinemaId()));
}
@Test
void testThatCinemaCanAddShow(){
    CinemaResponse response = cinemaService.createCinema(cinemaRequest);
    AddHallRequest request = AddHallRequest.builder().name("Hall1").capacity(300).cinemaId(response.getCinemaId()).build();
    cinemaService.addViewingHall(request);
    CreateShowRequest createShowRequest = CreateShowRequest.builder()
            .cinemaId(response.getCinemaId())
            .date("2002-07-09")
            .startTime("13:00:00")
            .endTime("15:30:00")
            .hallName("Hall1")
            .movieTitle("Lion King")
            .price(700.00)
            .build();
//    CreateShowResponse response1 = cinemaService.createShow(createShowRequest);
//    assertEquals("Show successfully created!", response1.getMessage());
}
//    @Test
//    void bookingCanBeMadeByUser(){
//        CinemaResponse response = cinemaService.createCinema(cinemaRequest);
//        AddHallRequest request = AddHallRequest.builder().name("Hall1").capacity(300).cinemaId(response.getCinemaId()).build();
//        cinemaService.addViewingHall(request);
//        CreateShowRequest createShowRequest = CreateShowRequest.builder()
//                .cinemaId(response.getCinemaId())
//                .date("2002-07-09")
//                .startTime("13:00:00")
//                .endTime("15:30:00")
//                .hallName("Hall1")
//                .movieTitle("Lion King")
//                .price(700.00)
//                .build();
//        CreateShowResponse response1 = cinemaService.createShow(createShowRequest);
//        bookingRequest = BookingRequest.builder().userName("Test").email("adeyikjhfdfhuhjgjh11@gmail.com").movieTitle("Lion King").language("english").startTime("13:00:00").date("2022-07-09").cinemaId(response.getCinemaId()).build();
//        Booking booking = bookingService.bookTicket(bookingRequest);
//        assertEquals(booking.getBookingStatus().name(),"SUCCESSFUL");}
@AfterEach
    void tearDown(){
    cinemaService.deleteAll();
    movieService.deleteAll();
}

void createCinema(){
    cinemaRequest = CreateCinemaRequest.builder().name("360Views").city("Lagos").numberOfViewingHalls(3).build();
}

}
