package day3.arrays;
public class ArrayBasics {
    public static void main(String[] args) {

        // Method 1: Declare and initialize array separately
        String[] browsers; // Declaration - creating a reference variable
        browsers = new String[3]; // Initialization - allocating memory for 3 elements

        // Assigning values to array elements (index starts from 0)
        browsers[0] = "Chrome"; // First element at index 0
        browsers[1] = "Firefox"; // Second element at index 1
        browsers[2] = "Edge"; // Third element at index 2

        // Accessing array elements
        System.out.println("First browser: " + browsers[0]); // Output: Chrome
        System.out.println("Second browser: " + browsers[1]); // Output: Firefox


        // Method 2: Declare and initialize in one line
        String[] testData = {"user1", "user2", "user3"}; // Array literal - size is automatically 3

        // Getting array length (total number of elements)
        System.out.println("Total browsers: " + browsers.length); // Output: 3
        System.out.println("Total test users: " + testData.length); // Output: 3


        // Method 3: Integer array example
        int[] testPriorities = new int[4]; // Creates array with 4 elements, all initialized to 0
        testPriorities[0] = 1; // High priority
        testPriorities[1] = 2; // Medium priority
        testPriorities[2] = 3; // Low priority
        testPriorities[3] = 1; // High priority

        System.out.println("First test priority: " + testPriorities[0]); // Output: 1
    }
}
