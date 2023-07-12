package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.RegistrationUserDetails;
import com.crown.movieTicketBooking.datas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RegistrationUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).map(RegistrationUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("User not found"));

    }
}
