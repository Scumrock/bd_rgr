package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.Util;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.ToursDto;
import edu.mkorepanov.service.ToursService;

import java.util.Date;

public class UpdateTourByNameDepartureAndAgencyToWhichBelongsCommand implements Command {
    @Override
    public void execute() {
        ToursDto toursDto = new ToursDto();
        Date departure;
        Date arrival;
        System.out.println("Введите название тура: ");
        String name = Main.SCANNER.nextLine();

        try {
            System.out.println("Введите дату отправления в формате дд.мм.гггг: ");
            String departureString = Main.SCANNER.nextLine();
            departure = Util.stringToDate(departureString);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Введите название турфирмы: ");
        String agencyName = Main.SCANNER.nextLine();

        System.out.println("Введите адрес турфирмы: ");
        String agencyAddress = Main.SCANNER.nextLine();


        try {
            System.out.println("Введите дату прибытия в формате дд.мм.гггг: ");
            String arrivalString = Main.SCANNER.nextLine();
            arrival = Util.stringToDate(arrivalString);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }


        System.out.println("Введите город тура: ");
        String city = Main.SCANNER.nextLine();

        System.out.println("Введите цену тура: ");
        String tourPrice = Main.SCANNER.nextLine();

        int price;
        try {
            price = Integer.parseInt(tourPrice);
        } catch (Exception e) {
            System.out.println("Это не целое число!");
            return;
        }

        toursDto.setName(name);
        toursDto.setDeparture(departure);
        toursDto.setArrival(arrival);
        toursDto.setCity(city);
        toursDto.setPrice(price);
        toursDto.setAgencyName(agencyName);
        toursDto.setAgencyAddress(agencyAddress);

        if (ToursService.updateTourByNameDepartureAndAgencyToWhichBelongs(toursDto)){
            System.out.println("Тур обнавлен");
        }

    }
}
