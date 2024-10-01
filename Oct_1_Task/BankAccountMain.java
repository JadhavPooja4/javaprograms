package Oct_1_Task;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500); // Initial balance of 500

        // Create multiple ATMs
        ATM atm1 = new ATM(account);
        ATM atm2 = new ATM(account);
        ATM atm3 = new ATM(account);

        // Start the ATMs
        atm1.start();
        atm2.start();
        atm3.start();

        // Wait for all ATMs to finish
        try {
            atm1.join();
            atm2.join();
            atm3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Final balance
        System.out.printf("Final Balance: %.2f%n", account.getBalance());
    }
}
