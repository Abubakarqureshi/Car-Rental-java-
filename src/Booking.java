


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
