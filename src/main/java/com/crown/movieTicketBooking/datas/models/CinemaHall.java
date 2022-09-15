package com.crown.movieTicketBooking.datas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaHall {
    @Id
    private String id;
    private String name;
    private int capacity;
    private boolean[] seats;
    private int occupiedSeats;

    public CinemaHall(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        seats = new boolean[capacity];
    }
}
