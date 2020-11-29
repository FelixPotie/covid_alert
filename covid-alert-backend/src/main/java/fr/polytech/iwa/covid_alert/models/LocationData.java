package fr.polytech.iwa.covid_alert.models;

public class LocationData {
    private double latitude;
    private double longitude;
    private long timestamp;

    public LocationData() {
    }

    public LocationData(double latitude, double longitude, int timestamp) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public long getTimestamp(){ return timestamp;}

}
