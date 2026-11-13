public class EliteVault extends VaultSystem {
    private double interestRate; // e.g., 0.05 for 5%

    // Constructor passes core details up to VaultSystem using super()
    public EliteVault(String ownerName, double initialDeposit, int pin, double interestRate) {
        super(ownerName, initialDeposit, pin);
        this.interestRate = interestRate;
    }

    // Exclusive feature only available to EliteVault
    public void applyInterest() {
        double interestEarned = balance * interestRate;
        balance += interestEarned;
        transactionHistory.add("INTEREST | +$" + interestEarned + " | Balance: $" + balance);
        System.out.println("Elite Yield Applied (" + (interestRate * 100) + "%): +$" + interestEarned);
    }
}
