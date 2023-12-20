package edu.mkorepanov;

import edu.mkorepanov.command.CommandEnum;

import java.util.Scanner;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("""
                Выберите какую команду выполнить:
                
                Таблицы:
                1 - Получить все турфирмы из БД
                2 - Получить все туры из БД
                3 - Получить всех клиентов из БД
                4 - Получить все достопримечательности из БД
                5 - Получить все заказы из БД
                6 - Получить все экскурсии из БД
                
                Турфирмы:
                a - Добавить новую турфирму
                b - Удалить турфирму
                c - Найти все турфирмы по названию
                d - Найти все турфирмы по адресу
                                
                Туры:
                e - Добавить новый тур
                f - Получить тур по метаданным
                ff - Обновить тур по методанным
                g - Удалить тур по метаданным
                                
                Клиенты:
                h - Добавить нового клиента
                i - Получить клиента по паспорту
                j - Удалить клиента по его паспорту (Все заказы клиента будут удалены)
                k - Найти все заказы клиента
                kk - Обновить данные клиента
                                
                Достопримечательности:
                l - Добавить навую достопримечательность
                m - Получить достопримечателбность по координатам
                n - Удалить достопримечателбность по координатам
                o - Найти все экскурсии с этой достопримечательностью
                                
                Заказы:
                p - Добавить новый заказ
                r - Удалить заказ по метаданным
                                
                Экскурсии:
                s - Добавить новую экскурсию
                t - Удалить экскурсию по метаданным
                                
                q - выйти
                """);

        boolean proceed = true;

        while (proceed) {
            System.out.println();
            System.out.print("Выберите команду: ");
            String choice = SCANNER.nextLine();
            switch (choice) {
                case "1" -> CommandEnum.GET_ALL_AGENCY_COMMAND.getCommand().execute();
                case "a" -> CommandEnum.ADD_NEW_AGENCY_COMMAND.getCommand().execute();
                case "b" -> CommandEnum.DELETE_AGENCY_COMMAND.getCommand().execute();
                case "c" -> CommandEnum.FIND_ALL_BY_AGENCY_NAME_COMMAND.getCommand().execute();
                case "d" -> CommandEnum.FIND_ALL_BY_AGENCY_ADDRESS_COMMAND.getCommand().execute();
                case "2" -> CommandEnum.GET_ALL_TOURS_COMMAND.getCommand().execute();
                case "e" -> CommandEnum.ADD_NEW_TOUR_COMMAND.getCommand().execute();
                case "f" -> CommandEnum.GET_TOUR_BY_NAME_DEPARTURE_AND_AGENCY_TO_WHICH_BELONGS_COMMAND.getCommand().execute();
                case "ff" -> CommandEnum.UPDATE_TOUR_BY_NAME_DEPARTURE_AND_AGENCY_TO_WHICH_BELONGS.getCommand().execute();
                case "g" -> CommandEnum.DELETE_TOUR_BY_NAME_DEPARTURE_AND_AGENCY_TO_WHICH_BELONGS_COMMAND.getCommand().execute();
                case "3" -> CommandEnum.GET_ALL_CLIENTS_COMMAND.getCommand().execute();
                case "h" -> CommandEnum.ADD_NEW_CLIENT_COMMAND.getCommand().execute();
                case "i" -> CommandEnum.GET_CLIENT_BY_PASSPORT_COMMAND.getCommand().execute();
                case "j" -> CommandEnum.DELETE_CLIENT_BY_PASSPORT_COMMAND.getCommand().execute();
                case "k" -> CommandEnum.GET_ALL_CLIENT_ORDERS_COMMAND.getCommand().execute();
                case "kk" -> CommandEnum.UPDATE_CLIENT_BY_PASSPORT_COMMAND.getCommand().execute();
                case "4" -> CommandEnum.GET_ALL_SIGHTS_COMMAND.getCommand().execute();
                case "l" -> CommandEnum.ADD_NEW_SIGHTS_COMMAND.getCommand().execute();
                case "m" -> CommandEnum.GET_SIGHTS_BY_LONGITUDE_AND_LATITUDE_COMMAND.getCommand().execute();
                case "n" -> CommandEnum.DELETE_SIGHTS_BY_LONGITUDE_AND_LATITUDE_COMMAND.getCommand().execute();
                case "o" -> CommandEnum.GET_ALL_SIGHTS_EXCURSION_COMMAND.getCommand().execute();
                case "5" -> CommandEnum.GET_ALL_ORDERS_COMMAND.getCommand().execute();
                case "p" -> CommandEnum.ADD_NEW_ORDER_COMMAND.getCommand().execute();
                case "r" -> CommandEnum.DELETE_ORDER_BY_METADATA_COMMAND.getCommand().execute();
                case "6" -> CommandEnum.GET_ALL_EXCURSIONS_COMMAND.getCommand().execute();
                case "s" -> CommandEnum.ADD_NEW_EXCURSION_COMMAND.getCommand().execute();
                case "t" -> CommandEnum.DELETE_EXCURSION_BY_METADATA_COMMAND.getCommand().execute();

                case "q" -> proceed = false;

                default -> System.out.println("Такой команды нет!");
            }
        }
    }
}
