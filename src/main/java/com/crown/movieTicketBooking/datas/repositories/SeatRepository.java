package com.crown.movieTicketBooking.datas.repositories;

import com.crown.movieTicketBooking.datas.models.Seat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeatRepository extends MongoRepository<Seat, String> {
}
