package lesson18.DZ;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String test = "Hello 12 , i am 15 years old";
        System.out.println(Arrays.toString(findNumbers(test)));
    }

    public static int[] findNumbers(String text) {
        if (text.isEmpty()) {
            return null;
        }

        String[] words = text.split(" ");

        int i = 0;
        for (String word : words) {
            if (checkNumber(word)) {
                i++;
            }
        }

        int[] ints = new int[i];

        i = 0;
        for (String word : words) {
            if (checkNumber(word)) {
                ints[i] = Integer.parseInt(word);
                i++;
            }
        }

        return ints;
    }

    private static boolean checkNumber(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
