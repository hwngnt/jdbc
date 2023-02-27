package org.example;

import java.sql.*;
import java.util.Properties;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        CallableStatement cstmt = null;
        String url = "jdbc:mysql://localhost:3306/sakila";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password","Hwngnt");
        String QUERY = "SELECT * FROM country INNER JOIN city WHERE country.country_id = city.country_id AND country.country_id = 105 ";
        String UPDATE_QUERY = "UPDATE customer set last_name = 'NTH'  WHERE customer_id=619";
        String INSERT_QUERY = "INSERT INTO customer (store_id, first_name, last_name, email, address_id)" +
                "VALUES (1, 'Andrew', 'Potter', 'ap@gmail.com', 1)";
        String DELETE_QUERY = "DELETE FROM customer where customer_id = 620";
        try {
            conn = DriverManager.getConnection(url, info);
//            System.out.println(conn);
            stmt = conn.createStatement();
            String sql = "{CALL getCustomerName(?, ?)}";

//            int rows = stmt.executeUpdate(UPDATE_QUERY);
//            System.out.println("Rows impacted : " + rows );
//            int rows = stmt.executeUpdate(INSERT_QUERY);
//            System.out.println(rows);
//            ResultSet rs = stmt.executeQuery(QUERY);
//            while (rs.next()) {
//                // Retrieve by column name
//                System.out.println("ID: " + rs.getInt("country.country_id"));
////                System.out.print(", title: " + rs.getInt("film.title"));
//                System.out.println(", city: " + rs.getString("city.city"));
////                System.out.println(", Last_update: " + rs.getString("film_actor.last_update"));
//            }
//            rs.close();

            try {
                conn.setAutoCommit(false);
                String sql1 = "UPDATE customer SET store_id = 1 WHERE customer_id = 499";
                int rows = stmt.executeUpdate(sql1);
                System.out.println("rows affected " + rows);
                String sql2 = "INSERT INTO customer (store_id, first_name, last_name, email, address_id)" +
                        "VALUES ('jdaosijdias', 'Lionel', 'Messi', 'messi@gmail.com', 1)";
                rows = stmt.executeUpdate(sql2);
                System.out.println("rows affected " + rows);
                conn.commit();
            } catch (SQLException e){
                e.printStackTrace();
                conn.rollback();
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}