package fr.polytech.iwa.covid_alert.services;

import fr.polytech.iwa.covid_alert.models.Contact;
import fr.polytech.iwa.covid_alert.models.Test;
import fr.polytech.iwa.covid_alert.models.User;
import fr.polytech.iwa.covid_alert.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.*;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserService userService ;


    /**
     * @param user_id String
     * @return all the contacts of the user with the oldest date of contamination
     */
    public Map<User, Date> getContactsWithDate(String user_id){
        List<Contact> contacts = contactRepository.findContactsByFirst_user_idOrSecond_user_idAndContact(user_id, user_id);
        Map<User, Date> contacts_cases = new HashMap<User, Date>();
        contacts.forEach(contact ->{
            User u;
            if(!contact.getFirst_user_id().equals(user_id)) u = userService.getUser(contact.getFirst_user_id());
            else u = userService.getUser(contact.getSecond_user_id());
            if(contacts_cases.containsKey(u) && contacts_cases.get(u).after(contact.getContact_date())){
                contacts_cases.replace(u,contact.getContact_date());
            } else {
                contacts_cases.putIfAbsent(u, contact.getContact_date());
            }
        } );
        return contacts_cases;
    }

    /**
     json data :
     *      - long contact_id
     *      - String first_user_id
     *      - String first_user_id
     *      - Date contact_date
     * @param contact Contact
     * @return the Contact created
     */
    public Contact createContact( final Contact contact){
        return contactRepository.saveAndFlush(contact);
    }



}
