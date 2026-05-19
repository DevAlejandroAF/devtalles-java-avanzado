package com.devtalles.proyecto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String URL= "jdbc:postgresql://ep-frosty-credit-ac8dwaj5-pooler.sa-east-1.aws.neon.tech/jdbc-products?sslmode=require";
    private static final String USER="neondb_owner";
    private static final String PASSWORD="npg_7hNrioxdeX2P";

    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
