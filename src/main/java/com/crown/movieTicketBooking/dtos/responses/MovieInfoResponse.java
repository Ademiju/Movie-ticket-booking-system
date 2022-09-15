package com.crown.movieTicketBooking.dtos.responses;

import com.crown.movieTicketBooking.datas.models.Cinema;
import com.crown.movieTicketBooking.datas.models.Show;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieInfoResponse {
    private String movieTitle;
    private List<Cinema> cinemaList;
    private List <Show> showList;
}
