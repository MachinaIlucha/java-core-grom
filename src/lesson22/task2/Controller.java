package lesson22.task2;

public class Controller {

    public Transaction save(Transaction transaction) throws Exception {
        return TransactionDAO.save(transaction);
    }

    private Transaction[] transactionList() {
        return TransactionDAO.transactionList();
    }

    private Transaction[] transactionList(String city) throws Exception {
        return TransactionDAO.transactionList(city);
    }

    private Transaction[] transactionList(int amount) throws Exception {
        return TransactionDAO.transactionList(amount);
    }

}
