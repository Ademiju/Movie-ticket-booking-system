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
@Builder
public class Cinema {
    @Id
    private String id;

    public Cinema(String name, String city, int numberOfViewingHalls) {
        this.name = name;
        this.city = city;
        this.numberOfViewingHalls = numberOfViewingHalls;
        cinemaHalls = new CinemaHall[numberOfViewingHalls];
        showTimes = new ArrayList<>();
    }

    private String name;
    private String city;
    private int hallCount;
    private CinemaHall[] cinemaHalls;
    private int numberOfViewingHalls;
    private List <Show> showTimes;




}
