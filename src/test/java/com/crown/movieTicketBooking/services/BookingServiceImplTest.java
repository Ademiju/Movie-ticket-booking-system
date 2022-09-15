package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.Booking;
import com.crown.movieTicketBooking.dtos.requests.BookingRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookingServiceImplTest {
    @Autowired
    BookingService bookingService;
    BookingRequest bookingRequest;

    @BeforeEach
    void setUp() {
        bookingRequest = BookingRequest.builder().userName("Test").email("adeyikjhfdfhuhjgjh11@gmail.com").movieTitle("GreyHound").language("English").startTime("05:10:00").build();
    }
    @Test
    void bookingCanBeMadeByUser(){
        Booking booking = bookingService.bookTicket(bookingRequest);
        assertEquals(booking.getBookingStatus().name(),"SUCCESSFUL");

    }


    

}