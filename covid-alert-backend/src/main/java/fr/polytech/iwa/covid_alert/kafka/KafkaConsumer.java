package fr.polytech.iwa.covid_alert.kafka;

import fr.polytech.iwa.covid_alert.controllers.ContactController;
import fr.polytech.iwa.covid_alert.models.Contact;
import fr.polytech.iwa.covid_alert.models.Location;
import fr.polytech.iwa.covid_alert.services.ContactService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.util.concurrent.TimeUnit.*;

@Component
public class KafkaConsumer {
    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    //Date stamp for storing location each MAX_DURATION
    private Date lastDateRecorded;
    private List<Location> locationsIn5Minutes = new ArrayList<>();
    private static long MAX_DURATION = MILLISECONDS.convert(15, SECONDS);
    private static double MAX_LAT_LONG = 1.0;

    @Autowired
    private ContactController contactController;

    public KafkaConsumer() {
        //initialize lastDateRecorded with actual date
        lastDateRecorded = new Date();
    }

    @KafkaListener(topics = "topic_covid_alert", groupId = "topic_covid_alert")
    public void consume(ConsumerRecord<String,Location> record){
        Date newDate = new Date(record.timestamp());

//        logger.info("Listener - msg : {} - recorded at: {}", record.value(), newDate);

//      If new location is in the last 5 minutes => store in locationsIn5Minutes list
        if(newDate.getTime() - lastDateRecorded.getTime() <= MAX_DURATION){
            System.out.println("- de 15 min");
            locationsIn5Minutes.add(record.value());
//            System.out.println(locationsIn5Minutes);
        }
//      Else actualize lastDateRecorded with newDate of actual location
//      and send locationsIn5Minutes for treatment to contactService
//      and empty locationsIn5Minutes
        else {
            System.out.println("+ de 15 min");
            lastDateRecorded = newDate;
            compareLocation(locationsIn5Minutes);
//            locationsIn5Minutes = new ArrayList<>();
        }
    }

    //Comparer les locations reçues pendant les 5 minutes écoulées
    //Insérer le user de la location dans la table Contact si en relation avec un autre pendant les 5 min
    //Si la ligne "user1, user2" ou "user2, user1" existe déjà dans Contact -> mettre à jour la date de contact
    public void compareLocation(List<Location> locations) {
        Location currentLocation, location2;
        List<List<String>> usersCompared1Time = new ArrayList<>();
        List<String> usersCoupleA, usersCoupleB;

        //Browse all location 1 by 1 except the last
        for(int i=0; i<locations.size()-1; i++){
            currentLocation = locations.get(i);

            //Compare currentLocation with other locations from currentLocation
            for(int j=i+1; j<locations.size(); j++){
                location2 = locations.get(j);

                //If current location in same perimeter as location compared
                if(!currentLocation.getUser_id().equals(location2.getUser_id()) &&
                        currentLocation.getLatitude() <= location2.getLatitude() + MAX_LAT_LONG &&
                        currentLocation.getLatitude() >= location2.getLatitude() - MAX_LAT_LONG &&
                        currentLocation.getLongitude() <= location2.getLongitude() + MAX_LAT_LONG &&
                        currentLocation.getLongitude() >= location2.getLongitude() - MAX_LAT_LONG
                ) {
                    //Get couple (user1, user2) of the 2 locations compared
                    usersCoupleA = Arrays.asList(currentLocation.getUser_id(), location2.getUser_id());
                    //Get couple (user2, user1) of the 2 locations compared
                    usersCoupleB = Arrays.asList(location2.getUser_id(), currentLocation.getUser_id());

                    //If the couple already got in touch through the last 5 min
                    if(usersCompared1Time.contains(usersCoupleA) || usersCompared1Time.contains(usersCoupleB)){
                        //Add the couple in table Contact of db
                        java.sql.Date date = new java.sql.Date(currentLocation.getLocation_date().getTime());

                        Contact newContact = new Contact(currentLocation.getUser_id(), location2.getUser_id(), date);
                        contactController.create(newContact);

                        System.out.println("CAS CONTACT créé : "+currentLocation.getUser_id() +" et "+location2.getUser_id());

                        //And delete the couple from usersCompared1Time
                        if(usersCompared1Time.contains(usersCoupleA)){
                            usersCompared1Time.remove(usersCoupleA);
                        }
                        if(usersCompared1Time.contains(usersCoupleB)){
                            usersCompared1Time.remove(usersCoupleB);
                        }
                    }
                    //store the user couple in usersCompared1Time
                    else {
                        usersCompared1Time.add(Arrays.asList(currentLocation.getUser_id(), location2.getUser_id()));
                    }
                }
            }
        }
    }
}
