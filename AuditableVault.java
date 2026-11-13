
public interface AuditableVault {
    void deposit(double amount);
    void withdraw(double amount);
    boolean authenticate(int enteredPin);
    void displayStatus();
    void printLedger();
}
