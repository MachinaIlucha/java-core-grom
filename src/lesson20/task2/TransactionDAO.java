package lesson20.task2;

import lesson20.task2.exeption.BadRequestException;
import lesson20.task2.exeption.InternalServerException;
import lesson20.task2.exeption.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();


    public Transaction save(Transaction transaction) throws Exception {
//        - сумма транзакции больше указанного лимита
//        - сумма транзакций за день больше дневного лимита
//        - количество транзакций за день больше указанного лимита
//        - если город оплаты (совершения транзакции) не разрешен

        validate(transaction);
        checkSize(transaction);

        int index = 0;
        for (Transaction transaction1 : transactions) {
            if (transaction1 == null) {
                transactions[index] = transaction;
                return transactions[index];
            }
            index++;
        }
        throw new InternalServerException("Not enough space to save transaction with id: " + transaction.getId());
    }

    private void validate(Transaction transaction) throws Exception {
        if (transaction == null)
            throw new BadRequestException("Can't save transaction 'couse it's null");

        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum >= utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can't be saved");

        if (count >= utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can't be saved");

        checkCityOfTran(transaction);
    }

    public Transaction[] transactionList() {

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null)
                count++;
        }

        Transaction[] transactionWithOutNulls = new Transaction[count];

        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                transactionWithOutNulls[index] = transaction;
                index++;
            }
        }
        return transactionWithOutNulls;
    }

    public Transaction[] transactionList(String city) {

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getCity() == city)
                count++;
        }

        Transaction[] transactionsOfCity = new Transaction[count];

        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getCity() == city) {
                transactionsOfCity[index] = transaction;
                index++;
            }
        }

        return transactionsOfCity;
    }

    public Transaction[] transactionList(int amount) {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getAmount() == amount)
                count++;
        }

        Transaction[] transactionOfAmount = new Transaction[count];

        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getAmount() == amount)
                transactionOfAmount[index] = transaction;
        }

        return transactionOfAmount;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }


        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }

    private void checkSize(Transaction transaction) throws InternalServerException {
        int nulls = 0;
        for (Transaction transaction1 : transactions) {
            if (transaction1 == null)
                nulls++;
        }

        if (nulls < 1)
            throw new InternalServerException("Transaction limit exceed " + transaction.getId() + ". Can't be saved");
    }

    private void checkCityOfTran(Transaction transaction) throws BadRequestException {
        boolean c = false;
        for (String city : utils.getCities()) {
            if (city == transaction.getCity()) {
                c = true;
                break;
            }
        }

        if (!c)
            throw new BadRequestException("City of " + transaction.getId() + " not allowed");
    }
}
