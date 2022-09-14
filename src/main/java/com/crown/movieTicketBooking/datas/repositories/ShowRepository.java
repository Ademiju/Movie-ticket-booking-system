package com.crown.movieTicketBooking.datas.repositories;

import com.crown.movieTicketBooking.datas.models.Show;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.temporal.TemporalAccessor;

public interface ShowRepository extends MongoRepository<Show, String> {
    void findByDate(TemporalAccessor parse);
}
