package com.crown.movieTicketBooking.datas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaHall {
    @Id
    private String id;
    private String name;
    private int capacity;
    private Seat seat;
    private List<Show> showList;

}
