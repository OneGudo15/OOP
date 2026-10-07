public class CurrentAccount extends Account {
    private final double overdraftLimit;
    private final double monthlyMaintenanceFee;

    public CurrentAccount(String accountNumber, double balance,
                          double overdraftLimit, double monthlyMaintenanceFee) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.printf("Withdrawal rejected for CurrentAccount %s: amount must be positive.%n",
                    accountNumber);
            return;
        }

        if (balance - amount < -overdraftLimit) {
            System.out.printf(
                    "Withdrawal rejected for CurrentAccount %s: would exceed overdraft limit %.2f.%n",
                    accountNumber, overdraftLimit);
            return;
        }

        balance -= amount;
        System.out.printf("Withdrew %.2f from CurrentAccount %s. New balance: %.2f%n",
                amount, accountNumber, balance);
    }

    @Override
    public void endOfMonth() {
        balance -= monthlyMaintenanceFee;

        System.out.printf(
                "CurrentAccount %s monthly maintenance fee deducted: -%.2f. New balance: %.2f%n",
                accountNumber, monthlyMaintenanceFee, balance);
    }
}