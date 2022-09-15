package com.crown.movieTicketBooking.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddHallRequest {
    public String cinemaId;
    private String name;
    private int capacity;
}
