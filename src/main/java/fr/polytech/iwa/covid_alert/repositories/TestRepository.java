package fr.polytech.iwa.covid_alert.repositories;

import fr.polytech.iwa.covid_alert.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository  extends JpaRepository<Test, Long> {
}
