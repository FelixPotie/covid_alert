package fr.polytech.iwa.covid_alert.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="tests")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long test_id;
    private Date test_date;
    private String user_id;

    public Test() {
    }

    public Test(Date test_date, String user_id) {
        this.test_date = test_date;
        this.user_id = user_id;
    }

    public Test(long test_id, Date test_date, String user_id) {
        this.test_id = test_id;
        this.test_date = test_date;
        this.user_id = user_id;
    }

    public String toString(){
        return "Test: ["+getTest_id()+", "+getUser_id()+", "+getTest_date()+"]";
    }

    // ---------------------------- GETTER & SETTER -------------------------------

    public long getTest_id() {
        return test_id;
    }

    public void setTest_id(long test_id) {
        this.test_id = test_id;
    }

    public Date getTest_date() {
        return test_date;
    }

    public void setTest_date(Date test_date) {
        this.test_date = test_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
