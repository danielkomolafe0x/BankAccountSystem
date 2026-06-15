public class TransactionService {

    public static void handleDeposit(Account account, double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. New balance: $" + account.getBalance());
    }

    public static void handleWithdraw(Account account, double amount) {
        boolean success = account.withdraw(amount);
        if (success) {
            System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient balance.");
        }
    }
}