package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.SightsDto;
import edu.mkorepanov.service.SightsService;

import java.math.BigDecimal;

public class GetSightsByLongitudeAndLatitudeCommand implements Command {
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
            SightsDto sightsDto = SightsService.getSightsByLongitudeAndLatitude(longitude, latitude);
            System.out.println(sightsDto);
        } catch (Exception e) {
            System.out.println("Достопримечательности с такими координатами не существует");
        }
    }
}
