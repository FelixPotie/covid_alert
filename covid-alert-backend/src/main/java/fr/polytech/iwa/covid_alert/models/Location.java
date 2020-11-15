package fr.polytech.iwa.covid_alert.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

//@Entity(name = "locations")
//@Access(AccessType.FIELD)
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Location {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long location_id;
    private double latitude;
    private double longitude;
    private Date location_date;
    private String user_id;

//    public long getLocation_id() {
//        return location_id;
//    }
//
//    public void setLocation_id(long location_id) {
//        this.location_id = location_id;
//    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getLocation_date() {
        return location_date;
    }

    public void setLocation_date(Date location_date) {
        this.location_date = location_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
