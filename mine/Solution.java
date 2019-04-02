package mine;

public class Solution {
    public static void main(String[] args) {
        repeatStr(4, "a");
    }
        public static String repeatStr(final int repeat, final String string) {
            int i = 0;
            for (i = 1; i <= repeat; i++) {
                System.out.print(string);
            }
            return "";
        }
}
