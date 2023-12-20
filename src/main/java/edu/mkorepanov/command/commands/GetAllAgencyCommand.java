package edu.mkorepanov.command.commands;

import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.AgencyDto;
import edu.mkorepanov.service.AgencyService;

import java.util.List;

public class GetAllAgencyCommand implements Command {
    @Override
    public void execute() {

        try {
            List<AgencyDto> agencyDto = AgencyService.getAllAgency();
            if (agencyDto.isEmpty()) {
                System.out.println("Турфирм нет в БД");
                return;
            }
            System.out.printf("Найдено %d турфирм\n", agencyDto.size());
            agencyDto.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Ошибка" + e.getMessage());
        }
    }
}
