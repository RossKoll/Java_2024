package Bank;

public class Bank_Account {
   private String accountName ;
   private int accountNumber;
   private double accountBalance;

    public void deposit(int amountToDeposit){
        accountBalance += amountToDeposit;
        System.out.println(String.format("%s was added to deposit",amountToDeposit));
    }

    public void withdraw(int amountToWithdraw) {
        if ((accountBalance - amountToWithdraw) < 0) {
            System.out.println("Operation forbidden, not enough money");
        } else if (amountToWithdraw < 0) {
            System.out.println("Not allowed");
        } else {
            accountBalance -= amountToWithdraw;
            System.out.println(String.format("%s was withdraw",amountToWithdraw));
        }
    }

    public void displayCurrentBalance(){
        System.out.println(String.format("Your current balance is : %s", accountBalance));
    }


    public Bank_Account(String accountName, int accountNumber, double accountBalance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }
}
