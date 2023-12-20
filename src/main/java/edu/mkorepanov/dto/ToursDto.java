package edu.mkorepanov.dto;

import edu.mkorepanov.Util;

import java.util.Date;

public class ToursDto {
    private String name;
    private Date departure;
    private Date arrival;
    private String city;
    private int price;
    private String agencyName;
    private String agencyAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    @Override
    public String toString() {
        return String.format(" Название тура: %s \n Дата отправления: %s \n Дата прибытия: %s \n Город: %s \n " +
                "Цена тура: %d \n Название турфирмы: %s \n Адрес турфирмы: %s \n ", name, Util.dateFormat(departure), Util.dateFormat(arrival), city,
                price, agencyName, agencyAddress);
    }
}
