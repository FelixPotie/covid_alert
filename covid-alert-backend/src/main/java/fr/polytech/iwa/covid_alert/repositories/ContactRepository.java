package fr.polytech.iwa.covid_alert.repositories;

import fr.polytech.iwa.covid_alert.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("select c from contacts c where c.first_user_id = ?1 or c.second_user_id = ?1")
    List<Contact> findContactsByFirst_user_idOrSecond_user_idAndContact(String first_user_id);

}
