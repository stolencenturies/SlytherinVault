import java.util.ArrayList;
import java.util.Scanner;

public class VaultSystem {
    // Encapsulated attributes (Private to protect data integrity)
    private String ownerName;
    private double balance;
    private int pin;
    private ArrayList<String> transactionHistory; // New Audit Log


    // Constructor to initialize the vault
    public VaultSystem(String ownerName, double initialDeposit, int pin) {
        this.ownerName = ownerName;
        this.balance = initialDeposit;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
        this.transactionHistory.add("OPENED VAULT | Initial Balance: $" + initialDeposit);
    }

    // Method to add funds
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("DEPOSIT  | +$" + amount + " | Balance: $" + balance);
            System.out.println("Deposited: $" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw funds
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("WITHDRAW | -$" + amount + " | Balance: $" + balance);
            System.out.println("Withdrawn: $" + amount + " | Remaining Balance: $" + balance);
        } else {
            System.out.println("Transaction denied: Insufficient funds or invalid amount.");
        }
    }

    // Method to verify PIN (Clean single responsibility)
    public boolean authenticate(int enteredPin) {
        return this.pin == enteredPin;
    }

    // Display dossier status
    public void displayStatus() {
        System.out.println("\n--- SLYTHERIN VAULT DOSSIER ---");
        System.out.println("Owner: " + ownerName);
        System.out.println("Current Reserves: $" + balance);
        System.out.println("-------------------------------\n");
    }
    public void printLedger() {
        System.out.println("\n=== SLYTHERIN AUDIT LEDGER ===");
        for (String entry : transactionHistory) {
            System.out.println(entry);
        }
        System.out.println("==============================\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. VAULT SETUP
        System.out.print("Enter Vault Owner Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Initial Gold Deposit: ");
        double initial = scanner.nextDouble();
        
        System.out.print("Set a 4-digit Vault PIN: ");
        int userPin = scanner.nextInt();

        VaultSystem myVault = new VaultSystem(name, initial, userPin);

        // 2. SECURITY GATE (3 ATTEMPTS)
        boolean isAuthenticated = false;

        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.print("\n[Attempt " + attempt + "/3] Enter Vault PIN to unlock: ");
            int enteredPin = scanner.nextInt();

            if (myVault.authenticate(enteredPin)) {
                System.out.println("Access Granted. Welcome, " + name + ".");
                isAuthenticated = true;
                break; 
            } else {
                System.out.println("Access Denied. Incorrect PIN.");
            }
        }

        if (!isAuthenticated) {
            System.out.println("\nSECURITY ALERT: Maximum attempts exceeded. Vault locked.");
            scanner.close();
            return;
        }

        // 3. INTERACTIVE VAULT MENU
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== SLYTHERIN VAULT COMMANDS ===");
            System.out.println("1. Deposit Gold");
            System.out.println("2. Withdraw Gold");
            System.out.println("3. View Vault Dossier");
            System.out.println("4. Print Audit Ledger");
            System.out.println("5. Lock and Exit Vault");

            System.out.print("Select an operation (1-5): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    myVault.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    myVault.withdraw(withdrawAmount);
                    break;

                case 3:
                    myVault.displayStatus();
                    break;

                case 4:
                    myVault.printLedger();
                    break;

                default:
                    System.out.println("Invalid command. Choose between 1 and 5.");
                    break;
            }
        }

        scanner.close();
    }
}
