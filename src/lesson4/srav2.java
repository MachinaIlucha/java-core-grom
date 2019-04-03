package lesson4;

public class srav2 {
    public static void main(String[] args) {
        System.out.println(sum(2,10));
        System.out.println(compareSums(5, 45, 5, 34));
    }

    public static boolean compareSums(int a, int b, int c, int d) {
        int s = sum(a,b);
        int p = sum(c,d);
        return s>p;
    }

    public static int sum(int from, int to) {
        int sum= ((from+to)/2)*to;
        return sum;
    }
}
