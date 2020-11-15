package fr.polytech.iwa.covid_alert.controllers;

import fr.polytech.iwa.covid_alert.services.MailService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


@RestController
@RequestMapping("api/mails")
public class MailController {
    private MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping(value = "/{mail}")
    public void sendEmail(@PathVariable String mail) {
        //Create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.mailService.getHost());
        mailSender.setPort(this.mailService.getPort());
        mailSender.setUsername(this.mailService.getUsername());
        mailSender.setPassword(this.mailService.getPassword());

        //Create an email instance

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("covidalertmail@gmail.com");
        mailMessage.setTo(mail);
        mailMessage.setSubject("ALERT COVID - VOUS ÊTES CAS CONTACT");
        mailMessage.setText("bonjour, vous êtes cas contact, nous vous conseillons d'aller vous faire depister.");

        //Set properties
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");

        mailSender.setJavaMailProperties(javaMailProperties);

        //Send the mail

        mailSender.send(mailMessage);
    }
}
