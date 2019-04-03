package lesson34.DZ2;

import java.io.*;

public class Solution {

    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {

        validate(fileFromPath, fileToPath);

        StringBuffer contentToWrite = readFromFile(fileFromPath, word);

        String text = contentToWrite.toString();
        StringBuilder res = new StringBuilder();
        String[] result = text.split("\n");
        for (int i = 0; i < result.length; i++) {
            if (result[i].contains(word) && result[i].startsWith(".") && result[i].endsWith(".") && result[i].length() >= 10) {
                System.out.println(result[i]);
                res.append(result[i]);
                res.append("\n");
            }
        }
        res.replace(res.length() - 1, res.length(), " ");

        writeToFile(fileToPath, res);
    }

    private static StringBuffer readFromFile(String path, String word) {
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), " ");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }

        return res;
    }

    private static void writeToFile(String path, StringBuilder contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permission to read");
        }

        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileFrom + " does not have permission to written");
        }
    }
}
