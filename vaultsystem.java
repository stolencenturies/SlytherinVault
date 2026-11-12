import java.util.Scanner;

class VaultSystem {
    // Encapsulated attributes (Private to protect data integrity)
    private String ownerName;
    private double balance;

    // Constructor to initialize the vault
    public VaultSystem(String ownerName, double initialDeposit) {
        this.ownerName = ownerName;
        this.balance = initialDeposit;
    }

    // Method to add funds
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw funds
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + " | Remaining Balance: $" + balance);
        } else {
            System.out.println("Transaction denied: Insufficient funds or invalid amount.");
        }
    }

    // Display dossier status
    public void displayStatus() {
        System.out.println("\n--- SLYTHERIN VAULT DOSSIER ---");
        System.out.println("Owner: " + ownerName);
        System.out.println("Current Reserves: $" + balance);
        System.out.println("-------------------------------\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Vault Owner Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Initial Gold Deposit: ");
        double initial = scanner.nextDouble();

        // Instantiate your first Java Object
        VaultSystem myVault = new VaultSystem(name, initial);
        myVault.displayStatus();

        // Execute test transactions
        myVault.deposit(500.00);
        myVault.withdraw(200.00);
        myVault.displayStatus();

        scanner.close();
    }
}
