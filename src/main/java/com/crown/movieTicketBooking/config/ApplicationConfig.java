//package com.crown.movieTicketBooking.config;
//
//import com.crown.movieTicketBooking.datas.repositories.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//@Configuration
//@RequiredArgsConstructor
//public class ApplicationConfig {
//    @Autowired
//    UserRepository userRepository;

//    @Bean
//    public UserDetailsService userDetailsService(){
//        return username -> (UserDetails) userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
//    }
//}
