package org.example;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Properties;

public class CRUD_DB {
    public static void main(String arg[]){
        String url = "jdbc:mysql://localhost:3306/student";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password","Hwngnt");
        Connection conn;
        String sql = "";
        try {
            conn = DriverManager.getConnection(url, info);
            Statement stmt = conn.createStatement();

            // create db
//            sql = "DROP DATABASE IF EXISTS Student";
//            stmt.executeUpdate(sql);
//            sql = "CREATE DATABASE Student";
//            stmt.executeUpdate(sql);
//            System.out.println("Database created successfully");


            // create table
//            sql = "CREATE TABLE Student.information (" +
//                    "id serial primary key, " +
//                    "name varchar(20) not null," +
//                    "age int not null," +
//                    "check(age > 18))";
//            stmt.executeUpdate(sql);
//            System.out.println("Table created");

            // drop table
//            sql = "DROP TABLE IF EXISTS Student.information";
//            stmt.executeUpdate(sql);
//            System.out.println("Table dropped");

            // drop record
//            sql = "DELETE FROM Student.information WHERE id = 1";
//            stmt.executeUpdate(sql);
//            System.out.println("Row deleted");
//
//            // insert record
//            sql = "INSERT INTO Student.information (name, age)" +
//                    "VALUES ('Hung', 22)";
//            stmt.executeUpdate(sql);
//            System.out.println("Row inserted");
//
//            // select record
//            sql = "SELECT * FROM Student.information WHERE name = 'Hung'";
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()){
//                System.out.println("ID: " + rs.getInt("id"));
//                System.out.println(", name: " + rs.getString("name"));
//                System.out.println(", age: " + rs.getInt("age"));
//            }
//
//            // update record
//            sql = "UPDATE Student.information SET name = 'Harry Potter'" +
//                    "WHERE id = 2";
//            stmt.executeUpdate(sql);
//            System.out.println("Rows updated");
//
//            // select record
//            sql = "SELECT * FROM Student.information";
//            rs = stmt.executeQuery(sql);
//            while (rs.next()){
//                System.out.println("ID: " + rs.getInt("id"));
//                System.out.println(", name: " + rs.getString("name"));
//                System.out.println(", age: " + rs.getInt("age"));
//            }

//            sql = "UPDATE Student.information SET name = 'John Wick'" +
//                    "WHERE id = 2";
//            stmt.executeUpdate(sql);

            // select record
            sql = "SELECT i.id, i.name, il.name " +
                    "FROM information AS i " +
                    "LEFT JOIN infor_log AS il ON i.id = il.id";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println("ID: " + rs.getInt("i.id"));
                System.out.println(", name: " + rs.getString("i.name"));
                System.out.println(", name: " + rs.getString("il.name"));
            }


        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
