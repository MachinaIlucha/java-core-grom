package lesson5;

public class minusBalance {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};
    }

    public static int withdraw(String[] clients, int[] balaces, String client, int amount) {
        //1.Найти клиента в базе(массив)
        //2.Отнимаем баланс
        //3.Обновляем баланс
        int balance;
        //1
        int clientIndex = 0;

        for (String cl : clients) {
            if (cl == client)
                break;
            clientIndex++;
        }

        //2
        if (balaces[clientIndex] >= amount) {
            balance = balaces[clientIndex] - amount;
        } else
            balance = -1;


        return balance;
    }
}
