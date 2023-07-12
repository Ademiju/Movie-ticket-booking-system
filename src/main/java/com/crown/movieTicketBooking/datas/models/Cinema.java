//package com.crown.movieTicketBooking.datas.models;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.*;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Builder
//public class Cinema {
//    @Id
//    private Long id;
//    private String name;
//    private String city;
//    private int hallCount;
//    @Transient
//    private CinemaHall[] cinemaHalls;
//    private int numberOfViewingHalls;
//    @OneToMany(targetEntity = Show.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "show_id", referencedColumnName = "id")
//    private List <Show> showTimes;
//
//
//    public Cinema(String name, String city, int numberOfViewingHalls) {
//        this.name = name;
//        this.city = city;
//        this.numberOfViewingHalls = numberOfViewingHalls;
//        cinemaHalls = new CinemaHall[numberOfViewingHalls];
//        showTimes = new ArrayList<>();
//    }
//
//
//
//
//}
