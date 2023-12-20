package edu.mkorepanov.dto;

public class SightsDto {
    private float longitude;
    private float latitude;
    private String name;

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(" Долгота: %f \n Широта: %f \n Достопримечательность: %s", longitude, latitude, name);
    }
}
