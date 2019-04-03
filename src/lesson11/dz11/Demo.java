package lesson11.dz11;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        Room room1 =  new Room(213145,312,4,null,"POop","Kiev");
        Room room2 =  new Room(217545,3523,2,null,"qwerty","Kiev");
        Room room3 =  new Room(213145,312,4,null,"POop","Kiev");
        Room room4 =  new Room(210785,123,1,null,"lil","Odessa");

        Room[] allRooms = {room1,room2,room3,room4};


        System.out.println(removeDuplicates(allRooms)[0]);
        System.out.println(removeDuplicates(allRooms)[1]);
        System.out.println(removeDuplicates(allRooms)[2]);
        System.out.println(removeDuplicates(allRooms)[3]);
    }


    public static Room[] removeDuplicates(Room[] array){
        //Частные случаи
        if(array.length == 1) return array;
        if(array.length == 0) return new Room[0];
        //
        //Размер больше 1, уникальное значение как минимум одно
        int unique = 1;
        for(int i = 1; i < array.length; i++){
            if(array[i] != array[i - 1]){
                unique++; //Если текущий с предыдущим не равны - значит
                // увеличиваем счетчик уникальных значений
            }
        }
        Room[] result = new Room[unique]; //Новый массив нужного размера
        int k = 0; //Текущая позиция в новом массиве
        if(result.length > 0){
            result[k++] = array[0]; //Пишем в новый массив первое уникальное значение
        }
        for(int i = 1; i < array.length; i++){
            if(array[i] != array[i - 1]){
                result[k++] = array[i]; //Пишем в новый массив остальные уникальные значения
            }
        }
        return result;
    }
}
