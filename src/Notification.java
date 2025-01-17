public class Notification {
    public static void sendEmail(String recipient, String message) {
        System.out.println("Sending email to " + recipient + ": " + message);
    }

    public static void sendSMS(String phoneNumber, String message) {
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}
