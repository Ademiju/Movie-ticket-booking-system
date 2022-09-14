package com.crown.movieTicketBooking.datas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Shows")
public class Show {
    @Id
    private String id;
    private Movie movie;
    private Date date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long duration;
    private CinemaHall cinemaHall;


}
