import java.util.Scanner;
public class Main {
    public static int wrongChoice(Scanner in){
        int x;
        while(true) {
            System.out.print("Invalid choice, try again: ");
            x = in.nextInt();
            if (x == 1 || x == 2 || x == 3 || x == 4 || x == 5) {
                break;
            }
        }
            return x;
    }
    public static void checkBalance(int x) {
        System.out.println("Current Balance: " + x);
    }
    public static int deposit(Scanner in){
            int deposit;
        System.out.print("Enter the amount of deposit: ");
        deposit = in.nextInt();
        if(deposit <=0) {
            while(true) {
                System.out.print("Invalid input, try again: ");
                deposit = in.nextInt();
                if(deposit > 0) {
                    break;
                }
            }
        }
        return deposit;
    }
    public static int withdraw(Scanner in,int x){
        int withdraw;
        System.out.print("Enter the amount of withdraw: ");
        withdraw = in.nextInt();
        if(withdraw <= 0 || withdraw > x) {
            while(true){
                System.out.print("Invalid input, try again: ");
                withdraw = in.nextInt();
                if(withdraw > 0 && withdraw <= x) {
                    break;
                }
            }
        }
        return withdraw;
    }
    public static int transfer(Scanner in,int x){
        int transfer;
        System.out.print("Enter the amount of transfer: ");
        transfer = in.nextInt();
        if(transfer <= 0 || transfer > x) {
            while (true){
                System.out.print("Invalid input, try again: ");
                transfer = in.nextInt();
                if(transfer > 0 && transfer <= x) {
                    break;
                }
            }
        }
        return transfer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int mainBalance = 1000;
        int recipientBalance = 500;
        int x;
        while(true){
            System.out.println("===== Banking System =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            x = in.nextInt();
            if(x != 1 && x != 2 && x != 3 && x != 4 && x != 5 ) {
                x = wrongChoice(in);
            }
            switch(x) {
                case 1:
                    checkBalance(mainBalance);
                    break;
                case 2:
                    int y = deposit(in);
                    mainBalance += y;
                    System.out.println("deposit amount: " + y);
                    System.out.println("deposit successful!");
                    System.out.println("Your balance now: " + mainBalance);
                    break;
                case 3:
                    if(mainBalance == 0) {
                        System.out.println("Your current balance is 0, please deposit first to complete the withdrawal process.");
                        break;
                    }
                    int z = withdraw(in, mainBalance);
                    mainBalance -= z;
                    System.out.println("withdraw amount: " + z);
                    System.out.println("withdraw successful!");
                    System.out.println("Your balance now: " + mainBalance);
                    break;
                case 4:
                    if(mainBalance == 0) {
                        System.out.println("Your current balance is 0, please deposit first to complete the transfer process.");
                        break;
                    }
                    int i = transfer(in, mainBalance);
                    mainBalance -= i;
                    recipientBalance += i;
                    System.out.println("Transfer amount: " + i);
                    System.out.println("Transfer successful!");
                    System.out.println("Your balance now: " + mainBalance);
                    System.out.println("Recipient Balance: " + recipientBalance);
                    break;
            }
                    if(x == 5) {
                        break;
                }
        }
    }
}