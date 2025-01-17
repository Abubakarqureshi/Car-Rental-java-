import java.util.Scanner;

public class Payment {
    private Booking booking;
    private double totalAmount;

    public Payment(Booking booking, Scanner scanner) {
        this.booking = booking;
        this.totalAmount = booking.getCar().getPricePerDay() * booking.getDays();
    }

    // Process the payment
    public void processPayment() {
        System.out.println("Total Payment: $" + totalAmount);

        // Consume any leftover newline character
        Scanner scanner = new Scanner(System.in); // Fix by using the passed scanner
        System.out.print("Enter payment method (Credit/Debit): ");
        String paymentMethod = scanner.nextLine();  // Correct method to capture input

        // Here we would add actual payment processing code
        System.out.println("Payment processed successfully using " + paymentMethod);

        // Handle fine logic after payment
        Fine fine = new Fine(booking.getDays(), totalAmount, scanner);  // Pass the scanner here
        fine.applyFineIfNecessary();
    }
}
