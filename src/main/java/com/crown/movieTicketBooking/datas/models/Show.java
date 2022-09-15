package com.crown.movieTicketBooking.datas.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Shows")
@Builder
public class Show {
    @Id
    private String id;
    private Movie movie;
    private Date date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long duration;
    private CinemaHall cinemaHall;
    private double price;


}
