package com.devtalles.proyecto.product;

import com.devtalles.proyecto.category.Category;
import com.devtalles.proyecto.category.CategoryDao;
import com.devtalles.proyecto.db.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductService {

    public void saveProductWithCategory(Product product, Category category) throws SQLException {
        Connection connection = null;

        try{
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);//inicio de la transacción

            CategoryDao categoryDao = new CategoryDao(connection);
            ProductDAO productDAO = new ProductDAO(connection);

            Category newCategory = categoryDao.save(category);
            product.setCategory(newCategory);
            productDAO.save(product);

            connection.commit();

        } catch (SQLException e) {
            if(connection != null){
                connection.rollback();
            }
            System.out.println(e.getMessage());
            throw e;
        }finally {
            if(connection!=null){
                try{
                    connection.setAutoCommit(true);
                    connection.close();
                }catch (SQLException e){
                    System.out.println("Error al cerrar la conexión...");
                }
            }
        }
    }
    public void updateProduct(Product product) throws SQLException {
        Connection connection = null;

        try{
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);//inicio de la transacción

            ProductDAO productDAO = new ProductDAO(connection);

            productDAO.update(product);

            connection.commit();

        } catch (SQLException e) {
            if(connection != null){
                connection.rollback();
            }
            System.out.println(e.getMessage());
            throw e;
        }finally {
            if(connection!=null){
                try {
                    connection.setAutoCommit(true); // Restablecer auto-commit
                    connection.close(); // Devolver la conexión al pool
                } catch (SQLException e) { // <<< ESTE CATCH
                    System.err.println("Error al cerrar la conexión o resetear auto-commit: " + e.getMessage());
                }
            }
        }
    }

    public void deleteProduct(Long id) throws SQLException {
        Connection connection = null;

        try{
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);//inicio de la transacción

            ProductDAO productDAO = new ProductDAO(connection);

            productDAO.delete(id);

            connection.commit();

        } catch (SQLException e) {
            if(connection != null){
                connection.rollback();
            }
            System.out.println(e.getMessage());
            throw e;
        }finally {
            if(connection!=null){
                try {
                    connection.setAutoCommit(true); // Restablecer auto-commit
                    connection.close(); // Devolver la conexión al pool
                } catch (SQLException e) { // <<< ESTE CATCH
                    System.err.println("Error al cerrar la conexión o resetear auto-commit: " + e.getMessage());
                }
            }
        }
    }

    public List<Product> findProducts() throws SQLException {
        try (Connection connection = ConnectionPool.getConnection()) {

            ProductDAO productDAO = new ProductDAO(connection);

            return productDAO.findAll();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
