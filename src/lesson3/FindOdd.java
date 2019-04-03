package lesson3;

public class FindOdd {
    public static void main(String[] args) {
        int start = 0;
        long end = 1000;
        int p = 0;

        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                System.out.println("Found");
                p = i + p;
            }
        }
        if (p * 5 > 5000) {
            System.out.println("Bigger");
        } else {
            System.out.println("Smaller or equal");
        }
    }
}
