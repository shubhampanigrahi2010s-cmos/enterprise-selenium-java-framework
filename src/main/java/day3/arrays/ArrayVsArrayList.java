package day3.arrays;
import java.util.ArrayList;

public class ArrayVsArrayList {
    public static void main(String[] args) {

        System.out.println("=== ARRAY Example ===");

        // Array: Fixed size - must declare size upfront
        String[] browserArray = new String[3];
        browserArray[0] = "Chrome";
        browserArray[1] = "Firefox";
        browserArray[2] = "Edge";

        // Cannot add more elements - size is fixed at 3
        // browserArray[3] = "Safari"; // This will throw ArrayIndexOutOfBoundsException

        System.out.println("Array length: " + browserArray.length); // Output: 3
        System.out.println("First browser: " + browserArray[0]); // Direct access using []


        System.out.println("\n=== ARRAYLIST Example ===");

        // ArrayList: Dynamic size - starts empty, grows as needed
        ArrayList<String> browserList = new ArrayList<>();

        browserList.add("Chrome"); // Size becomes 1
        browserList.add("Firefox"); // Size becomes 2
        browserList.add("Edge"); // Size becomes 3
        browserList.add("Safari"); // Size becomes 4 - NO ERROR!
        browserList.add("Opera"); // Size becomes 5 - keeps growing

        System.out.println("ArrayList size: " + browserList.size()); // Output: 5
        System.out.println("First browser: " + browserList.get(0)); // Access using get() method


        // ========== Removing Elements ==========

        System.out.println("\n=== Removing Elements ===");

        // Array: Cannot remove - can only set to null
        browserArray[1] = null; // Set to null, but size remains 3
        System.out.println("Array length after nulling: " + browserArray.length); // Still 3

        // ArrayList: Can actually remove - size reduces
        browserList.remove("Firefox"); // Removes Firefox completely
        System.out.println("ArrayList size after removal: " + browserList.size()); // Now 4


        // ========== When to use what? ==========
        System.out.println("\n=== Use Cases ===");

        // Use Array when:
        // 1. You know exact size beforehand
        // 2. Need better performance (arrays are faster)
        // 3. Working with primitive types (int, char, boolean)

        int[] testPriorities = {1, 2, 3, 1, 2}; // Simple, fast

        // Use ArrayList when:
        // 1. Size is unknown or changes frequently
        // 2. Need to add/remove elements dynamically
        // 3. Need built-in methods (contains, indexOf, etc.)

        ArrayList<String> dynamicTestData = new ArrayList<>();
        // Can keep adding data as tests are discovered
        dynamicTestData.add("New Test 1");
        dynamicTestData.add("New Test 2");
        // ... keeps growing as needed
    }
}