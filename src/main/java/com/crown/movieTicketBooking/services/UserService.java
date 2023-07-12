package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.User;
import com.crown.movieTicketBooking.datas.models.VerificationToken;
import com.crown.movieTicketBooking.dtos.requests.RegistrationRequest;
import com.crown.movieTicketBooking.dtos.responses.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    UserResponse registerUser(RegistrationRequest registrationRequest);
    Optional<User> findUserByEmail();
    void saveVerificationToken(User user, String verificationToken);

    void validateToken(String token);
}
