import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Customer extends User {
    private Set<Booking> bookingHistory;

    public Customer(String username, String password, String email) {
        super(username, password, email);
        this.bookingHistory = new HashSet<>();
    }

    @Override
    public boolean authenticate(String username, String password) {
        return this.getUsername().equals(username) && this.getPassword().equals(password);
    }

    // Customer menu
    public void menu(Scanner scanner, Database database) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Browse Available Cars");
            System.out.println("2. Make a Booking");
            System.out.println("3. View Booking History");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Log Out");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: browseCars(database); break;
                case 2: makeBooking(scanner, database); break;
                case 3: viewBookingHistory(); break;
                case 4: cancelBooking(scanner, database); break;
                case 5: exit = true; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private void browseCars(Database database) {
        System.out.println("Available Cars:");
        database.displayAllCars();
    }

    private void makeBooking(Scanner scanner, Database database) {
        System.out.print("Enter Car ID to book: ");
        String carId = scanner.next();
        Car car = database.getCar(carId);

        if (car != null && car.isAvailable()) {
            car.rentCar();
            System.out.print("Enter number of days for booking: ");
            int days = scanner.nextInt();
            Booking booking = new Booking(this, car, days);
            bookingHistory.add(booking);
            database.addBooking(booking);
            System.out.println("Booking confirmed for " + car.getModel() + " for " + days + " days.");

            Payment payment = new Payment(booking, scanner);
            payment.processPayment();
        } else {
            System.out.println("Car not available.");
        }
    }

    private void viewBookingHistory() {
        if (bookingHistory.isEmpty()) {
            System.out.println("No booking history found.");
        } else {
            for (Booking booking : bookingHistory) {
                System.out.println(booking);
            }
        }
    }

    private void cancelBooking(Scanner scanner, Database database) {
        System.out.print("Enter Car ID to cancel booking: ");
        String carId = scanner.next();
        Booking booking = database.getBookingByCarId(carId);

        if (booking != null) {
            booking.setCancelled(true);
            System.out.println("Booking for " + booking.getCar().getModel() + " has been cancelled.");
        } else {
            System.out.println("Booking not found.");
        }
    }
}






import java.util.Date;

public class Booking {
    private Customer customer;
    private Car car;
    private Date bookingDate;
    private int days;
    private boolean cancelled;

    public Booking(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.bookingDate = new Date();
        this.days = days;
        this.cancelled = false;
    }

    public Car getCar() {
        return car;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public int getDays() {
        return days;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public String toString() {
        return "Booking [Customer: " + customer.getUsername() + ", Car: " + car.getModel() + ", Date: " + bookingDate + ", Days: " + days + "]";
    }
}





import java.util.Date;

public class Booking {
    private Customer customer;
    private Car car;
    private Date bookingDate;
    private int days;
    private boolean cancelled;

    public Booking(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.bookingDate = new Date();
        this.days = days;
        this.cancelled = false;
    }

    public Car getCar() {
        return car;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public int getDays() {
        return days;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public String toString() {
        return "Booking [Customer: " + customer.getUsername() + ", Car: " + car.getModel() + ", Date: " + bookingDate + ", Days: " + days + "]";
    }
}






import java.util.Date;

public class Booking {
    private Customer customer;
    private Car car;
    private Date bookingDate;
    private int days;
    private boolean cancelled;

    public Booking(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.bookingDate = new Date();
        this.days = days;
        this.cancelled = false;
    }

    public Car getCar() {
        return car;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public int getDays() {
        return days;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public String toString() {
        return "Booking [Customer: " + customer.getUsername() + ", Car: " + car.getModel() + ", Date: " + bookingDate + ", Days: " + days + "]";
    }
}






import java.util.Date;

public class Booking {
    private Customer customer;
    private Car car;
    private Date bookingDate;
    private int days;
    private boolean cancelled;

    public Booking(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.bookingDate = new Date();
        this.days = days;
        this.cancelled = false;
    }

    public Car getCar() {
        return car;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public int getDays() {
        return days;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public String toString() {
        return "Booking [Customer: " + customer.getUsername() + ", Car: " + car.getModel() + ", Date: " + bookingDate + ", Days: " + days + "]";
    }
}



import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Customer extends User {
    private Set<Booking> bookingHistory;

    public Customer(String username, String password, String email) {
        super(username, password, email);
        this.bookingHistory = new HashSet<>();
    }

    @Override
    public boolean authenticate(String username, String password) {
        return this.getUsername().equals(username) && this.getPassword().equals(password);
    }

    // Customer menu
    public void menu(Scanner scanner, Database database) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Browse Available Cars");
            System.out.println("2. Make a Booking");
            System.out.println("3. View Booking History");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Log Out");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: browseCars(database); break;
                case 2: makeBooking(scanner, database); break;
                case 3: viewBookingHistory(); break;
                case 4: cancelBooking(scanner, database); break;
                case 5: exit = true; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private void browseCars(Database database) {
        System.out.println("Available Cars:");
        database.displayAllCars();
    }

    private void makeBooking(Scanner scanner, Database database) {
        System.out.print("Enter Car ID to book: ");
        String carId = scanner.next();
        Car car = database.getCar(carId);

        if (car != null && car.isAvailable()) {
            car.rentCar();
            System.out.print("Enter number of days for booking: ");
            int days = scanner.nextInt();
            Booking booking = new Booking(this, car, days);
            bookingHistory.add(booking);
            database.addBooking(booking);
            System.out.println("Booking confirmed for " + car.getModel() + " for " + days + " days.");

            Payment payment = new Payment(booking, scanner);
            payment.processPayment();
        } else {
            System.out.println("Car not available.");
        }
    }

    private void viewBookingHistory() {
        if (bookingHistory.isEmpty()) {
            System.out.println("No booking history found.");
        } else {
            for (Booking booking : bookingHistory) {
                System.out.println(booking);
            }
        }
    }

    private void cancelBooking(Scanner scanner, Database database) {
        System.out.print("Enter Car ID to cancel booking: ");
        String carId = scanner.next();
        Booking booking = database.getBookingByCarId(carId);

        if (booking != null) {
            booking.setCancelled(true);
            System.out.println("Booking for " + booking.getCar().getModel() + " has been cancelled.");
        } else {
            System.out.println("Booking not found.");
        }
    }
}






import java.util.Date;

public class Booking {
    private Customer customer;
    private Car car;
    private Date bookingDate;
    private int days;
    private boolean cancelled;

    public Booking(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.bookingDate = new Date();
        this.days = days;
        this.cancelled = false;
    }

    public Car getCar() {
        return car;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public int getDays() {
        return days;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public String toString() {
        return "Booking [Customer: " + customer.getUsername() + ", Car: " + car.getModel() + ", Date: " + bookingDate + ", Days: " + days + "]";
    }
}





import java.util.Date;

public class Booking {
    private Customer customer;
    private Car car;
    private Date bookingDate;
    private int days;
    private boolean cancelled;

    public Booking(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.bookingDate = new Date();
        this.days = days;
        this.cancelled = false;
    }

    public Car getCar() {
        return car;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public int getDays() {
        return days;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public String toString() {
        return "Booking [Customer: " + customer.getUsername() + ", Car: " + car.getModel() + ", Date: " + bookingDate + ", Days: " + days + "]";
    }
}






import java.util.Date;

public class Booking {
    private Customer customer;
    private Car car;
    private Date bookingDate;
    private int days;
    private boolean cancelled;

    public Booking(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.bookingDate = new Date();
        this.days = days;
        this.cancelled = false;
    }

    public Car getCar() {
        return car;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public int getDays() {
        return days;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public String toString() {
        return "Booking [Customer: " + customer.getUsername() + ", Car: " + car.getModel() + ", Date: " + bookingDate + ", Days: " + days + "]";
    }
}






import java.util.Date;

public class Booking {
    private Customer customer;
    private Car car;
    private Date bookingDate;
    private int days;
    private boolean cancelled;

    public Booking(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.bookingDate = new Date();
        this.days = days;
        this.cancelled = false;
    }

    public Car getCar() {
        return car;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public int getDays() {
        return days;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public String toString() {
        return "Booking [Customer: " + customer.getUsername() + ", Car: " + car.getModel() + ", Date: " + bookingDate + ", Days: " + days + "]";
    }
}
