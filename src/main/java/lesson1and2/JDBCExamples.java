package lesson1and2;

import java.sql.*;

public class JDBCExamples {
    private static final String DB_URL = "jdbc:oracle:thin:@lessonsb1te.ctjiug5ulq7u.us-east-2.rds.amazonaws.com:1521:ORCL";

    private static final String USER = "B1te";
    private static final String PASS = "****";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = connection.createStatement()) {
            //1. DB Driver
            //2. create connection
            //3. create query/statement
            //4. execute query
            //5. work with result
            //6. close all the connection

//            boolean res = statement.execute("INSERT INTO PRODUCT (ID, NAME, DESCRIPTION,PRICE) VALUES (2, 'toy111', 'for children', 60)");
//            System.out.println(res);

//            boolean res = statement.execute("DELETE FROM PRODUCT WHERE NAME = 'toy111'");
//            System.out.println(res);

            int response= statement.executeUpdate("INSERT INTO PRODUCT (ID, NAME, DESCRIPTION,PRICE) VALUES (5, 'car', 'for children', 770)");
            System.out.println(response);

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }
}
