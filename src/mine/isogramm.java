package mine;

public class isogramm {
    public static void main(String[] args) {
        System.out.println(isIsogram("mose"));
    }


    public static boolean isIsogram(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch1 = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if (ch1 == str.charAt(j)) {
                   return false;
                }
            }
        }
        return true;
    }
}