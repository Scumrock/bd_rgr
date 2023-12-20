package edu.mkorepanov.service;

import edu.mkorepanov.dto.AgencyDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgencyService {

    public static void addNewAgency(AgencyDto agencyDto) {

        Connection connection = DatabaseService.connect();

        String query = "INSERT INTO agency (name, address) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, agencyDto.getName());
            preparedStatement.setString(2, agencyDto.getAddress());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Не удалось добавить турфирму в базу данных. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
    }

    public static void deleteAgency(String agencyName, String agencyAddress) {

        Connection connection = DatabaseService.connect();

        String query = "DELETE FROM agency WHERE name = ? AND address = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, agencyName);
            preparedStatement.setString(2, agencyAddress);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Не удалось удалить турфирму. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
    }

    public static List<AgencyDto> findAllByAgencyName(String agencyName) {

        Connection connection = DatabaseService.connect();

        String query = "SELECT * FROM agency WHERE name = ?";

        List<AgencyDto> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, agencyName);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                AgencyDto agencyDto = new AgencyDto();
                agencyDto.setName(rs.getString("name"));
                agencyDto.setAddress(rs.getString("address"));
                result.add(agencyDto);
            }
        } catch (SQLException e) {
            System.out.println("Не удалось найти турфирмы с таким названием:" + agencyName + "\nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
        return result;
    }

    public static List<AgencyDto> findAllByAgencyAddress(String agencyAddress) {

        Connection connection = DatabaseService.connect();

        String query = "SELECT * FROM agency WHERE address = ?";

        List<AgencyDto> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, agencyAddress);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                AgencyDto agencyDto = new AgencyDto();
                agencyDto.setName(rs.getString("name"));
                agencyDto.setAddress(rs.getString("address"));
                result.add(agencyDto);
            }
        } catch (SQLException e) {
            System.out.println("Не удалось найти турфирмы по такому адресу:" + agencyAddress + "\nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
        return result;
    }

    public static List<AgencyDto> getAllAgency(){
        Connection connection = DatabaseService.connect();

        String query = "SELECT * FROM agency";

        List<AgencyDto> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                AgencyDto agencyDto = new AgencyDto();
                agencyDto.setName(rs.getString("name"));
                agencyDto.setAddress(rs.getString("address"));
                result.add(agencyDto);
            }
        } catch (SQLException e) {
            System.out.println("Не удалось найти турфирмы." + "\nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
        return result;

    }



}
