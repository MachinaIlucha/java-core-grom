package lesson36.repository;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class GeneralDAO {

    public static <E> void saveToDb(E e, String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            String str = readFromFile(path).toString();
            if (!"".equals(str))
                bufferedWriter.newLine();
            String dataToAdd = e.toString();
            bufferedWriter.append(dataToAdd);
        } catch (IOException err) {
            System.err.println("Can't add Object to Db");
        }
    }

    public static <E extends mapObject, T> Set<T> mapping(String path, E e) throws Exception {
        //считывание данный - считывание файла
        //обработка данных - маппинг данных
        Set<T> objects = new HashSet<>();
        validate(path);

        StringBuffer contentToWrite = readFromFile(path);

        String text = contentToWrite.toString();
        String[] result = text.split("\n");

        for (int i = 0; i < result.length; i++) {
            String[] forObject = result[i].split(",");
            objects.add((T) e.mapObject(forObject));
        }
        return objects;
    }


    /*****************************************************************************************************************/


    public static StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            if ((line = br.readLine()) != null)
                res.replace(res.length() - 1, res.length(), " ");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }

        return res;
    }

    private static void validate(String fileDbPath) throws Exception {
        File fileDb = new File(fileDbPath);

        if (!fileDb.exists()) {
            throw new FileNotFoundException("Db " + fileDbPath + " does not exist");
        }

        if (!fileDb.canRead()) {
            throw new Exception("Db " + fileDbPath + " does not have permission to read");
        }
    }
}
