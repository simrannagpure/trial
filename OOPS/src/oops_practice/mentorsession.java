package oops_practice;

public class mentorsession {
    static String employee_name;
    static int ctc;

    mentorsession(String employee_name, int ctc){
        this.employee_name = employee_name;
        this.ctc = ctc;
    }

    public static void main(String[] args) {
        mentorsession abc = new mentorsession("simran", 10000);
        System.out.println(employee_name);
        System.out.println(ctc);
    }
}

class Account {

    private String accountNumber;

    private double balance;

    public Account(String accountNumber, double balance) {

        this.accountNumber = accountNumber;

        this.balance = balance;

    }

    public void deposit(double amount) {

        balance += amount;

    }

    public void withdraw(double amount) {

        if (balance >= amount) {

            balance -= amount;

        } else {

            System.out.println("Insufficient balance");

        }

    }

    public double getBalance() {

        return balance;

    }

    public String getAccountNumber() {

        return accountNumber;

    }

    public void displayInfo() {

        System.out.println("Account Number: " + accountNumber);

        System.out.println("Balance: " + balance);

    }

    public static void main(String[] args) {

        Account account1 = new Account("12345", 1000);

        account1.deposit(500);

        account1.withdraw(300);

        account1.displayInfo();

    }

}



