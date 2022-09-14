package com.crown.movieTicketBooking.datas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    @Id
    private String id;
    private String[] seats;
    private BigDecimal price;

}
