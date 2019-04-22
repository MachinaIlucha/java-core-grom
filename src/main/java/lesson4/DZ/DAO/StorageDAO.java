package lesson4.DZ.DAO;

import lesson4.DZ.model.File;
import lesson4.DZ.model.Storage;

import java.sql.*;

public class StorageDAO {

    private static final String DB_URL = "jdbc:oracle:thin:@lessonsb1te.ctjiug5ulq7u.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "B1te";
    private static final String PASS = "*****";

    public Storage save(Storage storage) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO STORAGE (ID, " +
                     "FORMATSSUPPORTED, STORAGECOUNTRY, STORAGEMAXSIZE) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setLong(1, storage.getId());
            preparedStatement.setString(2, getLineOfFormats(storage.getFormatsSupported()));
            preparedStatement.setString(3, storage.getStorageCountry());
            preparedStatement.setLong(4, storage.getStorageMaxSize());

            int res = preparedStatement.executeUpdate();
            System.out.println("Save was finished with result " + res);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return storage;
    }

    public void delete(long id) {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM STORAGE WHERE ID =" + id);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public Storage update(Storage storage) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE STORAGE SET FORMATSSUPPORTED = ? , STORAGECOUNTRY = ?, STORAGEMAXSIZE = ? WHERE ID = " + storage.getId())) {

            preparedStatement.setString(1, getLineOfFormats(storage.getFormatsSupported()));
            preparedStatement.setString(2, storage.getStorageCountry());
            preparedStatement.setLong(3, storage.getStorageMaxSize());

            int res = preparedStatement.executeUpdate();
            System.out.println("Save was finished with result " + res);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return storage;
    }

    public static Storage findById(long id) {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM STORAGE WHERE ID =" + id)) {
                Storage storage = new Storage(resultSet.getLong(1), resultSet.getString(2).split(" "), resultSet.getString(3), resultSet.getLong(4));
                return storage;
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    /******************************************************************************************************************/

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    private static String getLineOfFormats(String[] formatsSupported) {
        String lineOfForm = "";
        for (String line : formatsSupported) {
            lineOfForm += line + " ";
        }
        return lineOfForm;
    }
}
