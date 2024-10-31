//package org.example.wishlist.model;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class ConnectionManager {
//    private static Connection conn = null;
//
//    private ConnectionManager() {}
//
//    public static void initialize(String dbUrl, String username, String password) {
//        if (conn == null) {
//            try {
//                conn = DriverManager.getConnection(dbUrl, username, password);
//                System.out.println("Connected to the database!");
//            } catch (SQLException e) {
//                System.out.println("Couldn't connect to db");
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static Connection getConnection() {
//        return conn;
//    }
//}
