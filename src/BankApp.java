import java.util.Scanner;


public class BankApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final InputHandler inputHandler = new InputHandler(scanner);

    public static void main(String[] args) {
        System.out.println(" Welcome to SimpleBank ");

        System.out.print("Enter your account name: ");
        String accountName = inputHandler.readNonEmptyString();

        System.out.println("\nHello " + accountName + ", let's set up your account.\n");


        System.out.print("Enter your opening balance: ");
        double openingBalance = inputHandler.readNonNegativeDouble();

        Account account = new BankAccount(openingBalance);

        boolean running = true;

        while (running) {
            showMenu();
            String choice = inputHandler.readLine().trim();

            switch (choice) {
                case "1":
                    handleDeposit(account);
                    break;
                case "2":
                    handleWithdraw(account);
                    break;
                case "3":
                    System.out.println("\nCurrent Balance: $" + account.getBalance());
                    break;
                case "4":
                    System.out.println("\nThank you for using SimpleBank, " + accountName + "!");
                    running = false;
                    continue;
                default:
                    System.out.println("Invalid option. Please choose 1-4.");
            }
        }
    }


    public static void showMenu() {
        System.out.println("\n   MAIN MENU    ");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option (1-4): ");
    }


    private static void handleDeposit(Account account) {
        System.out.print("Enter deposit amount: ");
        double amount = inputHandler.readPositiveDouble();
        TransactionService.handleDeposit(account, amount);
    }

    private static void handleWithdraw(Account account) {
        System.out.print("Enter withdraw amount: ");
        double amount = inputHandler.readPositiveDouble();
        TransactionService.handleWithdraw(account, amount);
    }
}
