package com.devtalles.proyecto.category;

import com.devtalles.proyecto.db.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDao {
    private final Connection connection;

    public CategoryDao(Connection connection) {
        this.connection = connection;
    }

    public Category save(Category category){
        String sql = "INSERT INTO categories (name) " +
                "VALUES (?) RETURNING id";

        try (
                PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setString(1, category.getName());

            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    long id = resultSet.getLong("id");
                    category.setId(id);
                    System.out.println("La categoria fue creada correctamente...");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return category;
    }

    private void showMessage(int rows, String messageOK, String messageError){
        if(rows>0){
            System.out.println(messageOK);
        }else if(!messageError.isBlank()){
            System.out.println(messageError);
        }
    }
}
