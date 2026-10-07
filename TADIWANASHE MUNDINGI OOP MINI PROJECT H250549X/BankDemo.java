import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("S001", 1000.00, 500.00, 0.02));
        accounts.add(new CurrentAccount("C001", 300.00, 200.00, 25.00));
        accounts.add(new SavingsAccount("S002", 2000.00, 1000.00, 0.03));
        accounts.add(new CurrentAccount("C002", 100.00, 500.00, 20.00));

        System.out.println("=== Initial accounts ===");
        for (Account account : accounts) {
            System.out.println(account);
        }

        System.out.println("\n=== Polymorphic withdrawals ===");

        double[] withdrawalAmounts = {600.00, 450.00, 500.00, 550.00};

        for (int i = 0; i < accounts.size(); i++) {
            accounts.get(i).withdraw(withdrawalAmounts[i]);
        }

        System.out.println("\n=== Month-end processing ===");

        for (Account account : accounts) {
            account.endOfMonth();
        }

        System.out.println("\n=== Final balances ===");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}