package com.crown.movieTicketBooking.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateShowRequest {
    private String cinemaId;
    private String movieTitle;
    private String startTime;
    private String endTime;
    private String hallName;
    private double price;
    private String date;

}
