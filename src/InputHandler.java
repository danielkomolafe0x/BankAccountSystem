import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readNonEmptyString() {
        while (true) {
            String text = scanner.nextLine().trim();
            if (!text.isEmpty()) return text;
            System.out.print("Input cannot be empty. Try again: ");
        }
    }

    public double readNonNegativeDouble() {
        while (true) {
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine();
                Double amount = validateNegativeAmount(value);
                if (amount != null) return amount;
            } else {
                System.out.print("Invalid number. Try again: ");
                scanner.nextLine();
            }
        }
    }

    private static Double validateNegativeAmount(double value) {
        if (value >= 0) {
            return value;
        }
        System.out.print("Value cannot be negative. Try again: ");
        return null;
    }

    public double readPositiveDouble() {
        while (true) {
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine();
                if (value > 0) {
                    return value;
                }
                System.out.print("Amount must be greater than 0. Try again: ");
            } else {
                System.out.print("Invalid number. Try again: ");
                scanner.nextLine();
            }
        }
    }

    public String readLine() {
        return scanner.nextLine();
    }
}