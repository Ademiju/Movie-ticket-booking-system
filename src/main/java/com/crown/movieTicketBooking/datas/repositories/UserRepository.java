package com.crown.movieTicketBooking.datas.repositories;

import com.crown.movieTicketBooking.datas.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
