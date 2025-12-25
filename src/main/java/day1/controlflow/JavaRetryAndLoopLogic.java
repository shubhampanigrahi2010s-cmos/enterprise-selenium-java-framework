package day1.controlflow;

/**
 * JavaRetryAndLoopLogic - Day 1: Loop Control Structures
 * Demonstrates while loops and for loops in test retry scenarios
 */
public class JavaRetryAndLoopLogic {

    public static void main(String[] args) {

        // ========== RETRY CONFIGURATION ==========

        // Maximum number of retry attempts allowed before marking test as failed
        int maxRetries = 3;

        // Counter to track current retry attempt (starts at 0)
        int retryCount = 0;

        // Flag to indicate if test has passed (initially false)
        boolean testPassed = false;

        // ========== WHILE LOOP: RETRY LOGIC ==========
        // While loop continues executing as long as BOTH conditions are true:
        // 1. retryCount < maxRetries (haven't exhausted retry attempts)
        // 2. !testPassed (test hasn't passed yet - ! is NOT operator)

        while (retryCount < maxRetries && !testPassed) {
            // Display current retry attempt (add 1 for human-readable count: 1, 2, 3)
            System.out.println("Executing retry attempt: " + (retryCount + 1));

            // Increment retry counter after each attempt
            retryCount++;

            // ========== SIMULATED TEST EXECUTION ==========
            // Simulate a flaky test that passes on the 2nd attempt
            // In real automation, this would be actual test logic
            if (retryCount == 2) {
                testPassed = true;
                System.out.println("Test passed on retry " + retryCount);
            }
            // Note: If retryCount != 2, loop continues to next iteration
        }
        // Loop exits when either:
        // - testPassed becomes true (test succeeded)
        // - retryCount reaches maxRetries (exhausted all attempts)

        // ========== FINAL RESULT CHECK ==========
        // After loop completes, check if test ultimately failed
        if (!testPassed) {
            System.out.println("Test failed after all retries");
        }
        // If testPassed is true, no message needed (already printed in loop)

        // ========== FOR LOOP: FIXED ITERATIONS ==========
        // For loop executes a known number of times (unlike while loop)
        // Syntax: for (initialization; condition; increment)
        // - int i = 1: Start counter at 1
        // - i <= 3: Continue while i is less than or equal to 3
        // - i++: Increment i by 1 after each iteration

        for (int i = 1; i <= 3; i++) {
            // Simulate running a test suite multiple times
            System.out.println("Simulated test execution run: " + i);
        }
        // Loop executes exactly 3 times: i=1, i=2, i=3, then stops

        // ========== COMPLETION MESSAGE ==========
        System.out.println("Day 1 - Retry & Loop logic completed");
    }
}