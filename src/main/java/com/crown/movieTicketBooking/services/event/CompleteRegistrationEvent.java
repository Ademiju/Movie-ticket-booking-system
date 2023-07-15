package com.crown.movieTicketBooking.services.event;

import com.crown.movieTicketBooking.datas.models.User;
import com.crown.movieTicketBooking.dtos.responses.UserResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class CompleteRegistrationEvent extends ApplicationEvent {

    private UserResponse userResponse;
    private String applicationUrl;

//    public CompleteRegistrationEvent(User user, String applicationUrl) {
//        super(user);
//        this.user = user;
//        this.applicationUrl = applicationUrl;
//    }
    public CompleteRegistrationEvent(UserResponse userResponse, String applicationUrl) {
        super(userResponse);
        this.userResponse = userResponse;
        this.applicationUrl = applicationUrl;
    }
}
