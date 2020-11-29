package fr.polytech.iwa.covid_alert.controllers;

import fr.polytech.iwa.covid_alert.models.Contact;
import fr.polytech.iwa.covid_alert.models.Test;
import fr.polytech.iwa.covid_alert.models.User;
import fr.polytech.iwa.covid_alert.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;


    /**
     * GET api/contacts/user/{id}
     * @return all the contacts of the user during the last week
     */
    @GetMapping(value = "/user/{id}")
    public Map<User, Date> getContacts(@PathVariable String id){
        return contactService.getContactsWithDate(id);
    }

    /**
     * POST api/contacts/
     *  json data :
     *      - long contact_id
     *      - String first_user_id
     *      - String second_user_id
     *      - Date contact_date
     * @param contact Contact
     * @return the Contact created
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact create(@RequestBody final Contact contact){
        return contactService.createContact(contact);
    }

}
