package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.Util;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.ExcursionDto;
import edu.mkorepanov.service.ExcursionService;

import java.util.Date;

public class AddNewExcursionCommand implements Command {
    @Override
    public void execute() {
        ExcursionDto excursionDto = new ExcursionDto();
        Date departure;
        System.out.println("Введите название тура: ");
        String toursName = Main.SCANNER.nextLine();

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

        System.out.println("Введите адрес компании: ");
        String agencyAddress = Main.SCANNER.nextLine();

        System.out.println("Введите долготу: ");
        String sightsLongitude = Main.SCANNER.nextLine();

        System.out.println("Введите широту: ");
        String sightsLatitude = Main.SCANNER.nextLine();

        float longitude;
        float latitude;
        try {
            longitude = Float.parseFloat(sightsLongitude);
            latitude = Float.parseFloat(sightsLatitude);
        } catch (Exception e) {
            System.out.println("Это не число!");
            return;
        }

        excursionDto.setToursName(toursName);
        excursionDto.setDeparture(departure);
        excursionDto.setAgencyName(agencyName);
        excursionDto.setAgencyAddress(agencyAddress);
        excursionDto.setLongitude(longitude);
        excursionDto.setLatitude(latitude);

        ExcursionService.addNewExcursion(excursionDto);
        System.out.println("Экскурсия добавлена в БД.");

    }
}
