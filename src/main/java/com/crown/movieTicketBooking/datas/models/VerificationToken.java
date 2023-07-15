package com.crown.movieTicketBooking.datas.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    private Date expirationTime;

    private static final int EXPIRATION_PERIOD = 15;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public VerificationToken(String token, User user) {
        this.token = token;
        this.user = user;
        this.createdDate = new Date();
        this.expirationTime = getTokenExpiration();
    }

    public VerificationToken(String token) {
        super();
        this.token = token;
        this.createdDate = new Date();
        this.expirationTime = this.getTokenExpiration();
    }

    private Date getTokenExpiration() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,EXPIRATION_PERIOD);
        return new Date(calendar.getTime().getTime());
    }
}
