import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to act as a manager for handling operations that are
 * related to the list of insured individuals.
 */
public class InsuranceManager {
    private List<Insured> insuredList;

    /**
     * Takes the 'List<Insurance>' as a @parameter and initializes insuredList.
     */
    public InsuranceManager(List<Insured> insuredList) {
        this.insuredList = insuredList;
    }

    /**
     * Creates a new 'Insurance' object (insured individual) with 4 parameters.
     * Adds the newly created object into insuredList
     * and then prints a message indicating that the insured individual has been created.
     * @param firstName First name
     * @param lastName Last name
     * @param age Age
     * @param phoneNumber Phone number
     */
    public void createInsured(String firstName, String lastName, int age, String phoneNumber) {
        Insured insured = new Insured(firstName, lastName, age, phoneNumber);
        insuredList.add(insured);
        System.out.println("\nInsured created: " + insured);
        ScannerUtils.waitForEnter();
    }

    /**
     * Prints the list of all insured individuals in a formatted manner.
     */
    public void displayInsuredList() {
        System.out.println("\nList of insured:");
        for (Insured insured : insuredList) {
            System.out.println(insured);
        }
        ScannerUtils.waitForEnter();
    }

    /**
     * Searches for an insured individual(s) within the list by comparing
     * the provided firstName and lastName with the objects in the list.
     * Prints afterwards if the individual has been found or not.
     */
    public void findInsured(String firstName, String lastName) {
        List<Insured> matchingInsured = new ArrayList<>();

        for (Insured insured : insuredList) {
            if (insured.getFirstName().equals(firstName) && insured.getLastName().equals(lastName)) {
                matchingInsured.add(insured);
            }
        }

        if (!matchingInsured.isEmpty()) {
            System.out.println("\nInsured found: " + firstName + " " + lastName);
            for (Insured insured : matchingInsured) {
                System.out.println(insured);
            }
        } else {
            System.out.println("\nInsured not found.");
        }

        ScannerUtils.waitForEnter();
    }

    /**
     * Searches for an insured individual within the list by comparing
     * the provided phone number with the objects in the list.
     * Prints afterwards if the individual has been found or not.
     */
    public void findInsuredByPhoneNumber(String phoneNumber) {
        for (Insured insured : insuredList) {
            if (insured.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("\nInsured found: " + insured);
                ScannerUtils.waitForEnter();
                return;
            }
        }
        System.out.println("\nInsured not found.");
        ScannerUtils.waitForEnter();
    }

    /**
     * Deletes an insured individual from the list that has the same credentials
     * as the user provided (firstName, lastName, age).
     * If the individual within the list was found, user is prompted for confirmation
     * before deleting the individual.
     * Prints message indicating that the individual was either deleted,
     * the deletion was canceled or the individual was not found.
     */
    public void deleteInsured(String firstName, String lastName) {
        Insured insuredToRemove = null;

        for (Insured insured : insuredList) {
            if (insured.getFirstName().equals(firstName) &&
                    insured.getLastName().equals(lastName)) {
                insuredToRemove = insured;
                break;
            }
        }

        if (insuredToRemove != null) {
            System.out.println("Insured found: " + insuredToRemove);
            System.out.println("Do you wish to remove this insured? (yes/no)");
            String confirmation = ScannerUtils.scanner.nextLine().toLowerCase();

            if (confirmation.equals("yes")) {
                insuredList.remove(insuredToRemove);
                System.out.println("\nInsured removed.");
                ScannerUtils.waitForEnter();
            } else if (confirmation.equals("no")) {
                System.out.println("\nInsured was not removed.");
                ScannerUtils.waitForEnter();
            } else {
                System.out.println("\nInvalid input. Action suspended.");
                ScannerUtils.waitForEnter();
            }
        } else {
            System.out.println("\nInsured not found.");
            ScannerUtils.waitForEnter();
        }
    }
}
