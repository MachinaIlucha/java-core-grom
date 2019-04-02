package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromKeyboard {
    public static void main(String[] args) throws IOException {
        readKeyboardWithIOStream2();

    }

    private static void readKeyboardWithIOStream() {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter you name");

        try {
            System.out.println("Hello, " + br.readLine() + "!");
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        } finally {
            try {
                reader.close();
                br.close();
            } catch (IOException e) {
                System.err.println("Closing stream failed");
            }
        }
    }

    private static void readKeyboardWithIOStream2() {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter you name");

        try {
            System.out.println("Hello, " + br.readLine() + "!");
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
    }

}
