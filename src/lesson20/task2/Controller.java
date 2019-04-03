package lesson20.task2;

public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws Exception {
        return transactionDAO.save(transaction);
    }

    private Transaction[] transactionList() {
        return transactionDAO.transactionList();
    }

    private Transaction[] transactionList(String city) throws Exception {
        return transactionDAO.transactionList(city);
    }

    private Transaction[] transactionList(int amount) throws Exception {
        return transactionDAO.transactionList(amount);
    }

}
