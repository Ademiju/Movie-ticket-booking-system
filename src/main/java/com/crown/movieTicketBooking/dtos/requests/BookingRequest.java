package com.crown.movieTicketBooking.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingRequest {
    private String userName;
    private Long cinemaId;
    private String email;
    private String movieTitle;
    private String language;
    private String date;
    private String startTime;


}
