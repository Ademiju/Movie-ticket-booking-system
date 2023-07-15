package com.crown.movieTicketBooking.listeners;

import com.crown.movieTicketBooking.datas.models.User;
import com.crown.movieTicketBooking.dtos.responses.UserResponse;
import com.crown.movieTicketBooking.services.UserService;
import com.crown.movieTicketBooking.services.event.CompleteRegistrationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


import java.util.UUID;

@Component
public class CompleteRegistrationListener implements ApplicationListener<CompleteRegistrationEvent> {
    private UserResponse userResponse;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @Autowired
    JavaMailSender jms;

    @Value("${email_subject}")
    String EMAIL_SUBJECT;
    @Value("${verification_email_content}")
    String EMAIL_CONTENT;
    @Value("${email_sender_name}")
    String SENDER_NAME;
//    @Value("${email_sender_address}")
//    String SENDER_EMAIL;

    @Override
    public void onApplicationEvent(CompleteRegistrationEvent event) {
        userResponse = event.getUserResponse();
        User user = fromUserResponseToUser(userResponse);
        //Generate verification token
        String verificationToken = UUID.randomUUID().toString();
        //Save token to the database
        userService.saveVerificationToken(user,verificationToken);
        //build verification url
        String url = event.getApplicationUrl()+"/register/verifyEmail?token="+verificationToken;
        //send mail
        logger.info("Click link below to verify email : {}", url);

    }

    private User fromUserResponseToUser(UserResponse userResponse) {
       User user = new User();
       BeanUtils.copyProperties(userResponse,user);
       return user;
    }

    public void sendVerificationEmail(String url) {
        String content = String.format(EMAIL_CONTENT, userResponse.getFirstName(), url);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userResponse.getEmail());
        mailMessage.setFrom(SENDER_NAME);
        mailMessage.setSubject(EMAIL_SUBJECT);
        mailMessage.setText(content);
        jms.send(mailMessage);
    }
}
