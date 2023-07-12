//package com.crown.movieTicketBooking.datas.models;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class Movie {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String title;
//    private Set<String> language;
//    private Set<String> genre;
//    @OneToMany(targetEntity = Cinema.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "cinema_id", referencedColumnName = "id")
//    private List <Cinema> cinemaList = new ArrayList<>();
//
//
//
//}
