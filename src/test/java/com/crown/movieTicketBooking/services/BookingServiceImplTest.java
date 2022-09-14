package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.Booking;
import com.crown.movieTicketBooking.dtos.requests.BookingRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceImplTest {
    @Autowired
    UserService userService;
    @Autowired
    BookingService bookingService;
    BookingRequest bookingRequest;

    @BeforeEach
    void setUp() {
        bookingRequest = BookingRequest.builder().userName("Test").email("test@mail.com").movieTitle("GreyHound").language("English").seatNumber("34").showTime("05:10:00").build();
    }
    @Test
    void bookingCanBeMadeByUser(){
        Booking booking = bookingService.bookTicket(bookingRequest);
        assertEquals(booking.getBookingStatus().name(),"SUCCESSFUL");

    }


    

}