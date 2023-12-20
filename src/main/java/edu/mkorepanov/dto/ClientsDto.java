package edu.mkorepanov.dto;

public class ClientsDto {
    private String name;
    private int passport;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format(" ФИО клиента: %s \n Паспортные данные: %d \n Номер телефона: %s", name, passport, phone);
    }
}
