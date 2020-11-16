package fr.polytech.iwa.covid_alert.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Properties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Component
public class MailService {

    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private int port;
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void sendEmail(String mail) {
        //Create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.getHost());
        mailSender.setPort(this.getPort());
        mailSender.setUsername(this.getUsername());
        mailSender.setPassword(this.getPassword());

        //Create an email instance
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("covidalertmail@gmail.com");
        mailMessage.setTo(mail);
        mailMessage.setSubject("ALERT COVID - VOUS ÊTES CAS CONTACT");
        mailMessage.setText("Bonjour, vous êtes cas contact, nous vous conseillons d'aller vous faire depister.");

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
