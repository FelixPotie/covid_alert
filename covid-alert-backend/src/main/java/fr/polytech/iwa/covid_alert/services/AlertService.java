package fr.polytech.iwa.covid_alert.services;

import fr.polytech.iwa.covid_alert.models.Alert;
import fr.polytech.iwa.covid_alert.repositories.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;


    /**
     *
     * @param user_id String
     * @return the alert of the user with the id
     */
    public List<Alert> getAlertByUserId(String user_id) {
        return alertRepository.findAlertsByUser_id(user_id);
    }

    /**
     *  json data :
     *      - long alert_id
     *      - Date contamination_date
     *      - Date alert_date
     *      - String user_id
     * @param alert Alert
     * @return the alert created
     */
    public Alert createAlert( final Alert alert){
        return alertRepository.saveAndFlush(alert);
    }


}
