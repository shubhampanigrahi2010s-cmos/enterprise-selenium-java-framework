package day3.arrays;
import java.util.ArrayList;

public class ArrayListTraversal {
    public static void main(String[] args) {

        // Creating ArrayList with test case names
        ArrayList<String> testCases = new ArrayList<>();
        testCases.add("Verify Login");
        testCases.add("Verify Logout");
        testCases.add("Add to Cart");
        testCases.add("Remove from Cart");
        testCases.add("Checkout Process");


        // ========== Method 1: Traditional for loop ==========
        System.out.println("=== Method 1: Traditional For Loop ===");

        for (int i = 0; i < testCases.size(); i++) {
            // i starts at 0, continues while i < size (5), increments by 1

            String testName = testCases.get(i); // Get element at index i
            System.out.println("Test " + (i + 1) + ": " + testName);
            // Output:
            // Test 1: Verify Login
            // Test 2: Verify Logout
            // ... and so on
        }


        // ========== Method 2: Enhanced for loop (for-each) ==========
        System.out.println("\n=== Method 2: Enhanced For Loop ===");

        for (String test : testCases) {
            // In each iteration, 'test' holds one element from the list
            // No need to use index or get() method

            System.out.println("Executing: " + test);
        }


        // ========== Method 3: forEach with Lambda (Java 8+) ==========
        System.out.println("\n=== Method 3: forEach Method ===");

        testCases.forEach(test -> {
            // Lambda expression: (parameter) -> { action }
            // For each element in testCases, execute this code block

            System.out.println("Running: " + test);
        });


        // ========== Practical Example: Filtering and Processing ==========
        System.out.println("\n=== Filtering Cart Related Tests ===");

        for (String test : testCases) {
            // Check if test name contains "Cart"
            if (test.contains("Cart")) {
                System.out.println("Cart Test Found: " + test);
            }
        }
        // Output:
        // Cart Test Found: Add to Cart
        // Cart Test Found: Remove from Cart
    }
}
