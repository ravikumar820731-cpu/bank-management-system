
import java.util.*;

class BankAccount {
    private String accountHolder;
    private long accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String name, long accNo, double initialBalance) {
        accountHolder = name;
        accountNumber = accNo;
        balance = initialBalance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully!");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Available Balance: Rs. " + balance);
    }

    // Display account details
    public void displayDetails() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs. " + balance);
    }
}

public class BankManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        int choice;

        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (account != null) {
                        System.out.println("Account already exists!");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Account Number: ");
                    long accNo = sc.nextLong();

                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = sc.nextDouble();

                    if (initialBalance < 0) {
                        System.out.println("Invalid initial balance!");
                        break;
                    }

                    account = new BankAccount(name, accNo, initialBalance);

                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    if (account == null) {
                        System.out.println("Please create an account first!");
                    } else {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                    }
                    break;

                case 3:
                    if (account == null) {
                        System.out.println("Please create an account first!");
                    } else {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                    }
                    break;

                case 4:
                    if (account == null) {
                        System.out.println("Please create an account first!");
                    } else {
                        account.checkBalance();
                    }
                    break;

                case 5:
                    if (account == null) {
                        System.out.println("Please create an account first!");
                    } else {
                        account.displayDetails();
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using our bank!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
