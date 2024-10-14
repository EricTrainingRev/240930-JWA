package com.revature.LibraryApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Factory Design Pattern - Factory produces objects without the need to recreate the object each time, the connection to our database
 * Singleton Design Pattern - single instance of a class that is shared across the application, only the class itself can create an instance of itself
 */
public class ConnectionFactory {
    private static ConnectionFactory connectionFactory = new ConnectionFactory(); // EAGER instiation of the ConnectionFactory object

    private ConnectionFactory() { // private constructor to prevent instantiation of additional objects
        try{
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getConnectionFactory() {
//        if(connectionFactory == null) {
//            connectionFactory = new ConnectionFactory(); // LAZY instantiation of the ConnectionFactory object
//        }
        return connectionFactory;
    }

    public Connection getConnection() {
        try {
            // Make sure the URL starts with "jdbc:sqlite:" and you remove the URL\t
            return DriverManager.getConnection("jdbc:sqlite:src\\main\\resources\\library-db");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
