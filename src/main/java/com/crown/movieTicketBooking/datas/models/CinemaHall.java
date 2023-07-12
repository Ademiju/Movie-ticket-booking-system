package com.crown.movieTicketBooking.datas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int capacity;
    @Transient
    private boolean[] seats;
    private int occupiedSeats;

    public CinemaHall(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        seats = new boolean[capacity];
    }
}
