package fr.polytech.iwa.covid_alert.controllers;

import fr.polytech.iwa.covid_alert.services.MailService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;


@RestController
@RequestMapping("api/mails")
public class MailController {
    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping(value = "/{mail}")
    public void send(@PathVariable String mail) {
        Date date = Date.valueOf(LocalDate.now());
        mailService.sendEmail(mail,date);
    }
}
