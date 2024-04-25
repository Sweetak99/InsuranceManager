import java.util.Scanner;

/**
 * This class is used to encapsulate the creation and usage of Scanner object just in one place,
 * therefore making it easier to manage and work with, while also making it easier to read
 */
public class ScannerUtils {
    public static Scanner scanner = new Scanner(System.in, "Windows-1250");

    /**
     * Private constructor so you cannot create instance of this class to preserve this as a utility
     */
    private ScannerUtils() {}

    /**
     * Method waits for user to press Enter before continuing.
     * Gives user the time to read the output.
     */
    public static void waitForEnter() {
        System.out.println("\nTo continue press Enter...");
        scanner.nextLine();
    }
}
