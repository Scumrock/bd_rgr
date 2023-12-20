package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.ClientsDto;
import edu.mkorepanov.dto.OrdersDto;
import edu.mkorepanov.service.ClientService;

import java.util.List;

public class GetALLClientOrdersCommand implements Command {
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
            List<OrdersDto> orders = ClientService.getALLClientOrders(passport);
            if (orders.isEmpty()) {
                System.out.println("У клиента никогда не было заказов");
                return;
            }
            System.out.printf("Найдено %d заказов\n", orders.size());
            orders.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Клиента с таким паспортом не существует");
        }


    }
}
