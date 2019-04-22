package lesson4;

import lesson3.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TransactionDemo {

    private static final String DB_URL = "jdbc:oracle:thin:@lessonsb1te.ctjiug5ulq7u.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "B1te";
    private static final String PASS = "*****";

    private void save(List<Product> products) {
        try (Connection connection = getConnection()) {
            saveList(products, connection);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    private void saveList(List<Product> products, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUCT (ID, NAME, DESCRIPTION,PRICE) VALUES (?, ?, ?, ?)")) {

            connection.setAutoCommit(false);

            for (Product product : products) {
                preparedStatement.setLong(1, product.getId());
                preparedStatement.setString(2, product.getName());
                preparedStatement.setString(3, product.getDescription());
                preparedStatement.setLong(4, product.getPrice());

                int res = preparedStatement.executeUpdate();
                System.out.println("Save was finished with result " + res);
            }

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
