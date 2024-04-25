/**
 * This class is used to encapsulate information about insured individual.
 */
class Insured {
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;

    /**
     * Class constructor that takes variables as parameters and initializes the corresponding attributes.
     * @param firstName Stores the first name of the insured individual
     * @param lastName Stores the last name of the insured individual
     * @param age Stores the age of the insured individual
     * @param phoneNumber Stores the phone number of the insured individual
     */
    public Insured(String firstName, String lastName, int age, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter method to retrieve first name of the insured individual.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter method to retrieve last name of the insured individual.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter method to retrieve age of the insured individual.
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter method to retrieve phone number of the insured individual.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Overrides toString() method to create a string representation of this object.
     * @Returns display of information about insured individual in a way us fellow humans can read
     */
    @Override
    public String toString() {
        return "First Name: " + firstName + ", Last Name: " + lastName + ", Age: " + age + ", Phone Number: " + phoneNumber;
    }
}
