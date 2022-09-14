package com.crown.movieTicketBooking.datas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Bookings")
public class Booking {
    @Id
    private String id;
    private String cinemaName;
    private String city;
    private String cinemaHallName;
    private int seatNumber;
    private String movieTitle;
    private String movieLanguage;
    private String[] movieGenres;
    private LocalDate showingDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private double movieDuration;
    private Status bookingStatus;
    private BigDecimal ticketPrice;

}
