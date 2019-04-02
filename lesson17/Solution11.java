package lesson17;

public class Solution11 {
    public static void main(String[] args) {
        String test = "1 value errwr , 323dssd 332";
        System.out.println(countWords(test));
        System.out.println(maxWord(test));
        System.out.println(minWord(test));
        System.out.println(mostCountedWord(test));
    }

    public static int countWords(String input) {
        int j, n = 0;

        for (int i = 0; i < input.length(); i = j) {
            while ((i < input.length()) && !Character.isLetter(input.charAt(i)))
                i++;

            j = i + 1;
            while ((j < input.length()) && Character.isLetter(input.charAt(j)))
                j++;

            if (i != input.length())
                n++;
        }
        return n;
    }

    public static String mostCountedWord(String input) {
        if (input.isEmpty()) {
            return null;
        }

        String[] words = input.split(" ");

        int maxCount = 0;
        String mostFrequent = null;
        for (String word : words) {
            int count = 0;
            for (String item : words) {
                if (word.equals(item) && word.length() > 0 && Character.isLetter(item.charAt(0))) {
                    count++;
                }

                if (count > maxCount) {
                    maxCount = count;
                    mostFrequent = word;
                }
            }
        }
        return mostFrequent;
    }


    public static String maxWord(String input) {
        String[] words = input.split(" ");

        if (words.length == 0) {
            return null;
        }

        String max = null;

        for (String word : words) {
            if (word.length() > 0 && checkLetter(word)) {
                max = word;
                break;
            }
        }

        if (max == null){
            return null;
        }

        for (String word : words){
            if (word.length() > max.length() && word.length() > 0 && checkLetter(word))
                max = word;
        }

        return max;
    }

    public static String minWord(String input) {

        String[] words = input.split(" ");

        if (words.length == 0) {
            return null;
        }

        String min = null;

        for (String word : words) {
            if (word.length() > 0 && checkLetter(word)) {
                min = word;
                break;
            }
        }

        if (min == null){
            return null;
        }

        for (String word : words){
            if (word.length() < min.length() && word.length() > 0 && checkLetter(word))
                min = word;
        }

        return min;
    }

    public static boolean checkLetter(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}
