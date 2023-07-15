package com.crown.movieTicketBooking.dtos.responses;

import lombok.*;
import org.hibernate.annotations.NaturalId;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String role;
    private boolean isEnabled = false;

}
