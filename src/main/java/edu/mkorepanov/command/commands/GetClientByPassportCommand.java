package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.ClientsDto;
import edu.mkorepanov.service.ClientService;

public class GetClientByPassportCommand implements Command {
    @Override
    public void execute() {

        System.out.println("Введите номер и серию паспорта клиента (без пробелов): ");
        String clientPassport = Main.SCANNER.nextLine();

        int passport;
        try {
            passport = Integer.parseInt(clientPassport);
        } catch (Exception e) {
            System.out.println("Это не целое число!");
            return;
        }


        try {
            ClientsDto clientsDto = ClientService.getClientByPassport(passport);
            System.out.println(clientsDto);
        } catch (Exception e) {
            System.out.println("Клиента с таким паспортом не существует");
        }

    }
}
