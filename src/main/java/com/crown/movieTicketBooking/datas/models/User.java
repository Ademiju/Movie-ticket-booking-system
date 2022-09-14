package com.crown.movieTicketBooking.datas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Users")
public class User {
    @Id
    private String id;
    private String name;
    private String phoneNumber;
    Account account;
    private Role role;


}
