package fr.polytech.iwa.covid_alert.controllers;

import fr.polytech.iwa.covid_alert.kafka.KafkaProducer;
import fr.polytech.iwa.covid_alert.models.Location;
import fr.polytech.iwa.covid_alert.models.LocationData;
import org.keycloak.KeycloakPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
//import java.util.Date;


@CrossOrigin
@RestController
@RequestMapping("api")
public class LocationController {
    @Autowired
    private KafkaProducer kafkaProducer;

    /**
     * POST api/locations
     * @param body LocationConst
     * @param Authorization String
     * @return void
     */
    @PostMapping(value="/location")
    public Location sendMessageToKafkaTopic(
            @RequestBody LocationData body,
            @RequestHeader String Authorization
    ) throws Exception {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!(principal instanceof KeycloakPrincipal))
             throw new Exception("Authentication error");
        else {
            Location location = new Location();
            location.setLatitude(body.getLatitude());
            location.setLongitude(body.getLongitude());
            location.setLocation_date(new Date(body.getTimestamp()));
            location.setUser_id(((KeycloakPrincipal)principal).getName());
            this.kafkaProducer.saveLocation(location);
            return location;
        }




    }
}
