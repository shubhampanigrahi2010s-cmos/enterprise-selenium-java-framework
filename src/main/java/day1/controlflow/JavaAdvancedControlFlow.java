package day1.controlflow;

/**
 * JavaAdvancedControlFlow - Day 1: Advanced Control Flow Concepts
 * Demonstrates break, continue, nested conditions, and type casting in automation context
 */
public class JavaAdvancedControlFlow {

    public static void main(String[] args) {

        // ========== BREAK AND CONTINUE KEYWORDS ==========
        // Demonstrate loop control using break (exit loop) and continue (skip iteration)

        for (int i = 1; i <= 5; i++) {

            // ========== CONTINUE KEYWORD ==========
            // Skip current iteration and move to next one
            if (i == 2) {
                System.out.println("Skipping iteration " + i);
                // continue jumps to next iteration immediately
                // Code below this line won't execute for i=2
                continue;
            }

            // ========== BREAK KEYWORD ==========
            // Exit the entire loop immediately
            if (i == 4) {
                System.out.println("Critical issue at iteration " + i);
                // break terminates the loop completely
                // No further iterations will execute (i=5 won't run)
                break;
            }

            // This line only executes for i=1, i=3
            // i=2 is skipped by continue
            // i=4 triggers break (line doesn't execute)
            // i=5 never runs because loop was terminated at i=4
            System.out.println("Processing iteration " + i);
        }

        /* Expected Output:
         * Processing iteration 1
         * Skipping iteration 2
         * Processing iteration 3
         * Critical issue at iteration 4
         */

        // ========== NESTED CONDITIONS ==========
        // Multiple levels of if statements for complex decision making
        // Common in Selenium WebDriver when checking element state

        // Flags representing web element state
        boolean elementVisible = true;   // Element is displayed on page
        boolean elementEnabled = false;  // Element is disabled (grayed out)

        // Outer condition: Check visibility first
        if (elementVisible) {
            // Inner condition: Only checked if outer condition is true
            if (elementEnabled) {
                // Element must be BOTH visible AND enabled to reach here
                System.out.println("Element is ready for interaction");
            } else {
                // Element is visible but NOT enabled
                System.out.println("Element visible but disabled");
            }
        } else {
            // Element is not visible at all
            // Inner condition never checked if outer is false
            System.out.println("Element not visible");
        }

        /* Logical flow:
         * elementVisible = true, elementEnabled = false
         * → Output: "Element visible but disabled"
         */

        // ========== TYPE CASTING AND CALCULATIONS ==========
        // Calculate test pass percentage with accurate decimal results

        int totalTests = 10;    // Total number of test cases
        int passedTests = 8;    // Number of tests that passed

        // Type casting: Convert int to double for accurate division
        // Without (double), result would be integer division (8/10 = 0)
        // With (double), result is decimal division (8.0/10.0 = 0.8)
        double passPercentage = (passedTests / (double) totalTests) * 100;

        /* Why type casting is needed:
         * passedTests / totalTests        → 8 / 10 = 0 (integer division, truncates)
         * passedTests / (double)totalTests → 8 / 10.0 = 0.8 (decimal division)
         * 0.8 * 100 = 80.0
         */

        System.out.println("Pass percentage: " + passPercentage + "%");

        // ========== COMPLETION MESSAGE ==========
        System.out.println("Day 1 - Advanced control flow completed");
    }
}
