package com.devtalles.proyecto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonDB {

    private static final String URL = "jdbc:postgresql://ep-frosty-credit-ac8dwaj5-pooler.sa-east-1.aws.neon.tech/jdbc-products?sslmode=require";
    private static final String USER = "neondb_owner";
    private static final String PASSWORD = "npg_7hNrioxdeX2P";

    private static SingletonDB instance;
    private Connection connection;

    private SingletonDB() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Conexión establecida con PostgreSQL...");
    }

    public static synchronized SingletonDB getInstance() throws SQLException {
        if (instance == null || instance.connection == null || instance.connection.isClosed()) {
            instance = new SingletonDB();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

