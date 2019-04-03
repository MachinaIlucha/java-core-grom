package lesson33.DZ;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {


    public static void writeToFileFromConsole(String path) {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);


        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        System.out.println("Enter file content to write in the file: ");

        try {
            String toWrite = br.readLine();

            File file = new File(path);
            if (!file.exists()) {
                System.err.println("File with path " + path + " not found");
                return;
            }

            writer = new FileWriter(file);

            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.append("\n");
            bufferedWriter.append(toWrite);
        } catch (IOException e) {
            System.err.println("Can't write to file with path " + path);
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }
    }


}


