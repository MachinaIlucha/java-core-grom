package lesson4;

public class srav {
    public static void main(String[] args) {
        System.out.println(compareSums(5, 45, 5, 34));
    }

    public static boolean compareSums(int a, int b, int c, int d) {
        long s = sum(a,b);
        long p = sum(c,d);
        return s>p;
    }

    public static long sum(int from, int to) {
        long sum1 = 0;
        for (long i = from; i <= to; i++) {
            sum1 += i;
        }
        return sum1;
    }
}
