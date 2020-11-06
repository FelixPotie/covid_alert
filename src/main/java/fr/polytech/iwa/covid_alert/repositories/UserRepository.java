package fr.polytech.iwa.covid_alert.repositories;

import fr.polytech.iwa.covid_alert.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
