package lesson3.DZ;

import lesson3.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static final String DB_URL = "jdbc:oracle:thin:@lessonsb1te.ctjiug5ulq7u.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "B1te";
    private static final String PASS = "*****";

    public static void main(String[] args) throws Exception {
        System.out.println(findProductByPrice(390,10).toString());
    }

    private static List<Product> findProductByPrice(int price, int delta) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE PRICE BETWEEN ? AND ?")) {

            int min = price - delta;
            int max = price + delta;

            preparedStatement.setInt(1, min);
            preparedStatement.setInt(2, max);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    private static List<Product> findProductByName(String word) throws Exception {
        validateWord(word);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE NAME = ?")) {

            preparedStatement.setString(1, word);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    private static List<Product> findProductsWithEmptyDescription() {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE DESCRIPTION = ?")) {

            preparedStatement.setString(1, null);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    private static void validateWord(String word) throws Exception {
        String regex = "a-z~@#$%^&*:;<>.,/}{+";
        if (word.contains(" ") || word.length() < 3 || word.matches("[" + regex + "]"))
            throw new Exception("Word - " + word + "isn't correct");
    }
}
