package fr.polytech.iwa.covid_alert.kafka;

import fr.polytech.iwa.covid_alert.models.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public void saveLocation(Location location){
        logger.info(String.format("[Producer] Location created -> %s", location));
        this.kafkaTemplate.send("topic_covid_alert", location);
    }
}
