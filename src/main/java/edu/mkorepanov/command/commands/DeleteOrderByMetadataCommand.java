package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.Util;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.OrdersDto;
import edu.mkorepanov.service.OrdersService;
import edu.mkorepanov.service.ToursService;

import java.util.Date;

public class DeleteOrderByMetadataCommand implements Command {
    @Override
    public void execute() {
        Date departure;

        System.out.println("Введите номер заказа: ");
        String orderNumber = Main.SCANNER.nextLine();

        System.out.println("Введите номер и серию паспорта клиента (без пробелов): ");
        String clientPassport = Main.SCANNER.nextLine();

        int passport;
        int order;
        try {
            order = Integer.parseInt(orderNumber);
            passport = Integer.parseInt(clientPassport);
        } catch (Exception e) {
            System.out.println("Это не целое число!");
            return;
        }

        System.out.println("Введите название тура: ");
        String tourName = Main.SCANNER.nextLine();

        try {
            System.out.println("Введите дату отправления в формате дд.мм.гггг: ");
            String departureString = Main.SCANNER.nextLine();
            departure = Util.stringToDate(departureString);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Введите название турфирмы: ");
        String agencyName = Main.SCANNER.nextLine();

        System.out.println("Введите адрес компании: ");
        String agencyAddress = Main.SCANNER.nextLine();


        try {
            OrdersService.deleteOrderByMetadata(order, passport, tourName, departure, agencyName, agencyAddress);
        } catch (Exception e) {
            System.out.println("Заказа с такими данными не существует");
        }

        System.out.println("Заказ удален из БД");
    }
}
