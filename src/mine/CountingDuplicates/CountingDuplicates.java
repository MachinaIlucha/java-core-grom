package mine.CountingDuplicates;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        // Write your code here

        text.toUpperCase();

        int distinct = 0;
        int count = 0;



        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    distinct++;
                }
            }
            if (distinct >= 2)
                count++;
            String d = String.valueOf(text.charAt(i)).trim();
            text = text.replaceAll(d, "");
            distinct = 0;

        }
        return count;
    }


}
