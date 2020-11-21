package fr.polytech.iwa.covid_alert.services;

import fr.polytech.iwa.covid_alert.models.Contact;
import fr.polytech.iwa.covid_alert.models.User;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Map;

@Service
public interface ContactService{
    /**
     *
     * @param user_id string
     * @return a map with the user contact and the contamination date
     */
    public Map<User, Date> getContactsWithDate(String user_id);

    /**
     *
     * @param contact contact
     * @return the contact that as been created
     */
    public Contact createContact( final Contact contact);


}
