package lesson22.task2;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        Transaction transaction = new Transaction(124135432, "Kiev", 1, "Transfer", TransactionType.OUTCOME, new Date());
        Transaction transaction2 = new Transaction(53463245, "Odessa", 1, "Transfer", TransactionType.OUTCOME, new Date());
        Transaction transaction3 = new Transaction(654315534, "Kiev", 2, "Transfer", TransactionType.OUTCOME, new Date());
        Transaction transaction4 = new Transaction(875645643, "Kiev", 3, "Transfer", TransactionType.OUTCOME, new Date());
        Transaction transaction5 = new Transaction(855464587, "Odessa", 1, "Transfer", TransactionType.OUTCOME, new Date());

        Transaction transaction6 = new Transaction(342546452, "Odessa", 1, "Transfer", TransactionType.OUTCOME, new Date());
        Transaction transaction7 = new Transaction(213154536, "Odessa", 1, "Transfer", TransactionType.OUTCOME, new Date());
        Transaction transaction8 = new Transaction(965643124, "Kiev", 4, "Transfer", TransactionType.OUTCOME, new Date());
        Transaction transaction9 = new Transaction(897647457, "Kiev", 3, "Transfer", TransactionType.OUTCOME, new Date());
        Transaction transaction10 = new Transaction(345786740, "Odessa", 1, "Transfer", TransactionType.OUTCOME, new Date());

        Transaction transaction11 = null;

        Transaction[] transactions = {transaction, transaction2, transaction3, transaction4, transaction5, transaction6, transaction7, transaction8, transaction9, null};
        Transaction[] transactions2 = {null, null, null, null, null};

        TransactionDAO transactionDAO = new TransactionDAO();

        System.out.println("-----------------------------------------");

        System.out.println(Arrays.toString(transactionDAO.transactionList("Kiev")));

        System.out.println("-----------------------------------------");
    }
}
