package com.crown.movieTicketBooking.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AddHallResponse {
    private String name;
    private String message;
}
