package com.crown.movieTicketBooking.datas.repositories;

import com.crown.movieTicketBooking.datas.models.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
    VerificationToken findByToken(String token);
}
