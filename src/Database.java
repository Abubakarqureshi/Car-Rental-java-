import java.util.HashMap;
import java.util.HashSet;

public class Database {
    private HashMap<String, Car> cars;
    private HashMap<String, User> users;
    private HashSet<Booking> bookings;

    public Database() {
        cars = new HashMap<>();
        users = new HashMap<>();
        bookings = new HashSet<>();
    }

    // Add a car to the system
    public void addCar(Car car) {
        cars.put(car.getCarId(), car);
    }

    // Add a user (customer or admin) to the system
    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    // Add a booking
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    // Authenticate customer
    public Customer authenticateCustomer(String username, String password) {
        User user = users.get(username);
        if (user instanceof Customer && user.authenticate(username, password)) {
            return (Customer) user;
        }
        return null;
    }

    // Authenticate admin
    public Admin authenticateAdmin(String username, String password) {
        User user = users.get(username);
        if (user instanceof Admin && user.authenticate(username, password)) {
            return (Admin) user;
        }
        return null;
    }

    public Car getCar(String carId) {
        return cars.get(carId);
    }

    public Booking getBookingByCarId(String carId) {
        for (Booking booking : bookings) {
            if (booking.getCar().getCarId().equals(carId)) {
                return booking;
            }
        }
        return null;
    }

    public void displayAllCars() {
        for (Car car : cars.values()) {
            System.out.println(car);
        }
    }

    public void displayAllBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}
