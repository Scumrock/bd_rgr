package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.ExcursionDto;
import edu.mkorepanov.service.SightsService;
import java.math.BigDecimal;

import java.util.List;

public class GetALLSightsExcursionCommand implements Command {
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
            List<ExcursionDto> excursions = SightsService.getALLSightsExcursion(longitude, latitude);
            if (excursions.isEmpty()) {
                System.out.println("До достопримечательности нет экскурсий");
                return;
            }
            System.out.printf("Найдено %d экскурсий\n", excursions.size());
            excursions.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Достопримечательности с такими координатами не существует");
        }

    }
}
