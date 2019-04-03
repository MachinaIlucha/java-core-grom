package mine;

public class aqwe {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(114));
        System.out.println(findNextSquare(114));
    }

    public static long findNextSquare(long sq) {
        double a = Math.sqrt(sq);
        if (a % 1 == 0) {
            a++;
            a = a * a;
            return (long) a;
        } else
            return -1;
    }
}
