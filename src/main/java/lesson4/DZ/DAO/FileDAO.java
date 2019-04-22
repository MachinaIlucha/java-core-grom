package lesson4.DZ.DAO;

import lesson4.DZ.model.File;
import lesson4.DZ.model.Storage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FileDAO {

    private static final String DB_URL = "jdbc:oracle:thin:@lessonsb1te.ctjiug5ulq7u.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "B1te";
    private static final String PASS = "*****";

    public static File save(Storage storage, File file) throws Exception {

        validateFile(file, storage);

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO TABLE_FILE (ID, NAME, FORMAT, SIZE, STORAGE_ID) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setLong(1, file.getId());
            preparedStatement.setString(2, file.getName());
            preparedStatement.setString(3, file.getFormat());
            preparedStatement.setLong(4, file.getSize());
            preparedStatement.setLong(5, storage.getId());

            int res = preparedStatement.executeUpdate();
            System.out.println("Save was finished with result " + res);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return file;
    }

    public static void delete(long id) {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM TABLE_FILE WHERE ID =" + id);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public static File update(File file) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE TABLE_FILE SET NAME = ? , FORMAT = ?, SIZE = ? , STORAGE_ID = ? WHERE ID = " + file.getId())) {

            preparedStatement.setString(1, file.getName());
            preparedStatement.setString(2, file.getFormat());
            preparedStatement.setLong(3, file.getSize());
            preparedStatement.setLong(4, file.getStorage().getId());

            int res = preparedStatement.executeUpdate();
            System.out.println("Save was finished with result " + res);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return file;
    }

    public static File findById(long id) {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM TABLE_FILE WHERE ID =" + id)) {
                File file = new File(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getLong(4), StorageDAO.findById(resultSet.getLong(5)));
                return file;
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        List<File> files; files = getFiles(storageFrom.getId());
        for (File file : files) {
            validateFile(file, storageTo);
            file.setStorage(storageTo);
            update(file);
        }
    }

    public static File transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {

        File file = findById(id);
        validateFile(file, storageTo);

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE TABLE_FILE SET STORAGE_ID = ? " +
                     "WHERE STORAGE_ID = " + storageFrom.getId() + " AND ID = " + id)) {

            preparedStatement.setLong(1, storageTo.getId());

            int res = preparedStatement.executeUpdate();
            System.out.println("Save was finished with result " + res);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return file;
    }


    /******************************************************************************************************************/


    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    private static void validateFile(File file, Storage storage) throws Exception {
        for (String format : storage.getFormatsSupported()) {
            if (format != file.getFormat())
                throw new Exception("Can't put file - " + file.getId() + " in storage - " + storage.getId() + " 'couse storage don't supports format of file");
        }

        long size = 0;

        /*******************************************************************************************************/
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM TABLE_FILE")) {
                if (resultSet.next()) {
                    size = size + resultSet.getLong(4);
                }
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        /*******************************************************************************************************/

        if (size < size + file.getSize()) {
            throw new Exception("Can't put file - " + file.getId() + " in storage - " + storage.getId() + " 'couse storage is full");
        }
    }

    private static List<File> getFiles(long storage_id) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM TABLE_FILE WHERE STORAGE_ID =" + storage_id);

            List<File> files = new ArrayList<>();
            while (resultSet.next()) {
                File file = new File(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4),
                        StorageDAO.findById(resultSet.getLong(5)));
                files.add(file);
            }
            return files;
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }
}
