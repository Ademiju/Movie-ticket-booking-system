package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.Cinema;
import com.crown.movieTicketBooking.dtos.requests.CinemaRequest;
import com.crown.movieTicketBooking.dtos.responses.CinemaResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CinemaServiceImplTest {
    @Autowired
    CinemaService cinemaService;
    @Autowired
    MovieService movieService;
@Test
    void cinemaCanBeCreatedTest(){
    CinemaRequest cinemaRequest = CinemaRequest.builder().name("360Views").city("Lagos").cinemaHallName("Hall 1")
            .cinemaHallCapacity(100).date("2022-11-21").languages("English,French").title("Only One")
            .genres("Thriller,Drama,Action").startTime("10:30:00").endTime("12:00:00").price(2320.50).build();
    CinemaResponse cinemaResponse = cinemaService.createCinema(cinemaRequest);
    assertEquals("Cinema successfully created",cinemaResponse.getMessage());
}
@AfterEach
    void tearDown(){
    cinemaService.deleteAll();
    movieService.deleteAll();
}

}
