package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.Booking;
import com.crown.movieTicketBooking.dtos.requests.BookingRequest;

public interface BookingService {
    Booking bookTicket(BookingRequest bookingRequest);
}
