import java.util.Scanner;

public class Admin extends User {

    public Admin(String username, String password, String email) {
        super(username, password, email);
    }

    @Override
    public boolean authenticate(String username, String password) {
        return this.getUsername().equals(username) && this.getPassword().equals(password);
    }

    // Admin menu
    public void menu(Scanner scanner, Database database) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add New Car");
            System.out.println("2. View All Cars");
            System.out.println("3. Update Car Details");
            System.out.println("4. View All Bookings");
            System.out.println("5. Log Out");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: addNewCar(scanner, database); break;
                case 2: showAllCars(database); break;
                case 3: updateCarDetails(scanner, database); break;
                case 4: showAllBookings(database); break;
                case 5: exit = true; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private void addNewCar(Scanner scanner, Database database) {
        System.out.print("Enter Car ID: ");
        String carId = scanner.next();
        System.out.print("Enter Car Model: ");
        String model = scanner.next();
        System.out.print("Enter Car Make: ");
        String make = scanner.next();
        System.out.print("Enter Price per Day: ");
        double price = scanner.nextDouble();

        Car newCar = new Car(carId, model, make, price);
        database.addCar(newCar);
        System.out.println("New car added successfully!");
    }

    private void showAllCars(Database database) {
        database.displayAllCars();
    }

    private void updateCarDetails(Scanner scanner, Database database) {
        System.out.print("Enter Car ID to update: ");
        String carId = scanner.next();
        Car car = database.getCar(carId);

        if (car != null) {
            System.out.print("Enter new price per day: ");
            double price = scanner.nextDouble();
            car.setPricePerDay(price);
            System.out.println("Car price updated successfully!");
        } else {
            System.out.println("Car not found.");
        }
    }

    private void showAllBookings(Database database) {
        database.displayAllBookings();
    }
}
