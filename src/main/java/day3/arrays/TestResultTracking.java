package day3.arrays;
import java.util.ArrayList;

public class TestResultTracking {
    public static void main(String[] args) {

        // ========== Tracking Test Execution Results ==========

        ArrayList<String> testNames = new ArrayList<>();
        ArrayList<String> testResults = new ArrayList<>();

        // Test 1
        testNames.add("Login Test");
        testResults.add("PASS");

        // Test 2
        testNames.add("Add to Cart Test");
        testResults.add("PASS");

        // Test 3
        testNames.add("Payment Test");
        testResults.add("FAIL");

        // Test 4
        testNames.add("Logout Test");
        testResults.add("PASS");

        // Test 5
        testNames.add("Search Test");
        testResults.add("FAIL");


        // ========== Generate Test Report ==========
        System.out.println("========================================");
        System.out.println("        TEST EXECUTION REPORT          ");
        System.out.println("========================================\n");

        int passCount = 0; // Counter for passed tests
        int failCount = 0; // Counter for failed tests

        // Loop through all tests
        for (int i = 0; i < testNames.size(); i++) {
            String name = testNames.get(i);
            String result = testResults.get(i);

            // Print test result
            System.out.println((i + 1) + ". " + name + " - " + result);

            // Count pass/fail
            if (result.equals("PASS")) {
                passCount++; // Increment pass counter
            } else {
                failCount++; // Increment fail counter
            }
        }

        // Print summary
        System.out.println("\n========================================");
        System.out.println("Total Tests: " + testNames.size());
        System.out.println("Passed: " + passCount);
        System.out.println("Failed: " + failCount);
        System.out.println("Pass Rate: " + (passCount * 100 / testNames.size()) + "%");
        System.out.println("========================================");


        // ========== List Only Failed Tests ==========
        System.out.println("\n=== Failed Tests (Need Attention) ===");

        for (int i = 0; i < testResults.size(); i++) {
            if (testResults.get(i).equals("FAIL")) {
                System.out.println("⚠ " + testNames.get(i));
            }
        }
    }
}
