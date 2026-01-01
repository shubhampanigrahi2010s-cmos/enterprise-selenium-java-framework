package day3.arrays;
public class ArrayTraversal {
    public static void main(String[] args) {

        // Test data array
        String[] testCases = {"Login Test", "Logout Test", "Add to Cart", "Checkout", "Payment"};


        // ========== Method 1: Using traditional for loop ==========
        System.out.println("=== Executing Test Cases ===");

        // Loop from index 0 to length-1
        for (int i = 0; i < testCases.length; i++) {
            // i = 0: testCases[0] = "Login Test"
            // i = 1: testCases[1] = "Logout Test"
            // ... and so on until i = 4

            System.out.println("Executing: " + testCases[i]);
            // Output will be:
            // Executing: Login Test
            // Executing: Logout Test
            // Executing: Add to Cart
            // Executing: Checkout
            // Executing: Payment
        }


        // ========== Method 2: Enhanced for loop (for-each) ==========
        System.out.println("\n=== Test Results ===");

        // Syntax: for (dataType variableName : arrayName)
        for (String testCase : testCases) {
            // In each iteration, 'testCase' holds one element from the array
            // First iteration: testCase = "Login Test"
            // Second iteration: testCase = "Logout Test"
            // ... continues for all elements

            System.out.println(testCase + " - PASSED");
            // Output:
            // Login Test - PASSED
            // Logout Test - PASSED
            // ... and so on
        }


        // ========== Practical Example: Finding specific element ==========
        String searchTest = "Checkout";
        boolean found = false; // Flag to track if we found the test

        for (int i = 0; i < testCases.length; i++) {
            if (testCases[i].equals(searchTest)) { // Compare strings using .equals()
                System.out.println("\n'" + searchTest + "' found at index: " + i);
                found = true; // Set flag to true
                break; // Exit loop once found (optimization)
            }
        }

        if (!found) { // If found is still false
            System.out.println(searchTest + " not found in test suite");
        }
    }
}