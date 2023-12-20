package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.AgencyDto;
import edu.mkorepanov.service.AgencyService;

import java.util.List;

public class FindAllByAgencyNameCommand implements Command {

    @Override
    public void execute() {

        System.out.println("Введите название турфирмы: ");
        String name = Main.SCANNER.nextLine();

        List<AgencyDto> result = AgencyService.findAllByAgencyName(name);
        if (result.isEmpty()) {
            System.out.println("Компании с названием: " + name + " не найдены.");
            return;
        }

        System.out.printf("Найдено %d компаний\n", result.size());
        result.forEach(System.out::println);
    }
}
