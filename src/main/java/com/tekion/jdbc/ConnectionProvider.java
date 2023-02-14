package com.tekion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    static Connection connection;
    public static Connection createConnection() throws SQLException, ClassNotFoundException {
        // load the driver:
        Class.forName("com.mysql.cj.jdbc.Driver");
        // creating the connection:
        String user = "root";
        String password = "MySql@2023";
        String url = "jdbc:mysql://localhost:3306/student_management";
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error closing connection.");
            e.printStackTrace();
        }
    }
}
