package lesson19;

public class RuntimeExceptionExample {
    public static void main(String[] args) {
        //arithmetic exception

        arithmeticException(2);

        try {
            arithmeticException(0);
        } catch (ArithmeticException e){
            System.err.println("something wrong");
        }
    }

    private static void arithmeticException(int a) {
        System.out.println(10 / a);
    }
}
