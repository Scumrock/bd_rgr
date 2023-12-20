package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.Util;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.service.ExcursionService;
import edu.mkorepanov.service.ToursService;

import java.math.BigDecimal;
import java.util.Date;

public class DeleteExcursionByMetadataCommand implements Command {
    @Override
    public void execute() {
        Date departure;

        System.out.println("Введите код экскурсии: ");
        String excursionCode = Main.SCANNER.nextLine();

        int excursion;
        try {
            excursion = Integer.parseInt(excursionCode);
        } catch (Exception e) {
            System.out.println("Это не целое число!");
            return;
        }

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

        BigDecimal longitude;
        BigDecimal latitude;
        try {
            longitude = new BigDecimal(sightsLongitude);
            latitude = new BigDecimal(sightsLatitude);
        } catch (Exception e) {
            System.out.println("Это не число!");
            return;
        }

        try {
            ExcursionService.deleteExcursionByMetadata(excursion, toursName, departure, agencyName,
                    agencyAddress, longitude, latitude);
        } catch (Exception e) {
            System.out.println("Экскурсии с такими данными не существует");
        }

        System.out.println("Экскурсия удалена из БД");

    }
}
