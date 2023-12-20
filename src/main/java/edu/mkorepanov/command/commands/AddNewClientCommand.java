package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.ClientsDto;
import edu.mkorepanov.service.ClientService;

public class AddNewClientCommand implements Command {
    @Override
    public void execute() {
        ClientsDto clientsDto = new ClientsDto();
        System.out.println("Введите ФИО клиента: ");
        String fullName = Main.SCANNER.nextLine();

        System.out.println("Введите номер и серию паспорта клиента (без пробелов): ");
        String clientPassport = Main.SCANNER.nextLine();

        int passport;
        try {
            passport = Integer.parseInt(clientPassport);
        } catch (Exception e) {
            System.out.println("Это не целое число!");
            return;
        }

        System.out.println("Введите номере телефона клиента: ");
        String phone = Main.SCANNER.nextLine();


        clientsDto.setName(fullName);
        clientsDto.setPassport(passport);
        clientsDto.setPhone(phone);


        ClientService.addNewClient(clientsDto);
        System.out.println("Клиент добавлен в БД.");
    }
}
