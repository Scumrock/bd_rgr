package edu.mkorepanov.command.commands;

import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.ClientsDto;
import edu.mkorepanov.service.ClientService;

import java.util.List;

public class GetAllClientsCommand implements Command {
    @Override
    public void execute() {

        try {
            List<ClientsDto> clientsDto = ClientService.getAllClients();
            if (clientsDto.isEmpty()) {
                System.out.println("Клиентов нет в БД");
                return;
            }
            System.out.printf("Найдено %d Клиентов\n", clientsDto.size());
            clientsDto.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Ошибка" + e.getMessage());
        }
    }
}
