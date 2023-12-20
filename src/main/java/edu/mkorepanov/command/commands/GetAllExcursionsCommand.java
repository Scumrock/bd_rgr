package edu.mkorepanov.command.commands;

import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.ExcursionDto;
import edu.mkorepanov.service.ExcursionService;

import java.util.List;

public class GetAllExcursionsCommand implements Command {
    @Override
    public void execute() {
        try {
            List<ExcursionDto> excursionDto = ExcursionService.getAllExcursions();
            if (excursionDto.isEmpty()) {
                System.out.println("Экскурсий нет в БД");
                return;
            }
            System.out.printf("Найдено %d экскурсий\n", excursionDto.size());
            excursionDto.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Ошибка" + e.getMessage());
        }
    }
}
