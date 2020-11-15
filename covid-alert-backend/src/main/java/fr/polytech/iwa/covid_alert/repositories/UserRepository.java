package fr.polytech.iwa.covid_alert.repositories;

import fr.polytech.iwa.covid_alert.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * SELECT user FROM user_entity WHERE id=id
     * @param id String
     * @return the list of user with the id id
     */
    List<User> findById(String id);
}
