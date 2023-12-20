package edu.mkorepanov.dto;

import edu.mkorepanov.Util;

import java.util.Date;

public class OrdersDto {
    private int orderNumber;
    private int passport;
    private String toursName;
    private Date departure;
    private String agencyName;
    private String agencyAddress;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
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

    @Override
    public String toString() {
        return String.format(" Номер заказа: %d \n Паспортные данные: %d \n Название тура: %s \n " +
                "Дата отправления: %s \n Название турфирмы: %s \n Адрес турфирмы: %s", orderNumber, passport,
                toursName, Util.dateFormat(departure), agencyName, agencyAddress);
    }
}
