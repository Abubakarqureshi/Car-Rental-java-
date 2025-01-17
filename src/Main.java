import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();

        // Create sample admin and customers for testing (hardcoded for simplicity)
        Admin admin = new Admin("admin", "admin123", "admin@car.com");
        database.addUser(admin);

        // Create sample cars
        Car car1 = new Car("ABC123", "Toyota Corolla", "Toyota", 50.0);
        Car car2 = new Car("XYZ456", "Honda Civic", "Honda", 60.0);
        database.addCar(car1);
        database.addCar(car2);

        // Create sample customers
        Customer customer1 = new Customer("john_doe", "password123", "john.doe@example.com");
        Customer customer2 = new Customer("jane_doe", "password456", "jane.doe@example.com");
        database.addUser(customer1);
        database.addUser(customer2);

        System.out.println("Welcome to the Car Rental System!");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nPlease select your role:");
            System.out.println("1. Customer");
            System.out.println("2. Admin");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:  // Customer login
                    System.out.print("Enter username: ");
                    String customerUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String customerPassword = scanner.nextLine();

                    // Authenticate customer
                    Customer customer = database.authenticateCustomer(customerUsername, customerPassword);
                    if (customer != null) {
                        System.out.println("Customer logged in successfully!");
                        customer.menu(scanner, database);  // Show customer menu
                    } else {
                        System.out.println("Invalid customer credentials.");
                    }
                    break;

                case 2:  // Admin login
                    System.out.print("Enter admin username: ");
                    String adminUsername = scanner.nextLine();
                    System.out.print("Enter admin password: ");
                    String adminPassword = scanner.nextLine();

                    // Authenticate admin
                    if (admin.authenticate(adminUsername, adminPassword)) {
                        System.out.println("Admin logged in successfully!");
                        admin.menu(scanner, database);  // Show admin menu
                    } else {
                        System.out.println("Invalid admin credentials.");
                    }
                    break;

                case 3:
                    exit = true;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option. Please select 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}
