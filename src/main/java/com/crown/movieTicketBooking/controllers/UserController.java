package com.crown.movieTicketBooking.controllers;

import com.crown.movieTicketBooking.datas.models.User;
import com.crown.movieTicketBooking.datas.models.VerificationToken;
import com.crown.movieTicketBooking.datas.repositories.VerificationTokenRepository;
import com.crown.movieTicketBooking.dtos.requests.CommonConstant;
import com.crown.movieTicketBooking.dtos.requests.RegistrationRequest;
import com.crown.movieTicketBooking.dtos.responses.UserResponse;
import com.crown.movieTicketBooking.services.UserService;
import com.crown.movieTicketBooking.services.event.CompleteRegistrationEvent;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(CommonConstant.API_VERSION+"/users")
public class UserController{
    @Autowired
    UserService userService;
    @Autowired
    ApplicationEventPublisher publisher;
    @Autowired
    VerificationTokenRepository verificationTokenRepository;

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationRequest registrationRequest, HttpServletRequest request){
        UserResponse userResponse = userService.registerUser(registrationRequest);
        publisher.publishEvent(new CompleteRegistrationEvent(userResponse, getApplicationUrl(request)));
        return "Check "+registrationRequest.getEmail()+" to complete registration";
    }

    public String getApplicationUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+":"+request.getServerPort()+request
                .getContextPath();
    }

    @GetMapping("/verifyEmail")
    public String verifyEmail(@RequestParam("token") String token){
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        if(verificationToken.getUser().isEnabled()){
            return "Your account is already verified. Proceed to Login";
        }
        userService.validateToken(token);
        return "Verification token Successfully Validated. Proceed to Login";

    }


}
