import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Insured> insuredList = new ArrayList<>();
        InsuranceManager insuranceManager = new InsuranceManager(insuredList);
        UserInterface userInterface = new UserInterface(insuranceManager);

        String choice = "";

        while (!choice.equals("6")) {
            userInterface.displayMenu();
            choice = ScannerUtils.scanner.nextLine();

            switch (choice) {
                case "1":
                    userInterface.promptForCreateInsured();
                    break;
                case "2":
                    insuranceManager.displayInsuredList();
                    break;
                case "3":
                    userInterface.promptForFindInsured();
                    break;
                case "4":
                    userInterface.promptForFindInsuredByPhoneNumber();
                    break;
                case "5":
                    userInterface.promptForDeleteInsured();
                    break;
                case "6":
                    System.out.println("\nEnd of program.");
                    break;
                default:
                    System.out.println("\nInvalid input. Try again.");
                    ScannerUtils.waitForEnter();
                    break;
            }
        }
    }
}
