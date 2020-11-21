package fr.polytech.iwa.covid_alert.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="contacts")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contact_id;
    private String first_user_id;
    private String second_user_id;
    private Date contact_date;

    public Contact() {
    }

    public Contact(long contact_id, String first_user_id, String second_user_id, Date contact_date) {
        this.contact_id = contact_id;
        this.first_user_id = first_user_id;
        this.second_user_id = second_user_id;
        this.contact_date = contact_date;
    }

    // ---------------------------- GETTER & SETTER -------------------------------


    public long getContact_id() {
        return contact_id;
    }

    public void setContact_id(long contact_id) {
        this.contact_id = contact_id;
    }

    public String getFirst_user_id() {
        return first_user_id;
    }

    public void setFirst_user_id(String first_user_id) {
        this.first_user_id = first_user_id;
    }

    public String getSecond_user_id() {
        return second_user_id;
    }

    public void setSecond_user_id(String second_user_id) {
        this.second_user_id = second_user_id;
    }

    public Date getContact_date() {
        return contact_date;
    }

    public void setContact_date(Date contact_date) {
        this.contact_date = contact_date;
    }
}
