package fr.polytech.iwa.covid_alert.controllers;

import fr.polytech.iwa.covid_alert.models.Contact;
import fr.polytech.iwa.covid_alert.models.User;
import fr.polytech.iwa.covid_alert.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    /**
     *GET api/contacts/{id}
     * @param id Long
     * @return the contact id
     */
    @GetMapping(value = "/{id}")
    public Contact get(@PathVariable Long id) {
        return contactService.getContact(id);
    }

    /**
     * GET api/contacts/
     * @return all the alerts
     */
    @GetMapping
    public List<Contact> get() {
        return contactService.getAllContacts();
    }

    @GetMapping(value = "/user/{id}")
    public List<User> getContacts(@PathVariable String id){
        return contactService.getContacts(id);
    }

}
