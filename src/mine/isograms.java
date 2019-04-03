package mine;

public class isograms {
    public static void main(String[] args) {
        String a = "aht";
        System.out.println(isIsogram(a));
    }

    public static boolean isIsogram(String a) {
        boolean res = true;
        char ch='a';

        for (int j = 0; j <=a.length();j++)
            ch = a.charAt(j);
            for (int i = 1; i < a.length(); i++) {
                if (ch == a.charAt(i))
                    res = false;
            }

        return res;
    }
}
