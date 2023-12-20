package edu.mkorepanov.command.commands;
import edu.mkorepanov.Main;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.AgencyDto;
import edu.mkorepanov.service.AgencyService;

public class AddNewAgencyCommand implements Command{

    @Override
    public void execute() {
        AgencyDto agencyDto = new AgencyDto();
        System.out.println("Введите название турфирмы: ");
        String name = Main.SCANNER.nextLine();

        System.out.println("Введите адрес компании: ");
        String address = Main.SCANNER.nextLine();

        agencyDto.setName(name);
        agencyDto.setAddress(address);

        AgencyService.addNewAgency(agencyDto);
        System.out.println("Турфирма добавлена в БД.");
    }
}
