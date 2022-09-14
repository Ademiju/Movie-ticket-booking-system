package com.crown.movieTicketBooking.services;

import com.crown.movieTicketBooking.datas.models.Show;
import com.crown.movieTicketBooking.dtos.requests.ShowRequest;

public interface ShowService {
    Show createShow(ShowRequest showRequest );
}
