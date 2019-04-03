package lesson25.DZ;

import java.util.Arrays;

public class GeneralDAO <T> {
    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[10];

    public T save(T t) throws Exception {

        validate(t);

        int index = 0;
        for (T t1 : array) {
            if (t1 == null) {
                array[index] = t;
                System.out.println(Arrays.toString(array));
                return array[index];
            }
            index++;
        }
        throw new Exception("Not enough space to save");
    }

    public T[] getAll() {
        int count = 0;
        for (T t : array) {
            if (t != null)
                count++;
        }

        @SuppressWarnings("unchecked")
        T[] arrayWithOutNulls = (T[]) new Object[count];

        int index = 0;
        for (T t : array) {
            if (array != null) {
                arrayWithOutNulls[index] = t;
                index++;
            }
        }
        return arrayWithOutNulls;
    }

    private void validate(T t) throws Exception{
        int index = 0;
        for (T ch : array){
            if (ch.equals(t))
                throw new Exception("This object already in storage");
        }
    }
}