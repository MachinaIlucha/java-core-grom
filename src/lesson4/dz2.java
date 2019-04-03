package lesson4;

public class dz2 {
    public static void main(String[] args) {
        short a = 2;
        short b = 100;
        System.out.println(findDivCount(a, b, 5));
    }

    public static int findDivCount(short a, short b, int n) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (i % n == 0)
                count++;
        }
        return count;
    }
}
