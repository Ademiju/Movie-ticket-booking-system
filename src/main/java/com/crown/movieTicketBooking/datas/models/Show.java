//package com.crown.movieTicketBooking.datas.models;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalTime;
//import java.util.Date;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Builder
//public class Show {
//    @Id
//    private String id;
//    @ManyToOne
//    @JoinColumn(name = "movie_id")
//    private Movie movie;
//    private Date date;
//    private LocalTime startTime;
//    private LocalTime endTime;
//    private Long duration;
//    @ManyToOne
//    @JoinColumn(name = "cinema_hall_id")
//    private CinemaHall cinemaHall;
//    private double price;
//
//
//}
