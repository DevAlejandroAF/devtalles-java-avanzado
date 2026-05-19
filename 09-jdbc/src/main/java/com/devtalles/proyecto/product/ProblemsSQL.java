package com.devtalles.proyecto.product;

import com.devtalles.proyecto.db.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProblemsSQL {
    public static void main(String[] args) {
        //String name = "Televisor Samsung";
        String name = "Televisor Samsung'); DROP TABLE products; --";
        double price = 29.99;
        int stock = 10;

        String sql = "INSERT INTO products (name, price, stock) VALUES ('" + name + "', " + price + ", " + stock + ")";

//        INSERT INTO products (name, price, stock) VALUES ('Televisor Samsung');
//        DROP TABLE products; --', 29.99, 10)


        try (Connection conn = ConnectionDB.connection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("✅ Producto insertado (Statement)");

        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

    }
}
