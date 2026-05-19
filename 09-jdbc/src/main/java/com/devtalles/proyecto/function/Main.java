package com.devtalles.proyecto.function;

import com.devtalles.proyecto.db.ConnectionPool;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try(Connection connection = ConnectionPool.getConnection()){

            String sql = "SELECT * FROM find_by_id_students(?)";
            try (CallableStatement statement = connection.prepareCall(sql)){
                statement.setInt(1, 10);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    Date birthDate = resultSet.getDate("birth_date");

                    System.out.println("ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Email: " + email);
                    System.out.println("Nacimiento: " + birthDate);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
