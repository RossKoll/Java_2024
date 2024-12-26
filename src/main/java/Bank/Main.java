package Bank;

public class Main {
    public static void main(String[] args) {
        Bank_Account account = new Bank_Account("RossAccount",0001, 10_000.0);
        account.deposit(5_0000);
        account.displayCurrentBalance();
        account.withdraw(2500);
        account.displayCurrentBalance();
    }
}
