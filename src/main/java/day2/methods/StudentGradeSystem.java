package day2.methods;

/**
 * StudentGradeSystem.java
 *
 * This class demonstrates advanced Java method concepts:
 * - Instance variables (class fields)
 * - Getter and Setter methods
 * - Private helper methods
 * - Methods with validation
 * - Boolean return types
 * - Methods with control flow (if-else, switch)
 * - Static vs Instance methods
 * - Method chaining and reusability
 *
 * Compatible with JDK 17
 *
 * To run in IntelliJ IDEA:
 * 1. Create this file in src/day2/methods/ folder
 * 2. Right-click and select "Run 'StudentGradeSystem.main()'"
 */

public class StudentGradeSystem {

    // ========== INSTANCE VARIABLES (CLASS FIELDS) ==========
    /**
     * Instance variables belong to each object
     * These are accessible by all methods in this class
     * Each StudentGradeSystem object has its own copy of these variables
     */
    private String schoolName = "Sunshine Public School";  // private = only accessible in this class
    private int passingPercentage = 40;  // Minimum percentage to pass

    // ========== 1. METHOD WITH MULTIPLE PARAMETERS ==========
    /**
     * Calculates total marks from three subjects
     * Parameters: three separate integer values for each subject
     * Returns: integer value representing total marks
     */
    public int calculateTotal(int math, int science, int english) {
        int total = math + science + english;  // Add all three values
        return total;  // Send total back to caller
    }

    // ========== 2. METHOD RETURNING DOUBLE WITH CALCULATION ==========
    /**
     * Calculates percentage from marks
     * Notice: Uses another method (calculateTotal) inside this method
     * Demonstrates method chaining and reusability
     */
    public double calculatePercentage(int math, int science, int english) {
        int total = calculateTotal(math, science, english);  // Reusing existing method
        // Cast to double for decimal division: (total / 300.0) ensures decimal result
        double percentage = (total / 300.0) * 100;
        return percentage;  // Returns double value
    }

    // ========== 3. METHOD WITH IF-ELSE INSIDE ==========
    /**
     * Determines grade based on percentage
     * Returns: char data type (single character)
     * Demonstrates control flow (if-else) inside methods
     */
    public char calculateGrade(int math, int science, int english) {
        // Call another method to get percentage
        double percentage = calculatePercentage(math, science, english);

        // Multiple if-else conditions to determine grade
        if (percentage >= 90) {
            return 'A';  // Character literal in single quotes
        } else if (percentage >= 75) {
            return 'B';
        } else if (percentage >= 60) {
            return 'C';
        } else if (percentage >= 40) {
            return 'D';
        } else {
            return 'F';  // Fail grade
        }
        // Note: Only ONE return statement executes, then method ends
    }

    // ========== 4. VOID METHOD WITH MULTIPLE PARAMETERS ==========
    /**
     * Displays complete student report
     * void return type: performs actions but doesn't return value
     * Demonstrates mixing different parameter types (String and int)
     * This method coordinates multiple other methods
     */
    public void displayStudentReport(String studentName, int rollNumber,
                                     int math, int science, int english) {
        // Display header
        System.out.println("\n========================================");
        System.out.println("         STUDENT REPORT CARD");
        System.out.println("========================================");

        // Display student basic info (using parameters)
        System.out.println("Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("----------------------------------------");

        // Display individual subject marks
        System.out.println("Subject Marks:");
        System.out.println("  Math:    " + math + "/100");
        System.out.println("  Science: " + science + "/100");
        System.out.println("  English: " + english + "/100");
        System.out.println("----------------------------------------");

        // Call method to calculate and display total
        int total = calculateTotal(math, science, english);
        System.out.println("Total Marks: " + total + "/300");

        // Calculate and display percentage
        double percentage = calculatePercentage(math, science, english);
        System.out.printf("Percentage: %.2f%%\n", percentage);  // Format to 2 decimal places

        // Call method to calculate and display grade
        char grade = calculateGrade(math, science, english);
        System.out.println("Grade: " + grade);
        System.out.println("----------------------------------------");

        // Call private helper method (only accessible within this class)
        displayRemarks(grade);
        System.out.println("========================================");
    }

    // ========== 5. PRIVATE HELPER METHOD ==========
    /**
     * private keyword: This method can ONLY be called from inside this class
     * Not accessible from outside or from other classes
     * Useful for internal/helper methods that support public methods
     * Demonstrates switch-case inside a method
     */
    private void displayRemarks(char grade) {
        System.out.print("Remarks: ");

        // Switch statement to handle different grade cases
        switch(grade) {
            case 'A':
                System.out.println("Excellent! Keep it up!");
                break;  // break prevents fall-through to next case
            case 'B':
                System.out.println("Very Good! You can do better!");
                break;
            case 'C':
                System.out.println("Good! Need more practice.");
                break;
            case 'D':
                System.out.println("Pass. Need to work hard.");
                break;
            case 'F':
                System.out.println("Fail. Please try again.");
                break;
            default:
                System.out.println("Invalid grade");
                // default handles any unexpected values
        }
    }

    // ========== 6. METHOD THAT RETURNS BOOLEAN ==========
    /**
     * Returns boolean (true/false) value
     * Uses instance variable (passingPercentage) defined at class level
     * Demonstrates using class fields inside methods
     */
    public boolean isPassed(int math, int science, int english) {
        double percentage = calculatePercentage(math, science, english);
        // Returns true if percentage >= passing threshold, false otherwise
        return percentage >= passingPercentage;
    }

    // ========== 7. METHOD WITH VALIDATION ==========
    /**
     * Validates if marks are in acceptable range
     * Returns boolean indicating validity
     * Demonstrates input validation pattern
     */
    public boolean areMarksValid(int math, int science, int english) {
        // Check if any subject marks are negative or exceed 100
        if (math < 0 || math > 100) {
            System.out.println("Error: Math marks must be between 0 and 100!");
            return false;  // Invalid math marks
        }
        if (science < 0 || science > 100) {
            System.out.println("Error: Science marks must be between 0 and 100!");
            return false;  // Invalid science marks
        }
        if (english < 0 || english > 100) {
            System.out.println("Error: English marks must be between 0 and 100!");
            return false;  // Invalid english marks
        }
        return true;  // All marks are valid
    }

    // ========== 8. GETTER METHOD - ACCESSING INSTANCE VARIABLES ==========
    /**
     * Getter method: returns value of instance variable
     * Provides controlled access to private fields
     * void would be wrong here - we need to return the value
     */
    public String getSchoolName() {
        return schoolName;  // Accessing instance variable
    }

    // ========== 9. GETTER METHOD FOR PASSING PERCENTAGE ==========
    /**
     * Returns the current passing percentage threshold
     */
    public int getPassingPercentage() {
        return passingPercentage;
    }

    // ========== 10. SETTER METHOD - MODIFYING INSTANCE VARIABLES ==========
    /**
     * Setter method: changes value of instance variable
     * void because we're modifying, not returning anything
     * Provides controlled way to change private fields
     */
    public void setPassingPercentage(int newPercentage) {
        // Validate before setting (good practice)
        if (newPercentage >= 0 && newPercentage <= 100) {
            passingPercentage = newPercentage;  // Modify instance variable
            System.out.println("✓ Passing percentage updated to: " + newPercentage + "%");
        } else {
            System.out.println("✗ Invalid percentage! Must be between 0 and 100.");
        }
    }

    // ========== 11. METHOD WITH STRING CONCATENATION ==========
    /**
     * Returns formatted student summary
     * Demonstrates building strings inside methods
     */
    public String getStudentSummary(String name, int math, int science, int english) {
        int total = calculateTotal(math, science, english);
        char grade = calculateGrade(math, science, english);

        // Build and return formatted string
        return name + " scored " + total + "/300 (Grade: " + grade + ")";
    }

    // ========== 12. STATIC METHOD ==========
    /**
     * static keyword: This method belongs to the CLASS, not to objects
     * Can be called WITHOUT creating an object: ClassName.methodName()
     * Cannot access instance variables directly (non-static fields)
     * Useful for utility methods that don't need object state
     */
    public static void displaySystemHeader() {
        System.out.println("============================================");
        System.out.println("    STUDENT GRADE MANAGEMENT SYSTEM");
        System.out.println("         Sunshine Public School");
        System.out.println("============================================");
        // Note: Cannot use 'schoolName' instance variable here
        // Static methods can only access static variables
    }

    // ========== 13. STATIC UTILITY METHOD WITH PARAMETERS ==========
    /**
     * Static utility method that performs calculation
     * Doesn't need object because it doesn't use instance variables
     * Can be called directly with class name
     */
    public static double calculateAverage(int num1, int num2, int num3) {
        int total = num1 + num2 + num3;
        return total / 3.0;  // Return average as double
    }

    // ========== HELPER METHOD FOR PRINTING SEPARATOR ==========
    /**
     * Helper method to print separator line
     * Demonstrates simple utility method
     */
    private static void printSeparator() {
        System.out.println("============================================");
    }

    // ========== MAIN METHOD ==========
    /**
     * Entry point of the program
     * static: JVM can call it without creating object
     * void: doesn't return anything to JVM
     * main is a special method name that JVM looks for
     */
    public static void main(String[] args) {
        // Call static method directly with class name (no object needed)
        StudentGradeSystem.displaySystemHeader();
        System.out.println();

        // Create object to call instance methods
        // Instance methods need an object because they work with object's data
        StudentGradeSystem gradeSystem = new StudentGradeSystem();

        // Access instance variables through getter methods
        System.out.println("School: " + gradeSystem.getSchoolName());
        System.out.println("Current Passing Percentage: " + gradeSystem.getPassingPercentage() + "%");
        System.out.println();

        // ===== TEST CASE 1: EXCELLENT STUDENT =====
        System.out.println("--- Test Case 1: Excellent Student ---");

        // First validate marks
        boolean valid = gradeSystem.areMarksValid(95, 92, 88);
        if (valid) {
            gradeSystem.displayStudentReport("Alice Johnson", 101, 95, 92, 88);

            // Check pass/fail status
            boolean passed = gradeSystem.isPassed(95, 92, 88);
            System.out.println("Pass Status: " + (passed ? "✓ PASSED" : "✗ FAILED"));

            // Get summary
            String summary = gradeSystem.getStudentSummary("Alice Johnson", 95, 92, 88);
            System.out.println("Summary: " + summary);
        }

        System.out.println("\n");

        // ===== TEST CASE 2: AVERAGE STUDENT =====
        System.out.println("--- Test Case 2: Average Student ---");

        valid = gradeSystem.areMarksValid(68, 72, 65);
        if (valid) {
            gradeSystem.displayStudentReport("Bob Smith", 102, 68, 72, 65);

            boolean passed = gradeSystem.isPassed(68, 72, 65);
            System.out.println("Pass Status: " + (passed ? "✓ PASSED" : "✗ FAILED"));

            // Use static method to calculate average
            double avgMarks = StudentGradeSystem.calculateAverage(68, 72, 65);
            System.out.println("Average Marks: " + avgMarks);
        }

        System.out.println("\n");

        // ===== TEST CASE 3: FAILING STUDENT =====
        System.out.println("--- Test Case 3: Failing Student ---");

        valid = gradeSystem.areMarksValid(35, 40, 30);
        if (valid) {
            gradeSystem.displayStudentReport("Charlie Davis", 103, 35, 40, 30);

            boolean passed = gradeSystem.isPassed(35, 40, 30);
            System.out.println("Pass Status: " + (passed ? "✓ PASSED" : "✗ FAILED"));
        }

        System.out.println("\n");

        // ===== TEST CASE 4: INVALID MARKS =====
        System.out.println("--- Test Case 4: Invalid Marks ---");

        valid = gradeSystem.areMarksValid(85, 110, 88);  // 110 is invalid
        if (valid) {
            gradeSystem.displayStudentReport("Invalid Student", 104, 85, 110, 88);
        } else {
            System.out.println("Cannot generate report due to invalid marks.");
        }

        System.out.println("\n");

        // ===== TEST CASE 5: CHANGING PASSING CRITERIA =====
        System.out.println("--- Test Case 5: Changing Passing Criteria ---");
        System.out.println("Current passing percentage: " + gradeSystem.getPassingPercentage() + "%");

        // Change passing percentage
        gradeSystem.setPassingPercentage(50);

        // Test the same failing student with new criteria
        System.out.println("\nRetesting Charlie Davis with new 50% criteria:");
        boolean passedWithNewCriteria = gradeSystem.isPassed(35, 40, 30);
        double percentage = gradeSystem.calculatePercentage(35, 40, 30);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Pass Status: " + (passedWithNewCriteria ? "✓ PASSED" : "✗ FAILED"));

        // Try setting invalid percentage
        System.out.println("\nTrying to set invalid passing percentage:");
        gradeSystem.setPassingPercentage(150);  // Invalid

        System.out.println("\n");

        // ===== DIRECT CALCULATIONS DEMO =====
        System.out.println("--- Direct Method Calculations Demo ---");

        int totalMarks = gradeSystem.calculateTotal(80, 85, 90);
        System.out.println("Total of 80, 85, 90: " + totalMarks);

        double percent = gradeSystem.calculatePercentage(80, 85, 90);
        System.out.printf("Percentage: %.2f%%\n", percent);

        char grade = gradeSystem.calculateGrade(80, 85, 90);
        System.out.println("Grade: " + grade);

        System.out.println();
        printSeparator();
        System.out.println("    END OF GRADE SYSTEM DEMONSTRATION");
        printSeparator();
    }
}