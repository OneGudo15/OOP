public class SavingsAccount extends Account {
    private final double minimumBalance;
    private final double interestRate;

    public SavingsAccount(String accountNumber, double balance,
                          double minimumBalance, double interestRate) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.printf("Withdrawal rejected for SavingsAccount %s: amount must be positive.%n",
                    accountNumber);
            return;
        }

        if (balance - amount < minimumBalance) {
            System.out.printf(
                    "Withdrawal rejected for SavingsAccount %s: balance would fall below minimum balance %.2f.%n",
                    accountNumber, minimumBalance);
            return;
        }

        balance -= amount;
        System.out.printf("Withdrew %.2f from SavingsAccount %s. New balance: %.2f%n",
                amount, accountNumber, balance);
    }

    @Override
    public void endOfMonth() {
        double interest = balance * interestRate;
        balance += interest;

        System.out.printf("SavingsAccount %s interest applied: +%.2f. New balance: %.2f%n",
                accountNumber, interest, balance);
    }
}