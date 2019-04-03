package lesson2;

public class SumOfNumbers {
    public static void main(String[] args) {
        long sum = 0;
        int start = 0;
        long end = 1000;
        for (long i = start; i <= end; i++) {
            sum += i;
        }
        long b = sum % 1234;
        long a = sum / 1234;

        boolean sum1 = b > a;

        System.out.println(sum1);
    }
}
