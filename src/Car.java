public class Car {
    private String carId;
    private String model;
    private String make;
    private double pricePerDay;
    private boolean available;

    public Car(String carId, String model, String make, double pricePerDay) {
        this.carId = carId;
        this.model = model;
        this.make = make;
        this.pricePerDay = pricePerDay;
        this.available = true;
    }

    public String getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rentCar() {
        available = false;
    }

    public void returnCar() {
        available = true;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return carId + ": " + model + " (" + make + "), Price per day: " + pricePerDay;
    }
}
