package edu.mkorepanov.command.commands;

import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.SightsDto;
import edu.mkorepanov.dto.ToursDto;
import edu.mkorepanov.service.SightsService;
import edu.mkorepanov.service.ToursService;

import java.util.List;

public class GetAllToursCommand implements Command {
    @Override
    public void execute() {
        try {
            List<ToursDto> toursDto = ToursService.getAllTours();
            if (toursDto.isEmpty()) {
                System.out.println("Туров нет в БД");
                return;
            }
            System.out.printf("Найдено %d туров\n", toursDto.size());
            toursDto.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Ошибка" + e.getMessage());
        }
    }
}
