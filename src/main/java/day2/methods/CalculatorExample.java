package day2.methods;

public class CalculatorExample {

    // ========== 1. SIMPLE VOID METHOD (NO RETURN) ==========
    /**
     * Method without return type
     * void means this method doesn't return any value
     * When method completes, it simply ends without sending back any data
     */
    public void displayWelcomeMessage() {
        System.out.println("Welcome to Java Calculator!");
        System.out.println("============================");
        // No return statement needed for void methods
    }

    // ========== 2. METHOD WITH RETURN TYPE ==========
    /**
     * Method that returns a value
     * int is the return type - this method MUST return an integer value
     * Parameters: firstNumber and secondNumber are the inputs this method receives
     * When you call this method, you can store or use the returned value
     */
    public int addNumbers(int firstNumber, int secondNumber) {
        int result = firstNumber + secondNumber;  // Calculate sum
        return result;  // Returning the result back to whoever called this method
        // Any code after return statement will never execute
    }

    // ========== 3. METHOD OVERLOADING ==========
    /**
     * Method Overloading: Same method name, different parameters
     * This one takes THREE parameters instead of TWO
     * Java determines which method to call based on number/type of arguments
     * Return type alone is NOT enough to overload methods
     */
    public int addNumbers(int firstNumber, int secondNumber, int thirdNumber) {
        // Notice same method name "addNumbers" but different parameter count
        return firstNumber + secondNumber + thirdNumber;
    }

    // ========== 4. METHOD WITH DIFFERENT RETURN TYPE ==========
    /**
     * Returns double instead of int for decimal precision
     * double allows fractional values like 3.333...
     * Parameters are also double to accept decimal inputs
     */
    public double divideNumbers(double dividend, double divisor) {
        // Check for division by zero to avoid errors
        if (divisor == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return 0.0;  // Return default value in error case
        }
        return dividend / divisor;  // Returns decimal result
    }

    // ========== 5. METHOD WITHOUT PARAMETERS ==========
    /**
     * Method that takes no parameters (empty parentheses)
     * Still needs parentheses () even with no parameters
     * Useful for methods that always do the same thing
     */
    public int getFixedNumber() {
        return 100;  // Always returns the same value
    }

    // ========== 6. METHOD WITH RETURN VALUE DIRECTLY ==========
    /**
     * You can return values directly without storing in variable first
     * More concise code when you don't need intermediate variable
     */
    public int multiplyNumbers(int a, int b) {
        return a * b;  // Direct return without intermediate variable
    }

    // ========== 7. METHOD THAT CALLS OTHER METHODS ==========
    /**
     * Methods can call other methods from the same class
     * This promotes code reusability and modularity
     * void because we're just displaying, not returning anything
     */
    public void performCalculations() {
        // Calling other methods and using their return values
        System.out.println("Addition of 5 and 3: " + addNumbers(5, 3));
        System.out.println("Addition of 1, 2 and 3: " + addNumbers(1, 2, 3));
        System.out.println("Division of 10 by 3: " + divideNumbers(10, 3));
        System.out.println("Multiplication of 6 and 7: " + multiplyNumbers(6, 7));
    }

    // ========== 8. METHOD WITH MULTIPLE RETURN STATEMENTS ==========
    /**
     * Methods can have multiple return statements
     * Execution stops at the first return reached
     * Useful for conditional logic
     */
    public String compareNumbers(int num1, int num2) {
        if (num1 > num2) {
            return num1 + " is greater";  // Returns here if condition true
        } else if (num1 < num2) {
            return num2 + " is greater";  // Returns here if this condition true
        } else {
            return "Both are equal";  // Returns here if both conditions false
        }
        // No code after these returns will execute
    }

    // ========== 9. METHOD WITH STRING RETURN TYPE ==========
    /**
     * Methods can return any data type, including String
     * String is a reference type (object), not primitive
     */
    public String getCalculatorInfo() {
        return "This is a simple calculator program";
    }

    // ========== 10. STATIC METHOD ==========
    /**
     * static keyword: This method belongs to the CLASS, not to objects
     * Can be called WITHOUT creating an object: ClassName.methodName()
     * Cannot access instance variables directly (non-static fields)
     * Useful for utility methods that don't need object state
     */
    public static void displayProgramInfo() {
        System.out.println("=== Calculator Program v1.0 ===");
        System.out.println("Demonstrates Java Methods");
        // Note: Cannot access instance methods directly from static methods
    }

    // ========== MAIN METHOD ==========
    /**
     * main method is the entry point of Java program
     * public: accessible from anywhere
     * static: can be called without creating object
     * void: doesn't return anything
     * String[] args: command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== CALCULATOR EXAMPLE OUTPUT ===\n");

        // Call static method directly without creating object
        CalculatorExample.displayProgramInfo();
        System.out.println();

        // Step 1: Create an object of CalculatorExample class
        // 'new' keyword creates a new instance (object) in memory
        CalculatorExample calculator = new CalculatorExample();

        // Step 2: Call void method (no return value)
        calculator.displayWelcomeMessage();
        System.out.println();

        // Step 3: Call method with return value and STORE result
        int sum = calculator.addNumbers(10, 20);  // 30 is stored in sum
        System.out.println("Sum of 10 and 20: " + sum);

        // Step 4: Call method and USE result directly without storing
        System.out.println("Sum of 7 and 8: " + calculator.addNumbers(7, 8));

        // Step 5: Call overloaded method (same name, different parameters)
        int tripleSum = calculator.addNumbers(1, 2, 3);  // Calls 3-parameter version
        System.out.println("Sum of 1, 2 and 3: " + tripleSum);
        System.out.println();

        // Step 6: Call method with different return type (double)
        double quotient = calculator.divideNumbers(15, 4);
        System.out.println("15 divided by 4: " + quotient);

        // Step 7: Test division by zero handling
        System.out.print("10 divided by 0: ");
        double invalidResult = calculator.divideNumbers(10, 0);
        System.out.println("Result: " + invalidResult);
        System.out.println();

        // Step 8: Call method without parameters
        int fixedValue = calculator.getFixedNumber();
        System.out.println("Fixed value: " + fixedValue);

        // Step 9: Test multiplication
        int product = calculator.multiplyNumbers(8, 9);
        System.out.println("8 multiplied by 9: " + product);
        System.out.println();

        // Step 10: Call method that uses other methods internally
        System.out.println("=== Performing Multiple Calculations ===");
        calculator.performCalculations();
        System.out.println();

        // Step 11: Use method with multiple return statements
        String comparison1 = calculator.compareNumbers(15, 10);
        System.out.println("Comparing 15 and 10: " + comparison1);

        String comparison2 = calculator.compareNumbers(5, 20);
        System.out.println("Comparing 5 and 20: " + comparison2);

        String comparison3 = calculator.compareNumbers(7, 7);
        System.out.println("Comparing 7 and 7: " + comparison3);
        System.out.println();

        // Step 12: Use method returning String
        System.out.println(calculator.getCalculatorInfo());

        System.out.println("\n=== END OF CALCULATOR EXAMPLE ===");
    }
}