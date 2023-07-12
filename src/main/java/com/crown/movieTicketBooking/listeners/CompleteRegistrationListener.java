package com.crown.movieTicketBooking.listeners;

import com.crown.movieTicketBooking.datas.models.User;
import com.crown.movieTicketBooking.services.UserService;
import com.crown.movieTicketBooking.services.event.CompleteRegistrationEvent;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


import java.util.Properties;
import java.util.UUID;

@Component
public class CompleteRegistrationListener implements ApplicationListener<CompleteRegistrationEvent> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @Autowired
    JavaMailSender jms;

    @Override
    public void onApplicationEvent(CompleteRegistrationEvent event) {
        User user = event.getUser();
        //Generate verification token
        String verificationToken = UUID.randomUUID().toString();
        //Save token to the database
        userService.saveVerificationToken(user,verificationToken);
        //build verification url
        String url = event.getApplicationUrl()+"/register/verifyEmail?token="+verificationToken;
        //send mail
        logger.info("Click link below to verify email : {}", url);

    }
    public void sendVerificationEmail(String url){
        String subject = "EMAIL VERIFICATION";
        String sender = "Movie Ticket Booking Service";
        String content = "";
        String host = "127.0.0.1";

        // Getting system properties
        Properties properties = System.getProperties();

        // Setting up mail server
        properties.setProperty("mail.smtp.host", host);

        // creating session object to get properties
        Session session = Session.getDefaultInstance(properties);

        try
        {
            // MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From Field: adding senders email to from field.
            message.setFrom(new InternetAddress(sender));

            // Set To Field: adding recipient's email to from field.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            // Set Subject: subject of the email
            message.setSubject(subject  );

            // set body of the email.
            message.setContent("<h1>This is a HTML text</h1>","text/html");

            // Send email.
             Transport.send(message);
            System.out.println("Mail successfully sent");
        }
        catch (MessagingException mex)
        {
            mex.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
