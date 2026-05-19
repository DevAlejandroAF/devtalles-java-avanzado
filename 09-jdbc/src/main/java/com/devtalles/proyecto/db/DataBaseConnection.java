package com.devtalles.proyecto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL="jdbc:postgresql://ep-frosty-credit-ac8dwaj5-pooler.sa-east-1.aws.neon.tech/jdbc-products?sslmode=require";
    private static final String USER="neondb_owner";
    private static final String PASSWORD="npg_7hNrioxdeX2P";

    private static DataBaseConnection instance;

    private Connection connection;

    public DataBaseConnection() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Conectado....");
    }

    public static synchronized DataBaseConnection getInstance() throws SQLException {
        if(instance==null || instance.connection.isClosed()){
            instance = new DataBaseConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
