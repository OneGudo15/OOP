public abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.printf("Deposit rejected for %s: amount must be positive.%n", accountNumber);
            return;
        }

        balance += amount;
        System.out.printf("Deposited %.2f into %s. New balance: %.2f%n",
                amount, accountNumber, balance);
    }

    public double getBalance() {
        return balance;
    }

    public abstract void withdraw(double amount);

    public abstract void endOfMonth();

    @Override
    public String toString() {
        return String.format("%s[%s] balance=%.2f",
                getClass().getSimpleName(), accountNumber, balance);
    }
}