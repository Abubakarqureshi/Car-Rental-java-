import java.util.Scanner;

public class Fine {
    private int rentalDays;
    private double totalAmount;
    private Scanner scanner;  // Add a scanner object to read user input

    // Modify constructor to accept scanner as a parameter
    public Fine(int rentalDays, double totalAmount, Scanner scanner) {
        this.rentalDays = rentalDays;
        this.totalAmount = totalAmount;
        this.scanner = scanner;  // Initialize scanner
    }

    // Apply fine logic if the customer exceeds the rental days
    public void applyFineIfNecessary() {
        System.out.print("Enter actual days rented: ");
        int actualDays = scanner.nextInt();  // Use the scanner to read the user input
        if (actualDays > rentalDays) {
            double fineAmount = (actualDays - rentalDays) * 50;  // Rs 50 fine per day
            totalAmount += fineAmount;  // Add the fine to the total amount
            System.out.println("Fine applied: Rs " + fineAmount);
        }
        System.out.println("Total payment including fine: Rs " + totalAmount);
    }
}
