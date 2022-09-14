package com.crown.movieTicketBooking.dtos.requests;

import com.crown.movieTicketBooking.datas.models.Show;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieRequest {
    private String title;
    private String languages;
    private String genres;

}
