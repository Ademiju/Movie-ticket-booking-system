package com.crown.movieTicketBooking.dtos.responses;

import com.crown.movieTicketBooking.datas.models.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CinemaResponse {
    private String name;
    private String city;
    private String message;
    private List<Movie> movieList;
}
