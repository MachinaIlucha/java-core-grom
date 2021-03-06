package lesson12;

public class UkrainianBankSystem implements BankSystem {

    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount))
            return;

        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }

    @Override
    public void fund(User user, int amount) {
        int limit = user.getBank().getLimitOfFunding();
        double balance = user.getBalance();
        if (amount <= limit) {
            balance += amount;
        }

        user.setBalance(balance);
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
}
