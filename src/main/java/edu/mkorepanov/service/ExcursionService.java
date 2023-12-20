package edu.mkorepanov.service;

import edu.mkorepanov.dto.ExcursionDto;
import edu.mkorepanov.dto.OrdersDto;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExcursionService {

    public static void addNewExcursion(ExcursionDto excursionDto) {

        Connection connection = DatabaseService.connect();

        String query = "INSERT INTO excursion (tours_name, departure, agency_name, agency_address, " +
                "longitude, latitude) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, excursionDto.getToursName());
            preparedStatement.setDate(2, new Date(excursionDto.getDeparture().getTime()));
            preparedStatement.setString(3, excursionDto.getAgencyName());
            preparedStatement.setString(4, excursionDto.getAgencyAddress());
            preparedStatement.setFloat(5, excursionDto.getLongitude());
            preparedStatement.setFloat(6, excursionDto.getLatitude());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Не удалось добавить экскурсию в базу данных. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
    }

    public static void deleteExcursionByMetadata(int excursionCode, String tourName, java.util.Date tourDeparture,
                                                 String agencyName, String agencyAddress, BigDecimal sightsLongitude,
                                                 BigDecimal sightsLatitude){

        Connection connection = DatabaseService.connect();

        String query = "DELETE FROM excursion WHERE excursion_code = ? AND tours_name = ? AND departure = ?  " +
                "AND agency_name = ? AND agency_address = ? AND longitude = ? AND latitude = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, excursionCode);
            preparedStatement.setString(2, tourName);
            preparedStatement.setDate(3, new Date(tourDeparture.getTime()));
            preparedStatement.setString(4, agencyName);
            preparedStatement.setString(5, agencyAddress);
            preparedStatement.setBigDecimal(6, sightsLongitude);
            preparedStatement.setBigDecimal(7, sightsLatitude);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Не удалось удалить экскурсию. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }

    }

    public static List<ExcursionDto> getAllExcursions(){
        Connection connection = DatabaseService.connect();

        String query = "SELECT * FROM excursion";

        List<ExcursionDto> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ExcursionDto excursionDto = new ExcursionDto();
                excursionDto.setExcursionCode(rs.getInt("excursion_code"));
                excursionDto.setToursName(rs.getString("tours_name"));
                excursionDto.setDeparture(rs.getDate("departure"));
                excursionDto.setAgencyName(rs.getString("agency_name"));
                excursionDto.setAgencyAddress(rs.getString("agency_address"));
                excursionDto.setLongitude(rs.getFloat("longitude"));
                excursionDto.setLatitude(rs.getFloat("latitude"));
                result.add(excursionDto);
            }
        } catch (SQLException e) {
            System.out.println("Не удалось найти экскурсии." + "\nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
        return result;

    }

}
