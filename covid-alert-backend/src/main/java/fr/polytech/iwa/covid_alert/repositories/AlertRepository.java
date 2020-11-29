package fr.polytech.iwa.covid_alert.repositories;

import fr.polytech.iwa.covid_alert.models.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {

    /**
     *
     * @param user_id String
     * @return the list of alert for the user with the id id
     */

    @Query("select a from alerts a where a.user_id = ?1")
    List<Alert> findAlertsByUser_id(String user_id);
}
