package com.crown.movieTicketBooking.dtos.requests;

import com.crown.movieTicketBooking.datas.models.Seat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CinemaRequest {
    private String name;
    private String city;
    private String title;
    private String languages;
    private String genres;
    private String date;
    private String startTime;
    private String endTime;
    private String cinemaHallName;
    private int cinemaHallCapacity;
    private double price;

}
