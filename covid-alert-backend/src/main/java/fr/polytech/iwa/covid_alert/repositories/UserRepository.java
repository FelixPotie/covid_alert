package fr.polytech.iwa.covid_alert.repositories;

import fr.polytech.iwa.covid_alert.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * SELECT user FROM user_entity WHERE id=id
     * @param id String
     * @return the list of user with the id id
     */
    List<User> findById(String id);
}
