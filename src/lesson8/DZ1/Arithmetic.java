package lesson8.DZ1;

public class Arithmetic {
    public boolean check(int[] array) {
        for (long i : array) {
            if (i > 100)
                return true;
        }
        return false;
    }
}
