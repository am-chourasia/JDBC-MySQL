package com.tekion.jdbc.doa;

import com.tekion.jdbc.ConnectionProvider;
import com.tekion.jdbc.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
    public static boolean insert(Student student) {
        try {
            Connection connection = ConnectionProvider.createConnection();
            // Prepare Query
            String query = "insert into students(sname, sphone, scity) values(?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            // set Values
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getPhone());
            pstmt.setString(3, student.getCity());
            // execute
            pstmt.executeUpdate();
            ConnectionProvider.closeConnection();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean delete(int id) {
        try {
            Connection connection = ConnectionProvider.createConnection();
            // Prepare Query
            String query = "delete from students where sid = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            // set Values
            pstmt.setInt(1, id);
            // execute
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean display() {
        try {
            Connection connection = ConnectionProvider.createConnection();

            String query = "select * from students";
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String city = resultSet.getString(3);
                System.out.printf("%5d %15s %15s\n", id, name, city);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}