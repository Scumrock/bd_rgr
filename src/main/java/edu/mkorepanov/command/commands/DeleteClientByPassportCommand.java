package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.service.ClientService;

public class DeleteClientByPassportCommand implements Command {
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
            ClientService.deleteClientByPassport(passport);
        } catch (Exception e) {
            System.out.println("Клиента с таким паспортом не существует");
        }

        System.out.println("Клиент удален из БД");
    }
}
