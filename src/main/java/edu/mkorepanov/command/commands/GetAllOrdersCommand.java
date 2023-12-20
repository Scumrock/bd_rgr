package edu.mkorepanov.command.commands;

import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.OrdersDto;
import edu.mkorepanov.dto.ToursDto;
import edu.mkorepanov.service.OrdersService;
import edu.mkorepanov.service.ToursService;

import java.util.List;

public class GetAllOrdersCommand implements Command {
    @Override
    public void execute() {
        try {
            List<OrdersDto> ordersDto = OrdersService.getAllOrders();
            if (ordersDto.isEmpty()) {
                System.out.println("Заказов нет в БД");
                return;
            }
            System.out.printf("Найдено %d заказов\n", ordersDto.size());
            ordersDto.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Ошибка" + e.getMessage());
        }
    }
}
