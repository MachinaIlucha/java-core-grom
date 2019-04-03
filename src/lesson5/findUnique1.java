package lesson5;

import java.util.Arrays;

public class findUnique1 {
    public static void main(String[] args) {
        int[] array = {11, 12, 10, 4, 44, 100, 44, 11, 10, 3};
        System.out.println(uniqueCount(array));
    }


    public static int uniqueCount(int[] array) {
        //1.взять первое число из массива
        //2.пройтись через весь массив и проверить не совпадает ли оно с другими
        //3.Если совпадает записать в метод +1
        //4.Вернуть результат

        int i = array.length;
        int unique = 0;
        int k = 0;
        int p = 1;

        while (k <= array.length -1 ) {
            System.out.println(unique);
            while(array[k] != array[p])
            {
                if(array[k] != array[p])
                {
                    p++;
                }
                else
                {
                    unique++;
                }
            }
            k++;

        }

        return unique;
    }
}
