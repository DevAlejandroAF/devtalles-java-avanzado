package com.devtalles.proyecto.function;


import com.devtalles.proyecto.db.ConnectionDB;
import com.devtalles.proyecto.product.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public void save(Product product) throws SQLException{
        String sql = "INSERT INTO products (name, price, stock) " +
                " VALUES (?, ?, ?)";

        try (
                Connection connection = ConnectionDB.connection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getStock());

            int rows = statement.executeUpdate();
            if(rows>0){
                System.out.println("Producto insertado correctamente...");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }






    public List<Product> findAll() throws SQLException{
        String sql = "Select * From products";
        List<Product> products = new ArrayList<>();
        try (
                Connection connection = ConnectionDB.connection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ){
            while (resultSet.next()){
                Product product = mapResult(resultSet);
                products.add(product);
            }
        }
        return products;
    }

    private Product mapResult(ResultSet resultSet) throws SQLException {
        Product product = new Product(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getDouble("price"),
                resultSet.getInt("stock")
        );

        return product;
    }

    private void showMessage(int rows, String messageOK, String messageError){
        if(rows>0){
            System.out.println(messageOK);
        }else if(!messageError.isBlank()){
            System.out.println(messageError);
        }
    }














}
