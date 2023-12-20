package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.service.SightsService;

import java.math.BigDecimal;

public class DeleteSightsByLongitudeAndLatitudeCommand implements Command {
    @Override
    public void execute() {
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
            SightsService.deleteSightsByLongitudeAndLatitude(longitude, latitude);
        } catch (Exception e) {
            System.out.println("Достопримечательности с такими координатами не существует");
        }

        System.out.println("Достопримечательность удалена из БД");
    }
}
