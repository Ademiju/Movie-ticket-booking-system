package com.crown.movieTicketBooking.datas.repositories;

import com.crown.movieTicketBooking.datas.models.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
