package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.Role;
import com.crown.movieTicketBooking.datas.models.User;
import com.crown.movieTicketBooking.datas.models.VerificationToken;
import com.crown.movieTicketBooking.datas.repositories.UserRepository;
import com.crown.movieTicketBooking.datas.repositories.VerificationTokenRepository;
import com.crown.movieTicketBooking.dtos.requests.RegistrationRequest;
import com.crown.movieTicketBooking.dtos.responses.UserResponse;
import com.crown.movieTicketBooking.exceptions.TokenValidationException;
import com.crown.movieTicketBooking.exceptions.UserAlreadyExistException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    VerificationTokenRepository verificationTokenRepository;

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public UserResponse registerUser(RegistrationRequest registrationRequest) {
        Optional<User> optionalUser = this.findUserByEmail();
        if(optionalUser.isPresent()){throw new UserAlreadyExistException("User with email "+registrationRequest.getEmail()+"already exist");}

        User user = User.builder().firstName(registrationRequest.getFirstName()).lastName(registrationRequest.getLastName())
                .email(registrationRequest.getEmail()).password(passwordEncoder.encode(registrationRequest.getPassword())).role(Role.USER)
                .build();
        userRepository.save(user);
        return fromUserToUserResponse(user) ;
    }

    public UserResponse fromUserToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user,userResponse);
        return userResponse;
    }

    @Override
    public Optional<User> findUserByEmail() {
        return Optional.empty();
    }

    @Override
    public void saveVerificationToken(User user, String verificationToken) {
        VerificationToken token = VerificationToken.builder().token(verificationToken).user(user).build();
        verificationTokenRepository.save(token);
    }

    @Override
    public void validateToken(String token) {
        VerificationToken verifiedToken = verificationTokenRepository.findByToken(token);
        if(verifiedToken == null) throw new TokenValidationException("Verification token "+token+" is Invalid");
        User user = verifiedToken.getUser();
        Calendar calendar = Calendar.getInstance();
        if(verifiedToken.getExpirationTime().getTime() - calendar.getTime().getTime() <= 0) {
            verificationTokenRepository.delete(verifiedToken);
            throw new TokenValidationException("Verification token "+token+" is Expired");
        }
        user.setEnabled(true);
        userRepository.save(user);
    }

}
