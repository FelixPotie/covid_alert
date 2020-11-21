package fr.polytech.iwa.covid_alert.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;
import java.util.Calendar;
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

    /**
     * Send an Email to the mail and tell the contact date and advise a test date
     * @param mail String
     * @param date_contact Date sql
     */
    public void sendEmail(String mail, Date date_contact) {
        //Calculate date of test
        Calendar c = Calendar.getInstance();
        c.setTime(date_contact);
        c.add(Calendar.DATE, 7);
        Date date_test= new Date(c.getTimeInMillis());

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
        mailMessage.setText("Bonjour, vous avez étais en contact (le "+ date_contact+")  avec une personne testée positive au COVID19. Nous vous conseillons de vous mettre en quarantaine et d'aller vous faire dépister le " + date_test + ". En effet, après avoir était en contact, il est recommandé de rester chez soi et d'aller se faire tester 7 jours après le dernier contact avec la personne malade.");

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
