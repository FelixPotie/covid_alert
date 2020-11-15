package fr.polytech.iwa.covid_alert.repositories;

import fr.polytech.iwa.covid_alert.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findContactsByFirst_user_idOrSecond_user_idAndContact(String first_user_id, String second_user_id);

}
