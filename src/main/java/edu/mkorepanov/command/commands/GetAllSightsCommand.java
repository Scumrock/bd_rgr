package edu.mkorepanov.command.commands;

import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.SightsDto;
import edu.mkorepanov.service.SightsService;

import java.util.List;

public class GetAllSightsCommand implements Command {
    @Override
    public void execute() {
        try {
            List<SightsDto> sightsDto = SightsService.getAllSights();
            if (sightsDto.isEmpty()) {
                System.out.println("Достопримечательностей нет в БД");
                return;
            }
            System.out.printf("Найдено %d достопримечательностей\n", sightsDto.size());
            sightsDto.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Ошибка" + e.getMessage());
        }
    }
}
