package lesson5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class danie1 {
    public static void main(String[] args) {
        int[] array = {5, 2, 10, 11, 3};
        System.out.println(Arrays.toString(sortAscending(array)));
        System.out.println(Arrays.toString(sortDescending(array)));
    }

    public static int[] sortAscending(int[] array) {
        //1.сравнить первое число со вторым
        //2.если первое > второго то записать 1 на 2 ,а второе на первое
        //3.так с каждым елементом

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    public static int[] sortDescending(int[] array) {
        //1.сравнить первое число со вторым
        //2.если первое > второго то записать 1 на 2 ,а второе на первое
        //3.так с каждым елементом

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {

                } else {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}
