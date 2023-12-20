package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.Util;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.OrdersDto;
import edu.mkorepanov.service.OrdersService;
import edu.mkorepanov.service.ToursService;

import java.util.Date;

public class AddNewOrderCommand implements Command {
    @Override
    public void execute() {
        OrdersDto ordersDto = new OrdersDto();
        Date departure;

        System.out.println("Введите номер и серию паспорта клиента (без пробелов): ");
        String clientPassport = Main.SCANNER.nextLine();

        int passport;
        try {
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

        ordersDto.setPassport(passport);
        ordersDto.setToursName(tourName);
        ordersDto.setDeparture(departure);
        ordersDto.setAgencyName(agencyName);
        ordersDto.setAgencyAddress(agencyAddress);

        OrdersService.addNewOrder(ordersDto);
        System.out.println("Заказ добавлен в БД.");
    }

}
