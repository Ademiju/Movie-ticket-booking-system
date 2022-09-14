package com.crown.movieTicketBooking.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CinemaHallRequest {
    private String cinemaHallName;
    private int cinemaHallCapacity;
    private int seatNumber;
    private double price;

}
