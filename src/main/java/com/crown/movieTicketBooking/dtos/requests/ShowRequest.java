package com.crown.movieTicketBooking.dtos.requests;

import com.crown.movieTicketBooking.datas.models.CinemaHall;
import com.crown.movieTicketBooking.datas.models.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowRequest {
    private Movie movie;
    private String date;
    private String startTime;
    private String endTime;
    private CinemaHall cinemaHall;
    private double price;

}
