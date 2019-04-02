package lesson2;

public class BreakCountinueExample {
    public static void main(String[] args) {
        int test = 10;

        /*while (test>0){
            Sys.out.println(test);
            Sys.out.println("...");
            test--;
            break;
        }*/

        while (test > 0) {
            System.out.println(test);
            System.out.println("...");
            test--;
        }

        System.out.println("done");
    }
}
