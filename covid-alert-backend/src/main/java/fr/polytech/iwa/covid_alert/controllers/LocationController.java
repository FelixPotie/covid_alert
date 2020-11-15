package fr.polytech.iwa.covid_alert.controllers;

import fr.polytech.iwa.covid_alert.kafka.KafkaProducer;
import fr.polytech.iwa.covid_alert.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
//@RequestMapping("api/locations")
public class LocationController {
    @Autowired
    private KafkaProducer kafkaProducer;

    LocationController(KafkaProducer kafkaProducer){
        kafkaProducer = kafkaProducer;
    }

    /**
     * POST api/locations
     * @param userId String
     * @param latitude float
     * @param longitude float
     * @param date Date
     * @return void
     */
    @PostMapping(value="/location")
    public void sendMessageToKafkaTopic(
            @RequestParam String userId,
            @RequestParam float latitude,
            @RequestParam float longitude,
            @RequestParam Date date
    ) {
        Location location = new Location();
        location.setUser_id(userId);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        location.setLocation_date(date);

        this.kafkaProducer.saveLocation(location);
    }
}
