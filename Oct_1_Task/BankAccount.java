package Oct_1_Task;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

        private double balance;
        private final Lock lock = new ReentrantLock();

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public void deposit(double amount) {

            lock.lock();
            try {
                balance += amount;
                System.out.printf("Deposited: %.2f, New Balance: %.2f%n", amount, balance);
            } finally {
                lock.unlock();
            }
        }

        public void withdraw(double amount) {
            lock.lock();
            try {
                if (balance >= amount) {
                    balance -= amount;
                    System.out.printf("Withdrew: %.2f, New Balance: %.2f%n", amount, balance);
                } else {
                    System.out.printf("Withdrawal of %.2f failed. Insufficient funds. Current Balance: %.2f%n", amount, balance);
                }
            } finally {
                lock.unlock();
            }
        }

        public double getBalance() {
            return balance;
        }
    }

    class ATM extends Thread {
        private BankAccount account;
        private Random random = new Random();

        public ATM(BankAccount account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                // Randomly choose to deposit or withdraw
                boolean isDeposit = random.nextBoolean();
                double amount = (random.nextDouble() * 100); // Amount between 0 and 100

                if (isDeposit) {
                    account.deposit(amount);
                } else {
                    account.withdraw(amount);
                }

                // Sleep for a random time between transactions
                try {
                    Thread.sleep(random.nextInt(1000)); // Sleep for 0 to 1000 milliseconds
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }


