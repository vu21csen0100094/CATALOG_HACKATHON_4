import java.util.Scanner;
import java.util.Random;

public class security {

    // Sample data
    private static final String upassword = "alien123";
    private static final String question = "What is your pet's name?";
    private static final String sanswer = "jaadu";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Level 1: Textual Password Authentication
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        if (!password.equals(upassword)) {
            System.out.println("Authentication failed. Incorrect password.");
            return;
        }
        System.out.println("Password verified.");

        // Level 2: Security Question Authentication
        System.out.println("Security Question: " + question);
        System.out.print("Answer: ");
        String answer = scanner.nextLine();
        if (!answer.equalsIgnoreCase(sanswer)) {
            System.out.println("Authentication failed. Incorrect answer.");
            return;
        }
        System.out.println("Security question verified.");

        // Level 3: OTP (One-Time Passcode) Authentication
        String otp = generateOTP();
        System.out.println("OTP has been sent to your registered device: " + otp);
        System.out.print("Enter the OTP: ");
        String userOtp = scanner.nextLine();
        if (!userOtp.equals(otp)) {
            System.out.println("Authentication failed. Incorrect OTP.");
            return;
        }
        System.out.println("OTP verified.");

        // If all levels pass
        System.out.println("Authentication successful! Access granted.");
    }

    // Function to generate a simple 4-digit OTP
    private static String generateOTP() {
        Random random = new Random();
        int otp = 1000 + random.nextInt(9000); // Generates a 4-digit number
        return String.valueOf(otp);
    }
}
