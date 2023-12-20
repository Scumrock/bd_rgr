package edu.mkorepanov.dto;

import java.util.Date;

public class ExcursionDto {
    private int excursionCode;
    private String toursName;
    private Date departure;
    private String agencyName;
    private String agencyAddress;
    private float longitude;
    private float latitude;

    public int getExcursionCode() {
        return excursionCode;
    }

    public void setExcursionCode(int excursionCode) {
        this.excursionCode = excursionCode;
    }

    public String getToursName() {
        return toursName;
    }

    public void setToursName(String toursName) {
        this.toursName = toursName;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyAddress() {
        return agencyAddress;
    }

    public void setAgencyAddress(String agencyAddress) {
        this.agencyAddress = agencyAddress;
    }

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

    @Override
    public String toString() {
        return String.format(" Код экскурсии: %d \n Название тура: %s \n Дата отправления: %s \n " +
                        "Название турфирмы: %s \n Адрес турфирмы: %s \n Долгота: %f \n Широта: %f", excursionCode, toursName,
                departure, agencyName, agencyAddress, longitude, latitude);
    }
}
