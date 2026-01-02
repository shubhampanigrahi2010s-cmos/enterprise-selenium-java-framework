package day5.oop_part1;
// Class demonstrating constructors
public class User {
    // Instance variables to store user information
    String username;
    String password;
    String email;

    // Default constructor (no parameters) - called when object created without arguments
    public User() {
        // Setting default values for all instance variables
        this.username = "guest";
        this.password = "guest123";
        this.email = "guest@example.com";
        System.out.println("Default constructor called - Guest user created");
    }

    // Parameterized constructor (with parameters) - allows custom values during object creation
    public User(String username, String password) {
        // 'this.username' refers to instance variable, 'username' refers to parameter
        // 'this' keyword differentiates between instance variable and parameter with same name
        this.username = username;
        this.password = password;
        this.email = username + "@test.com";
        System.out.println("Parameterized constructor called - User created: " + username);
    }

    // Another parameterized constructor with all three parameters (Constructor Overloading)
    public User(String username, String password, String email) {
        // Using 'this' to refer to current object's instance variables
        this.username = username;
        this.password = password;
        this.email = email;
        System.out.println("Full constructor called - Complete user profile created");
    }

    // Method to display user information
    public void displayInfo() {
        // 'this' is optional here but makes it clear we're accessing instance variables
        System.out.println("Username: " + this.username);
        System.out.println("Email: " + this.email);
        // Not printing password for security reasons
    }

    // Main method to test User class
    public static void main(String[] args) {
        // Creating object using default constructor
        User guestUser = new User();
        guestUser.displayInfo();

        System.out.println("\n---");

        // Creating object using parameterized constructor with 2 parameters
        User testUser = new User("john_doe", "secure123");
        testUser.displayInfo();

        System.out.println("\n---");

        // Creating object using parameterized constructor with 3 parameters
        User adminUser = new User("admin", "admin@123", "admin@company.com");
        adminUser.displayInfo();
    }
}
