package edu.mkorepanov.service;

import edu.mkorepanov.dto.ClientsDto;
import edu.mkorepanov.dto.ExcursionDto;
import edu.mkorepanov.dto.OrdersDto;
import edu.mkorepanov.dto.SightsDto;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SightsService {

    public static void addNewSights(SightsDto sightsDto){

        Connection connection = DatabaseService.connect();

        String query = "INSERT INTO sights (longitude, latitude, name) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setFloat(1, sightsDto.getLongitude());
            preparedStatement.setFloat(2, sightsDto.getLatitude());
            preparedStatement.setString(3, sightsDto.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Не удалось добавить достопримечательность в базу данных. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
    }

    public static SightsDto getSightsByLongitudeAndLatitude(BigDecimal sightsLongitude, BigDecimal sightsLatitude) {

        Connection connection = DatabaseService.connect();

        String query = "SELECT name FROM sights WHERE longitude = ? AND latitude = ?";

        SightsDto sightsDto = new SightsDto();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBigDecimal(1, sightsLongitude);
            preparedStatement.setBigDecimal(2, sightsLatitude);

            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
//                float longitude = result.getFloat("longitude");
//                float latitude = result.getFloat("latitude");
                String name = result.getString("name");

                sightsDto.setLongitude(sightsLongitude.floatValue());
                sightsDto.setLatitude(sightsLatitude.floatValue());
                sightsDto.setName(name);

            }
        } catch (SQLException e) {
            System.out.println("Не удалось получить достопримечательность с такими координатами. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }

        return sightsDto;
    }

    public static void deleteSightsByLongitudeAndLatitude(BigDecimal sightsLongitude, BigDecimal sightsLatitude) {

        Connection connection = DatabaseService.connect();

        String query = "DELETE FROM sights WHERE longitude = ? AND latitude = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBigDecimal(1, sightsLongitude);
            preparedStatement.setBigDecimal(2, sightsLatitude);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Не удалось удалить достопримечательность. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
    }

    public static List<ExcursionDto> getALLSightsExcursion(BigDecimal sightsLongitude, BigDecimal sightsLatitude) {

        Connection connection = DatabaseService.connect();

        String query = "SELECT excursion.* FROM excursion " +
                "JOIN sights ON excursion.longitude = sights.longitude AND excursion.latitude = sights.latitude " +
                "WHERE sights.longitude = ? AND sights.latitude = ?";

        List<ExcursionDto> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBigDecimal(1, sightsLongitude);
            preparedStatement.setBigDecimal(2, sightsLatitude);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ExcursionDto excursionDto = new ExcursionDto();
                excursionDto.setExcursionCode(rs.getInt("excursion_code"));
                excursionDto.setToursName(rs.getString("tours_name"));
                excursionDto.setDeparture(new Date(rs.getDate("departure").getTime()));
                excursionDto.setAgencyName(rs.getString("agency_name"));
                excursionDto.setAgencyAddress(rs.getString("agency_address"));
                excursionDto.setLongitude(rs.getFloat("longitude"));
                excursionDto.setLatitude(rs.getFloat("latitude"));

                result.add(excursionDto);
            }
        }catch (SQLException e) {
            System.out.println("Не удалось найти экскурсии с этой достопримечательностью. \nОшибка: " + e.getMessage());
        }finally {
            DatabaseService.disconnect();
        }

        return result;
    }

    public static List<SightsDto> getAllSights(){
        Connection connection = DatabaseService.connect();

        String query = "SELECT * FROM sights";

        List<SightsDto> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                SightsDto sightsDto = new SightsDto();
                sightsDto.setLongitude(rs.getFloat("longitude"));
                sightsDto.setLatitude(rs.getFloat("latitude"));
                sightsDto.setName(rs.getString("name"));
                result.add(sightsDto);
            }
        } catch (SQLException e) {
            System.out.println("Не удалось найти достопримечательности." + "\nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
        return result;

    }
}
