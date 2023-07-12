package com.crown.movieTicketBooking.services;

//import com.crown.movieTicketBooking.datas.models.Show;
//import com.crown.movieTicketBooking.datas.repositories.ShowRepository;
//import com.crown.movieTicketBooking.dtos.requests.ShowRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.sql.Date;
import java.time.LocalTime;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.MINUTES;

//@Service
//public class ShowServiceImpl implements ShowService {
//    @Autowired
//    ShowRepository showRepository;

//    @Override
//    public Show createShow(ShowRequest showRequest) {
//        Show show = new Show();
//        show.setMovie(showRequest.getMovie());
//        show.setCinemaHall(showRequest.getCinemaHall());
//
//        LocalTime startTime = LocalTime.parse(showRequest.getStartTime());
//        LocalTime endTime = LocalTime.parse(showRequest.getEndTime());
//        Date date = Date.valueOf(showRequest.getDate());
//        show.setDate(date);
//        show.setPrice(showRequest.getPrice());
//        show.setStartTime(startTime);
//        show.setEndTime(endTime);
//        show.setDuration(MINUTES.between(startTime, endTime));
//        return showRepository.save(show);
//    }
//}
