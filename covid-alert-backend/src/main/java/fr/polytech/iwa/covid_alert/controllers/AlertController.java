package fr.polytech.iwa.covid_alert.controllers;

import fr.polytech.iwa.covid_alert.models.Alert;
import fr.polytech.iwa.covid_alert.services.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/alerts")
public class AlertController {

    @Autowired
    private AlertService alertService;


    /**
     * GET api/alert/user/{id}
     * @param user_id String
     * @return all the alerts linked to this user
     */
    @GetMapping(value = "/user/{user_id}")
    public List<Alert> getByUserId(@PathVariable String user_id){
        return alertService.getAlertByUserId(user_id);
    }

    /**
     * POST api/alerts/
     *  json data :
     *      - long alert_id
     *      - Date contamination_date
     *      - Date alert_date
     *      - String user_id
     * @param alert Alert
     * @return the alert created
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Alert create(@RequestBody final Alert alert){
        return alertService.createAlert(alert);
    }


}
