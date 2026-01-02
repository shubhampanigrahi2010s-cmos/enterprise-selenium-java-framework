package day5.oop_part1;
// Class demonstrating encapsulation using getters and setters
public class TestCredentials {
    // Private instance variables - cannot be accessed directly from outside
    // This is the core principle of encapsulation - hiding internal data
    private String username;
    private String password;
    private String environment;
    private boolean isActive;

    // Constructor to initialize credentials
    public TestCredentials(String username, String password, String environment) {
        // Using setters to apply validation even during object creation
        this.setUsername(username);
        this.setPassword(password);
        this.setEnvironment(environment);
        this.isActive = true;
    }

    // Getter method for username - provides READ access to private variable
    // Convention: get + VariableName (camelCase)
    public String getUsername() {
        // Can add logic before returning value (logging, formatting, etc.)
        return this.username;
    }

    // Setter method for username - provides WRITE access with validation
    // Convention: set + VariableName (camelCase)
    public void setUsername(String username) {
        // Validation: username should not be null or empty
        if (username != null && !username.trim().isEmpty()) {
            this.username = username;
        } else {
            System.out.println("Error: Username cannot be empty");
            this.username = "default_user";
        }
    }

    // Getter for password
    public String getPassword() {
        // For security, you might return masked password
        return "****"; // Not returning actual password
    }

    // Setter for password with validation
    public void setPassword(String password) {
        // Validation: password must be at least 8 characters
        if (password != null && password.length() >= 8) {
            this.password = password;
            System.out.println("Password updated successfully");
        } else {
            System.out.println("Error: Password must be at least 8 characters");
        }
    }

    // Getter for environment
    public String getEnvironment() {
        // Converting to uppercase before returning
        return this.environment.toUpperCase();
    }

    // Setter for environment with validation
    public void setEnvironment(String environment) {
        // Validation: only allow specific environments
        if (environment.equalsIgnoreCase("DEV") ||
                environment.equalsIgnoreCase("QA") ||
                environment.equalsIgnoreCase("PROD")) {
            this.environment = environment;
        } else {
            System.out.println("Error: Invalid environment. Defaulting to QA");
            this.environment = "QA";
        }
    }

    // Getter for isActive - for boolean, convention is 'is' instead of 'get'
    public boolean isActive() {
        return this.isActive;
    }

    // Setter for isActive
    public void setActive(boolean isActive) {
        this.isActive = isActive;
        // Adding side effect - logging status change
        System.out.println("Credential status changed to: " +
                (isActive ? "Active" : "Inactive"));
    }

    // Method to display credentials (without exposing password)
    public void displayCredentials() {
        System.out.println("Username: " + getUsername());
        System.out.println("Password: " + getPassword()); // Will show masked
        System.out.println("Environment: " + getEnvironment());
        System.out.println("Status: " + (isActive() ? "Active" : "Inactive"));
    }

    // Main method to demonstrate encapsulation
    public static void main(String[] args) {
        // Creating object with valid data
        TestCredentials creds = new TestCredentials("testuser", "password123", "qa");

        System.out.println("=== Initial Credentials ===");
        creds.displayCredentials();

        System.out.println("\n=== Testing Setters with Validation ===");

        // Trying to set empty username - validation will prevent it
        creds.setUsername("");

        // Trying to set short password - validation will prevent it
        creds.setPassword("123");

        // Setting valid password
        creds.setPassword("newSecure123");

        // Trying to set invalid environment
        creds.setEnvironment("STAGING");

        // Setting valid environment
        creds.setEnvironment("PROD");

        // Changing active status
        creds.setActive(false);

        System.out.println("\n=== Updated Credentials ===");
        creds.displayCredentials();

        // CANNOT access private variables directly - would give compilation error
        // System.out.println(creds.password); // This would cause error

        // Must use getter method to access private variables
        System.out.println("\nAccessing via getter: " + creds.getUsername());
    }
}
