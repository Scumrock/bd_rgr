package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.Util;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.ToursDto;
import edu.mkorepanov.service.ToursService;

import java.util.Date;

public class GetTourByNameDepartureAndAgencyToWhichBelongsCommand implements Command {
    @Override
    public void execute() {
        Date departure;
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

        System.out.println("Введите адрес компании: ");
        String agencyAddress = Main.SCANNER.nextLine();

        try {
            ToursDto toursDto = ToursService.getTourByNameDepartureAndAgencyToWhichBelongs(name, departure,
                    agencyName, agencyAddress);
            System.out.println(toursDto);
        } catch (Exception e) {
            System.out.println("Тура с такими данными не существует");
        }
    }
}
