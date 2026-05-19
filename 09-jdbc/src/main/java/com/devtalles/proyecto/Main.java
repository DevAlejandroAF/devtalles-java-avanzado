package com.devtalles.proyecto;

import com.devtalles.proyecto.category.Category;
import com.devtalles.proyecto.db.ConnectionDB;
import com.devtalles.proyecto.db.DataBaseConnection;
import com.devtalles.proyecto.db.SingletonDB;
import com.devtalles.proyecto.product.Product;
import com.devtalles.proyecto.product.ProductService;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {

        ProductService service = new ProductService();

//        Product product = new Product("Java Avanzado", 1200, 20);
//        Category category = new Category("Books".trim().toUpperCase());

        try{
//            service.saveProductWithCategory(product, category);
            List<Product> products = service.findProducts();
            products.forEach(System.out::println);

            System.out.println("_________________________");

            service.deleteProduct(73L);
            products = service.findProducts();
            products.forEach(System.out::println);

            Category category = new Category(35L, "Books".trim().toUpperCase());
            Product product = new Product(74L, "Java Avanzado", 1200, 20, category);

            service.updateProduct(product);

        }catch (SQLException e){
            System.out.println("Error " +  e.getMessage());
        }







//        ProductDAO dao = new ProductDAO();
//
//        Product product = new Product("Monitor LG 2025", 1210.00, 19);
//
//        dao.save(product);
//
//        List<Product> productList = dao.findAll();
//
//        productList.forEach(System.out::println);
//        Connection c1 = DataBaseConnection.getInstance().getConnection();
//        Connection c2 = DataBaseConnection.getInstance().getConnection();
//        Connection c3 = DataBaseConnection.getInstance().getConnection();




//        Connection c1 = ConnectionDB.connection();
//        Connection c2 = ConnectionDB.connection();
//        Connection c3 = ConnectionDB.connection();


//        System.out.println("C1: " + c1);
//        System.out.println("C2: " + c2);
//        System.out.println("C3: " + c3);













    }
}