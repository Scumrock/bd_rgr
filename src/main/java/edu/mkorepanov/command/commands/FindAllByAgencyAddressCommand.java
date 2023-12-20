package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.AgencyDto;
import edu.mkorepanov.service.AgencyService;

import java.util.List;

public class FindAllByAgencyAddressCommand implements Command {

    @Override
    public void execute() {

        System.out.println("Введите адрес компании: ");
        String address = Main.SCANNER.nextLine();

        List<AgencyDto> result = AgencyService.findAllByAgencyAddress(address);
        if (result.isEmpty()) {
            System.out.println("Компании по адресу: " + address + " не найдены.");
            return;
        }

        System.out.printf("Найдено %d компаний\n", result.size());
        result.forEach(System.out::println);
    }
}
