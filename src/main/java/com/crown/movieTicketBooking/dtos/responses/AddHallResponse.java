package com.crown.movieTicketBooking.dtos.responses;

import com.crown.movieTicketBooking.datas.models.Cinema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AddHallResponse {
    private String cinemaName;
    private String hallName;
    private String message;
}
