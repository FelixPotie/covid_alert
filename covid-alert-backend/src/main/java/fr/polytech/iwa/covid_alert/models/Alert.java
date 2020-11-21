package fr.polytech.iwa.covid_alert.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="alerts")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long alert_id;
    private Date contamination_date;
    private Date alert_date;
    private String user_id;

    public Alert() {
    }

    public Alert(long alert_id, Date contamination_date, Date alert_date, String user_id) {
        this.alert_id = alert_id;
        this.contamination_date = contamination_date;
        this.alert_date = alert_date;
        this.user_id = user_id;
    }

    // ---------------------------- GETTER & SETTER -------------------------------

    public long getAlert_id() {
        return alert_id;
    }

    public void setAlert_id(long alert_id) {
        this.alert_id = alert_id;
    }

    public Date getAlert_date() {
        return alert_date;
    }

    public void setAlert_date(Date alert_date) {
        this.alert_date = alert_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getContamination_date() {
        return contamination_date;
    }

    public void setContamination_date(Date contamination_date) {
        this.contamination_date = contamination_date;
    }
}
