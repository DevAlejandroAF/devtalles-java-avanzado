package com.devtalles.proyecto.product;


import com.devtalles.proyecto.db.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAODos {

    private Connection getConnection() throws SQLException {
        return ConnectionPool.getConnection();
    }

    public void save(Product product) throws SQLException{
        String sql = "INSERT INTO products (name, price, stock, category_id) " +
                " VALUES (?, ?, ?, ?)";

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getStock());
            statement.setLong(4, product.getCategory().getId());

            int rows = statement.executeUpdate();
            showMessage(rows, "El producto fue ingresado correctamente", "");

        }
    }
    public void update(Product product) throws SQLException {
        String sql = "UPDATE products SET name = ?, price = ?, stock = ?, category_id = ? " +
                " WHERE id=?";

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getStock());
            statement.setLong(4, product.getCategory().getId());
            statement.setLong(5, product.getId());

            int rows = statement.executeUpdate();
            showMessage(rows, "El producto fue actualizado", "El producto no existe...");

        }
    }

    public void delete(long id) throws SQLException{
        String sql = "DELETE FROM products WHERE id = ? ";

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ){

            statement.setLong(1, id);

            int rows = statement.executeUpdate();
            showMessage(rows, "El producto fue eliminado", "El producto no existe...");

        }
    }


    public List<Product> findAll() throws SQLException{
        String sql = "Select * From products";
        List<Product> products = new ArrayList<>();
        try (
                Connection connection = getConnection();
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
