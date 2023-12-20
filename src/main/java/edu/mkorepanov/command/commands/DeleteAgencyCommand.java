package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.service.AgencyService;

public class DeleteAgencyCommand implements Command {

    @Override
    public void execute() {

        System.out.println("Введите название турфирмы: ");
        String name = Main.SCANNER.nextLine();

        System.out.println("Введите адрес компании: ");
        String address = Main.SCANNER.nextLine();


        AgencyService.deleteAgency(name, address);
        System.out.println("Турфирма удалена из БД.");
    }
}
