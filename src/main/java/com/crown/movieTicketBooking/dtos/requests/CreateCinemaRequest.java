package com.crown.movieTicketBooking.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCinemaRequest {
    private String name;
    private String city;
//    private String title;
//    private String languages;
//    private String genres;
//    private String date;
//    private String startTime;
//    private String endTime;
//    private String cinemaHallName;
    private int numberOfViewingHalls;
//    private double price;

}
