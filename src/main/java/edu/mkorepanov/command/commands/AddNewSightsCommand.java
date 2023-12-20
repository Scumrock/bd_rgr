package edu.mkorepanov.command.commands;

import edu.mkorepanov.Main;
import edu.mkorepanov.command.Command;
import edu.mkorepanov.dto.SightsDto;
import edu.mkorepanov.service.SightsService;

public class AddNewSightsCommand implements Command {
    @Override
    public void execute() {
        SightsDto sightsDto = new SightsDto();
        System.out.println("Введите долготу: ");
        String sightsLongitude = Main.SCANNER.nextLine();

        System.out.println("Введите широту: ");
        String sightsLatitude = Main.SCANNER.nextLine();

        float longitude;
        float latitude;
        try {
            longitude = Float.parseFloat(sightsLongitude);
            latitude = Float.parseFloat(sightsLatitude);
        } catch (Exception e) {
            System.out.println("Это не число!");
            return;
        }

        System.out.println("Введите название достопримечательности: ");
        String name = Main.SCANNER.nextLine();

        sightsDto.setLongitude(longitude);
        sightsDto.setLatitude(latitude);
        sightsDto.setName(name);

        SightsService.addNewSights(sightsDto);
        System.out.println("Достопримечательность добавлена в БД.");
    }
}
