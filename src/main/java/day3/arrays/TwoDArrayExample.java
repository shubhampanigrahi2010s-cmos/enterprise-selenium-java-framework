package day3.arrays;
public class TwoDArrayExample {
    public static void main(String[] args) {

        // 2D Array = Array of Arrays = Table/Matrix structure
        // Useful for: Test data with multiple fields, multi-user scenarios

        // Creating a 2D array: [rows][columns]
        String[][] loginData = new String[3][2];
        // This creates 3 rows and 2 columns
        // Row 0: [username, password]
        // Row 1: [username, password]
        // Row 2: [username, password]


        // Filling the array - Row 0
        loginData[0][0] = "user1@test.com"; // Row 0, Column 0 (username)
        loginData[0][1] = "pass123"; // Row 0, Column 1 (password)

        // Filling the array - Row 1
        loginData[1][0] = "user2@test.com";
        loginData[1][1] = "pass456";

        // Filling the array - Row 2
        loginData[2][0] = "admin@test.com";
        loginData[2][1] = "admin999";


        // ========== Method 2: Initialize 2D array directly ==========
        String[][] testUsers = {
                {"john@test.com", "john123"},     // Row 0
                {"sarah@test.com", "sarah456"},   // Row 1
                {"mike@test.com", "mike789"}      // Row 2
        };


        // ========== Accessing 2D Array Elements ==========
        System.out.println("=== Test User Credentials ===");

        // Access specific element
        System.out.println("First user email: " + testUsers[0][0]); // Output: john@test.com
        System.out.println("First user password: " + testUsers[0][1]); // Output: john123


        // ========== Traversing 2D Array with Nested Loops ==========
        System.out.println("\n=== All Login Credentials ===");

        // Outer loop: iterates through rows
        for (int row = 0; row < testUsers.length; row++) {
            // testUsers.length = 3 (total rows)

            System.out.print("User " + (row + 1) + ": "); // Print user number

            // Inner loop: iterates through columns in current row
            for (int col = 0; col < testUsers[row].length; col++) {
                // testUsers[row].length = 2 (columns in this row)

                System.out.print(testUsers[row][col]);

                if (col < testUsers[row].length - 1) { // If not the last column
                    System.out.print(" | "); // Separator between username and password
                }
            }
            System.out.println(); // New line after each row
        }
        // Output:
        // User 1: john@test.com | john123
        // User 2: sarah@test.com | sarah456
        // User 3: mike@test.com | mike789


        // ========== Enhanced for loop with 2D arrays ==========
        System.out.println("\n=== Login Attempts ===");

        int userNumber = 1; // Counter for display

        for (String[] user : testUsers) {
            // Each iteration: 'user' is a 1D array (one row)
            // First iteration: user = {"john@test.com", "john123"}

            String username = user[0]; // First element of the row
            String password = user[1]; // Second element of the row

            System.out.println("Attempting login for User " + userNumber);
            System.out.println("  Username: " + username);
            System.out.println("  Password: " + password);
            System.out.println("  Status: Login Successful\n");

            userNumber++; // Increment counter
        }
    }
}
