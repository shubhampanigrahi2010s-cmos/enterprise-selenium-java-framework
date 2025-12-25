package day1.controlflow;

/**
 * JavaVariablesAndConditions - Day 1: Control Flow Basics
 * Demonstrates variable declarations and conditional statements in automation context
 */
public class JavaVariablesAndConditions {

    public static void main(String[] args) {

        // ========== VARIABLE DECLARATIONS ==========
        // Variables store test configuration and execution data

        // String variable - stores test name for reporting
        String testName = "Login Test";

        // String variable - defines execution environment (DEV, QA, STAGING, PROD)
        String environment = "QA";

        // String variable - specifies browser for cross-browser testing
        String browser = "chrome";

        // int variable - maximum number of retry attempts for flaky tests
        int maxRetries = 3;

        // double variable - page load time in seconds (decimal precision needed)
        double pageLoadTime = 2.4;

        // boolean variable - flag indicating if test execution was successful
        boolean testPassed = true;

        // ========== CONSOLE OUTPUT ==========
        // Print test configuration details
        System.out.println("Test Name: " + testName);
        System.out.println("Environment: " + environment);
        System.out.println("Browser: " + browser);

        // ========== CONDITIONAL STATEMENTS ==========

        // Condition 1: Pass/Fail Decision
        // Check test result and display appropriate status message
        if (testPassed) {
            System.out.println("Test Status: PASS");
        } else {
            System.out.println("Test Status: FAIL");
        }

        // Condition 2: Performance Check
        // Validate page load time against acceptable threshold (3 seconds)
        if (pageLoadTime <= 3.0) {
            System.out.println("Performance is acceptable");
        } else {
            System.out.println("Performance issue detected");
        }

        // Condition 3: Environment Safety Check
        // Verify environment is safe for test execution
        // equalsIgnoreCase() performs case-insensitive string comparison
        boolean isProduction = environment.equalsIgnoreCase("prod");

        // Block test execution in production environment to prevent data corruption
        if (!isProduction) {
            // NOT operator (!) - execute only if NOT production
            System.out.println("Safe to execute tests in " + environment);
        } else {
            System.out.println("Execution blocked in PRODUCTION");
        }

        // ========== COMPLETION MESSAGE ==========
        System.out.println("Day 1 - Variables & Conditions completed");
    }
}