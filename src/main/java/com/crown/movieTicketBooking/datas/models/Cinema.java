package com.crown.movieTicketBooking.datas.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Cinemas")
public class Cinema {
    @Id
    private String id;
    private String name;
    private String city;
    private Set<CinemaHall> cinemaHalls;
    private List<Movie> movieList;
    private List <Show> showTimes;


}
