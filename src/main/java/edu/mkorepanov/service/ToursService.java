package edu.mkorepanov.service;

import edu.mkorepanov.dto.SightsDto;
import edu.mkorepanov.dto.ToursDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ToursService {

    public static void addNewTour(ToursDto toursDto) {

        Connection connection = DatabaseService.connect();

        String query = "INSERT INTO tours (name, departure, arrival, city, price, agency_name, agency_address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, toursDto.getName());
            preparedStatement.setDate(2, new Date(toursDto.getDeparture().getTime()));
            preparedStatement.setDate(3, new Date(toursDto.getArrival().getTime()));
            preparedStatement.setString(4, toursDto.getCity());
            preparedStatement.setInt(5, toursDto.getPrice());
            preparedStatement.setString(6, toursDto.getAgencyName());
            preparedStatement.setString(7, toursDto.getAgencyAddress());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Не удалось добавить тур в базу данных. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
    }

    public static ToursDto getTourByNameDepartureAndAgencyToWhichBelongs(String tourName, java.util.Date tourDeparture,
                                                                         String agencyName, String agencyAddress) {

        Connection connection = DatabaseService.connect();

        String query = "SELECT name, departure, arrival, city, price, agency_name, agency_address " +
                "FROM tours WHERE name = ? AND departure = ? AND agency_name = ? AND agency_address = ?";

        ToursDto toursDto = new ToursDto();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tourName);
            preparedStatement.setDate(2, new Date(tourDeparture.getTime()));
            preparedStatement.setString(3, agencyName);
            preparedStatement.setString(4, agencyAddress);

            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                String name = result.getString("name");
                Date departure = result.getDate("departure");
                Date arrival = result.getDate("arrival");
                String city = result.getString("city");
                int price = result.getInt("price");
                String agency_name = result.getString("agency_name");
                String agency_address = result.getString("agency_address");

                toursDto.setName(name);
                toursDto.setDeparture(departure);
                toursDto.setArrival(arrival);
                toursDto.setCity(city);
                toursDto.setPrice(price);
                toursDto.setAgencyName(agency_name);
                toursDto.setAgencyAddress(agency_address);

            }
        } catch (SQLException e) {
            System.out.println("Не удалось получить тур с такими данными. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
        return toursDto;
    }

    public static void deleteTourByNameDepartureAndAgencyToWhichBelongs(String tourName, java.util.Date tourDeparture,
                                                                        String agencyName, String agencyAddress) {

        Connection connection = DatabaseService.connect();

        String query = "DELETE FROM tours WHERE name = ? AND departure = ? AND agency_name = ? AND agency_address = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tourName);
            preparedStatement.setDate(2, new Date(tourDeparture.getTime()));
            preparedStatement.setString(3, agencyName);
            preparedStatement.setString(4, agencyAddress);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Не удалось удалить тур. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
    }

    public static boolean updateTourByNameDepartureAndAgencyToWhichBelongs(ToursDto toursDto) {
        Connection connection = DatabaseService.connect();

        String query = "UPDATE tours SET arrival = ?, city = ?, price = ? WHERE name = ? AND departure = ? " +
                "AND agency_name = ? AND agency_address = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(4, toursDto.getName());
            preparedStatement.setDate(5, new Date(toursDto.getDeparture().getTime()));
            preparedStatement.setDate(1, new Date(toursDto.getArrival().getTime()));
            preparedStatement.setString(2, toursDto.getCity());
            preparedStatement.setInt(3, toursDto.getPrice());
            preparedStatement.setString(6, toursDto.getAgencyName());
            preparedStatement.setString(7, toursDto.getAgencyAddress());
            preparedStatement.execute();
        }catch (SQLException e) {
            System.out.println("Не удалось обновить тур. \nОшибка: " + e.getMessage());
            return false;
        } finally {
            DatabaseService.disconnect();
        }
        return true;
    }

    public static List<ToursDto> getAllTours(){
        Connection connection = DatabaseService.connect();

        String query = "SELECT * FROM tours";

        List<ToursDto> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ToursDto toursDto = new ToursDto();
                toursDto.setName(rs.getString("name"));
                toursDto.setDeparture(rs.getDate("departure"));
                toursDto.setArrival(rs.getDate("arrival"));
                toursDto.setCity(rs.getString("city"));
                toursDto.setPrice(rs.getInt("price"));
                toursDto.setAgencyName(rs.getString("agency_name"));
                toursDto.setAgencyAddress(rs.getString("agency_address"));
                result.add(toursDto);
            }
        } catch (SQLException e) {
            System.out.println("Не удалось найти туры." + "\nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
        return result;

    }


}
