package com.crown.movieTicketBooking.datas.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Booking {
    @Id
    private String id;
    private Show show;
    private Long movieDuration;
    private Status bookingStatus;
    private double ticketPrice;

}
