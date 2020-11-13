package fr.polytech.iwa.covid_alert.services;

import fr.polytech.iwa.covid_alert.models.Contact;
import fr.polytech.iwa.covid_alert.models.User;
import fr.polytech.iwa.covid_alert.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserService userService ;

    /**
     * @param id Long
     * @return
     */
    public Contact getContact(Long id){
        if(contactRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alert with ID "+id+" not found");
        }
        return contactRepository.getOne(id);
    }

    /**
     * @return
     */
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public List<User> getContacts(@PathVariable String user_id){
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        List<Contact> contacts = contactRepository.findContactsByFirst_user_idOrSecond_user_idAndContact_dateAfter(user_id, user_id, date);
        List<User> contacts_cases = new ArrayList<User>();
        contacts.forEach(contact -> {
            if(!contact.getFirst_user_id().equals(user_id)) contacts_cases.add(userService.getUser(contact.getFirst_user_id()));
            if(!contact.getSecond_user_id().equals(user_id)) contacts_cases.add(userService.getUser(contact.getSecond_user_id()));
        });
        return contacts_cases;
    }




}
