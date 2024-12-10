package oops;

public class Account {
    int acc_number;
    double current_balance;
    String acc_holder_name;

    public Account(){

    }

    public Account(int acc_num, double amt, String name){
        acc_number = acc_num;
        current_balance = amt;
        acc_holder_name = name;
    }

    public static void main(String[] args) {
        Account account_1001 = new Account(1001, 15000, "Rohan Patil");
        // System.out.printf("Account number : %d, Current Balance : %g, Name : %s\n", account_1001.acc_number, account_1001.current_balance, account_1001.acc_holder_name);
        account_1001.printAccDetails();
        account_1001.deposit(10000);
        account_1001.display_balnce();
        account_1001.withdraw(100000);
        account_1001.display_balnce();
    }

    public void deposit(double amount) {
        current_balance = current_balance +amount;
        System.out.println(amount + " deposited");
    }

    private void printAccDetails() {
        System.out.println("------Initial Details----------");
        System.out.println("Account Number  : " + this.acc_number);
        System.out.println("Current Balance : " + this.current_balance);
        System.out.println("Acc Holder Name : " + this.acc_holder_name);
        System.out.println("-------------------------------");
    }

    private void display_balnce(){
        System.out.println("Current Balance : " + current_balance);
    }

    private void withdraw(double amount) {
        System.out.println("Please withdraw : " + amount);
        if (current_balance >= amount) {
            current_balance -= amount;
            System.out.println(amount + " withdrawn.");
        }
        else {
            System.out.println("Insufficient Balance.");
        }

        senMsg(amount);
    }

    private void senMsg(double amount) {
        System.out.println("You have tried to withdraw Rs." + amount + " from your bank account. If it's not you, please contact us.");
    }
}
