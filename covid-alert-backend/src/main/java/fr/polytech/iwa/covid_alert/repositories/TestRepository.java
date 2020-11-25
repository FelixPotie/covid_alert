package fr.polytech.iwa.covid_alert.repositories;

import fr.polytech.iwa.covid_alert.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository  extends JpaRepository<Test, Long> {

    /**
     *
     * @param user_id String
     * @return all the test of the user
     */
    @Query("select t from tests t where t.user_id = ?1")
    List<Test> findTestsByUser_id(String user_id);

}
