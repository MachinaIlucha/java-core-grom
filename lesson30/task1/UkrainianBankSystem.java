package lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount))
            return;

        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(),TransactionType.WITHDRAWAL,amount,"sdsdc");
    }

    @Override
    public void fund(User user, int amount) {
        int limit = user.getBank().getLimitOfFunding();
        double balance = user.getBalance();
        if (amount <= limit)
            balance += amount;

        user.setBalance(balance);

        createAndSaveTransaction(new Date(),TransactionType.FUNDING,amount,"sdsdc");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        //снимаем деньги с fromUser
        //пополняем toUser
        if (!checkWithdraw(fromUser, amount)) {
            printWithdrawalErrorMsg(amount, fromUser);
        } else {
            if (fromUser.getBank().getCurrency() == Currency.USD && toUser.getBank().getCurrency() == Currency.EUR)
                return;
            else {
                //TODO check fund rules
                fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
                //TODO fund
                fund(toUser, amount);
            }
        }

        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), new Date(),null,TransactionType.FUNDING,amount,"sdsdc");
        transactions.add(tr);
    }

    @Override
    public void paySalary(User user) {
        int limit = user.getBank().getLimitOfFunding();
        double balance = user.getBalance();
        if (user.getSalary() <= limit) {
            balance += user.getSalary();
        }

        user.setBalance(balance);


    }

    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + " from user " + user.toString());
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private Transaction createAndSaveTransaction(Date dateCreated,TransactionType type, int amount,String descr){
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(),dateCreated,null,type,amount,descr);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
