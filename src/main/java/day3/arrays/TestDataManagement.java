package day3.arrays;
import java.util.ArrayList;

public class TestDataManagement {
    public static void main(String[] args) {

        // ========== Scenario: Data-Driven Testing ==========
        // We have multiple users to test login functionality

        // Using ArrayList for usernames (dynamic size)
        ArrayList<String> usernames = new ArrayList<>();
        usernames.add("john@test.com");
        usernames.add("sarah@test.com");
        usernames.add("mike@test.com");
        usernames.add("admin@test.com");

        // Using ArrayList for passwords
        ArrayList<String> passwords = new ArrayList<>();
        passwords.add("john123");
        passwords.add("sarah456");
        passwords.add("mike789");
        passwords.add("admin999");


        // ========== Simulating Login Tests ==========
        System.out.println("=== Executing Login Tests ===\n");

        // Loop through all users
        for (int i = 0; i < usernames.size(); i++) {
            // Get username and password at same index
            String user = usernames.get(i);
            String pass = passwords.get(i);

            // Simulate test execution
            System.out.println("Test " + (i + 1) + ":");
            System.out.println("  Navigating to login page...");
            System.out.println("  Entering username: " + user);
            System.out.println("  Entering password: " + pass);
            System.out.println("  Clicking login button...");
            System.out.println("  ✓ Login successful for " + user);
            System.out.println();
        }


        // ========== Finding Specific User ==========
        System.out.println("=== Searching for Admin User ===");

        String searchUser = "admin@test.com";

        if (usernames.contains(searchUser)) {
            // Get the index of admin user
            int adminIndex = usernames.indexOf(searchUser);

            System.out.println("Admin user found!");
            System.out.println("Username: " + usernames.get(adminIndex));
            System.out.println("Password: " + passwords.get(adminIndex));
        } else {
            System.out.println("Admin user not found in test data");
        }


        // ========== Adding New Test User Dynamically ==========
        System.out.println("\n=== Adding New Test User ===");

        // New user needs to be tested
        usernames.add("guest@test.com");
        passwords.add("guest123");

        System.out.println("Total users now: " + usernames.size()); // Output: 5
        System.out.println("Last user: " + usernames.get(usernames.size() - 1));
    }
}