package lesson32.DZ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void readNumbers() throws Exception {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        int sum = 0;
        for (int n = 3; n != 0; --n) {
            sum = 0;
            System.out.println("Numbers: ");

            String[] numbers = br.readLine().split(" ");

            for (String number : numbers) {
                if (Integer.parseInt(number) <= 100)
                    sum += Integer.parseInt(number);
                else {
                    if (n != 1) {
                        System.out.println("Your numbers are wrong. You have " + (n - 1) + " attempts to try again");
                    } else {
                        System.out.println("Your numbers are wrong. Number of attempts exceeded");
                        break;
                    }
                }
            }
            if (sum != 0)
                break;
        }
        System.out.println(sum);
    }
}
