package edu.mkorepanov.service;

import edu.mkorepanov.dto.AgencyDto;
import edu.mkorepanov.dto.ClientsDto;
import edu.mkorepanov.dto.OrdersDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

public class ClientService {

    public static void addNewClient(ClientsDto clientsDto) {

        Connection connection = DatabaseService.connect();

        String query = "INSERT INTO clients (passport, full_name, phone) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, clientsDto.getPassport());
            preparedStatement.setString(2, clientsDto.getName());
            preparedStatement.setString(3, clientsDto.getPhone());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Не удалось добавить клиента в базу данных. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
    }


    public static ClientsDto getClientByPassport(int clientPassport) {

        Connection connection = DatabaseService.connect();

        String query = "SELECT passport, full_name, phone FROM clients WHERE passport = ?";

        ClientsDto clientsDto = new ClientsDto();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, clientPassport);

            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                int passport = result.getInt("passport");
                String fullName = result.getString("full_name");
                String phone = result.getString("phone");

                clientsDto.setPassport(passport);
                clientsDto.setName(fullName);
                clientsDto.setPhone(phone);

            }
        } catch (SQLException e) {
            System.out.println("Не удалось получить клиента с таким паспортом. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }

        return clientsDto;
    }


    public static void deleteClientByPassport(int clientPassport) {

        Connection connection = DatabaseService.connect();

        String query = "DELETE FROM clients WHERE passport = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, clientPassport);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Не удалось удалить клиента. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
    }

    public static void updateClientByPassport(int clientPassport, String name, String phone){

        Connection connection = DatabaseService.connect();

        String query = "UPDATE clients SET full_name = ?, phone = ? WHERE passport = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setInt(3, clientPassport);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Не удалось обновить клиента. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
    }

    public static List<OrdersDto> getALLClientOrders(int clientPassport) {

        Connection connection = DatabaseService.connect();

        String query = "SELECT orders.* FROM orders " +
                "JOIN clients ON orders.passport = clients.passport " +
                "WHERE clients.passport = ?";

        List<OrdersDto> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, clientPassport);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                OrdersDto ordersDto = new OrdersDto();
                ordersDto.setOrderNumber(rs.getInt("order_number"));
                ordersDto.setPassport(rs.getInt("passport"));
                ordersDto.setToursName(rs.getString("tours_name"));
                ordersDto.setDeparture(new Date(rs.getDate("departure").getTime()));
                ordersDto.setAgencyName(rs.getString("agency_name"));
                ordersDto.setAgencyAddress(rs.getString("agency_address"));

                result.add(ordersDto);
            }
        } catch (SQLException e) {
            System.out.println("Не удалось найти заказы клиента. \nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }

        return result;
    }

    public static List<ClientsDto> getAllClients(){
        Connection connection = DatabaseService.connect();

        String query = "SELECT * FROM clients";

        List<ClientsDto> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ClientsDto clientsDto = new ClientsDto();
                clientsDto.setPassport(rs.getInt("passport"));
                clientsDto.setName(rs.getString("full_name"));
                clientsDto.setPhone(rs.getString("phone"));
                result.add(clientsDto);
            }
        } catch (SQLException e) {
            System.out.println("Не удалось найти клиентов." + "\nОшибка: " + e.getMessage());
        } finally {
            DatabaseService.disconnect();
        }
        return result;

    }

}
