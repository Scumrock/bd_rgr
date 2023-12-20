package edu.mkorepanov.service;

import edu.mkorepanov.dto.OrdersDto;
import edu.mkorepanov.dto.ToursDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersService {
    public static void addNewOrder(OrdersDto ordersDto) {

        Connection connection = DatabaseService.connect();

        String query = "INSERT INTO orders (passport, tours_name, departure, agency_name, agency_address) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, ordersDto.getPassport());
            preparedStatement.setString(2, ordersDto.getToursName());
            preparedStatement.setDate(3, new Date(ordersDto.getDeparture().getTime()));
            preparedStatement.setString(4, ordersDto.getAgencyName());
            preparedStatement.setString(5, ordersDto.getAgencyAddress());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Не удалось добавить заказ в базу данных. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
    }

    public static void deleteOrderByMetadata(int orderNumber, int clientPassport, String tourName,
                                               java.util.Date tourDeparture, String agencyName, String agencyAddress){

        Connection connection = DatabaseService.connect();

        String query = "DELETE FROM orders WHERE order_number = ? AND passport = ? AND tours_name = ? " +
                "AND departure = ?  AND agency_name = ? AND agency_address = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderNumber);
            preparedStatement.setInt(2, clientPassport);
            preparedStatement.setString(3, tourName);
            preparedStatement.setDate(4, new Date(tourDeparture.getTime()));
            preparedStatement.setString(5, agencyName);
            preparedStatement.setString(6, agencyAddress);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Не удалось удалить заказ. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }

    }

    public static List<OrdersDto> getAllOrders(){
        Connection connection = DatabaseService.connect();

        String query = "SELECT * FROM orders";

        List<OrdersDto> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                OrdersDto ordersDto = new OrdersDto();
                ordersDto.setOrderNumber(rs.getInt("order_number"));
                ordersDto.setPassport(rs.getInt("passport"));
                ordersDto.setToursName(rs.getString("tours_name"));
                ordersDto.setDeparture(rs.getDate("departure"));
                ordersDto.setAgencyName(rs.getString("agency_name"));
                ordersDto.setAgencyAddress(rs.getString("agency_address"));
                result.add(ordersDto);
            }
        } catch (SQLException e) {
            System.out.println("Не удалось найти заказы." + "\nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
        return result;

    }


}
