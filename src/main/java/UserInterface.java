/**
 * This class serves as the user interface for interacting with the 'InsuranceManager' class.
 * Basically manages the flow of user interaction with the insurance system.
 */
public class UserInterface {
    private final InsuranceManager insuranceManager;

    /**
     * This performs an intermediary between the user and InsuranceManager class,
     * providing a structured way for the user to interact with the system.
     */
    public UserInterface(InsuranceManager insuranceManager) {
        this.insuranceManager = insuranceManager;
    }

    /**
     * Prompts the user for input and delegates the creation of a new insured individual to the InsuranceManager.
     */
    public void promptForCreateInsured() {
        String setFirstName = promptForNonEmptyInput("First name:");
        String setLastName = promptForNonEmptyInput("Last name:");
        int setAge = promptForNonNegativeInteger("Age:");
        String setPhoneNumber = promptForNonEmptyInput("Phone Number:");

        insuranceManager.createInsured(setFirstName, setLastName, setAge, setPhoneNumber);
    }

    /**
     * Handles the search for individual within the list by name and last name.
     * Prompts the user for input and delegates to the InsuranceManager.
     */
    public void promptForFindInsured() {
        String searchForFirstName = promptForInput("First name:");
        String searchForLastName = promptForInput("Last name:");
        insuranceManager.findInsured(searchForFirstName, searchForLastName);
    }

    /**
     * Handles the search for individual within the list by phone number.
     * Prompts the user for input and delegates to the InsuranceManager.
     */
    public void promptForFindInsuredByPhoneNumber() {
        String searchForPhoneNumber = promptForInput("Phone Number:");
        insuranceManager.findInsuredByPhoneNumber(searchForPhoneNumber);
    }

    /**
     * Handles the deletion of an individual from the list by name, last name and age.
     * Prompts the user for input and delegates to the InsuranceManager.
     */
    public void promptForDeleteInsured() {
        String deleteFirstName = promptForNonEmptyInput("First name:");
        String deleteLastName = promptForNonEmptyInput("Last name:");
        insuranceManager.deleteInsured(deleteFirstName, deleteLastName);
    }

    /**
     * Simple and quick method to print a message and returns user input.
     * @return User input
     */
    private String promptForInput(String message) {
        System.out.println(message);
        return ScannerUtils.scanner.nextLine();
    }

    /**
     * Repeatedly prompts user until non-empty input is provided.
     */
    private String promptForNonEmptyInput(String message) {
        boolean inputIsEmpty = true;
        String input = "";

        while (inputIsEmpty) {
            input = promptForInput(message);
            if (!input.isEmpty()) {
                inputIsEmpty = false;
            } else {
                System.out.println("Input must not be empty.");
            }
        }

        return input;
    }

    /**
     * Repeatedly prompts user until a non-negative integer input is provided.
     */
    private int promptForNonNegativeInteger(String message) {
        boolean inputIsValid = true;
        int value = 0;

        while (inputIsValid) {
            String input = promptForInput(message);

            try {
                value = Integer.parseInt(input);

                if (value >= 0) {
                    inputIsValid = false;
                } else {
                    System.out.println("Value must be non-negative!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer!");
            }
        }

        return value;
    }

    /**
     * Displays the main menu.
     */
    public void displayMenu() {
        System.out.println("----------------------------");
        System.out.println("    Insurance Manager");
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("Choose your action:");
        System.out.println("1 - Create new insured");
        System.out.println("2 - Show all insured");
        System.out.println("3 - Find insured by name");
        System.out.println("4 - Find insured by phone number");
        System.out.println("5 - Remove insured");
        System.out.println("6 - End");
    }
}
