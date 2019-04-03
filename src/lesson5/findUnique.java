package lesson5;

import java.util.Arrays;

public class findUnique {
    public static void main(String[] args) {
        int[] array = {11, 12, 10, 4, 44, 100, 44, 11, 10, 11};
        System.out.println(uniqueCount(array));
    }


    public static int uniqueCount(int[] array) {
        //1.взять первое число из массива
        //2.пройтись через весь массив и проверить не совпадает ли оно с другими
        //3.Если совпадает записать в метод +1
        //4.Вернуть результат

        int[] b = new int[array.length];


        for (int l = 0; l < array.length - 1; l++) {
            for (int z = l + 1; z < array.length; z++) {
                if (array[l] == array[z])
                    b[z] = array[l];
            }
        }

        System.out.println(Arrays.toString(b));

        /*int res = 0;

        for (int l = 0; l < array.length - 1; l++) {
            for (int z = l + 1; z < array.length; z++) {
                if (array[l] == array[z])
                    res++;
            }
        }*/

        int p = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] == 0)
                p++;
        }

        return p;
    }
}
