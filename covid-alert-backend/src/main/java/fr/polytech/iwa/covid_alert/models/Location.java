package fr.polytech.iwa.covid_alert.models;

import java.util.Date;

public class Location {
    private double latitude;
    private double longitude;
    private Date location_date;
    private String user_id;

    public Location() {
    }

    public Location(double latitude, double longitude, Date location_date, String user_id) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.location_date = location_date;
        this.user_id = user_id;
    }

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

    public String toString() {
        return "Location : ["+user_id+", "+latitude+", "+longitude+", "+location_date+"]";
    }
}
