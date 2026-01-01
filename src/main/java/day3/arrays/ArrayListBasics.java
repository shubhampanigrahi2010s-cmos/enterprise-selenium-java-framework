package day3.arrays;
// Import ArrayList class from java.util package
import java.util.ArrayList;

public class ArrayListBasics {
    public static void main(String[] args) {

        // ========== Creating ArrayList ==========

        // Syntax: ArrayList<DataType> name = new ArrayList<>();
        ArrayList<String> browsers = new ArrayList<>();
        // <String> = Generic type - specifies what type of data this list holds
        // Unlike arrays, ArrayList size is dynamic (can grow/shrink)

        // Initially, the ArrayList is empty
        System.out.println("Initial size: " + browsers.size()); // Output: 0


        // ========== Adding Elements ==========

        // add() method appends element to the end
        browsers.add("Chrome"); // Index 0
        browsers.add("Firefox"); // Index 1
        browsers.add("Edge"); // Index 2
        browsers.add("Safari"); // Index 3

        System.out.println("After adding elements: " + browsers.size()); // Output: 4
        System.out.println("All browsers: " + browsers); // Output: [Chrome, Firefox, Edge, Safari]


        // add(index, element) - insert at specific position
        browsers.add(1, "Opera"); // Insert at index 1, shifts others right
        // Now: [Chrome, Opera, Firefox, Edge, Safari]
        System.out.println("After inserting Opera: " + browsers);


        // ========== Accessing Elements ==========

        // get(index) - retrieve element at specific index
        String firstBrowser = browsers.get(0); // Get element at index 0
        System.out.println("First browser: " + firstBrowser); // Output: Chrome

        String thirdBrowser = browsers.get(2); // Get element at index 2
        System.out.println("Third browser: " + thirdBrowser); // Output: Firefox


        // ========== Updating Elements ==========

        // set(index, newValue) - replace element at specific index
        browsers.set(2, "Brave"); // Replace Firefox with Brave at index 2
        System.out.println("After updating: " + browsers); // [Chrome, Opera, Brave, Edge, Safari]


        // ========== Removing Elements ==========

        // remove(index) - remove element at specific index
        browsers.remove(1); // Remove element at index 1 (Opera)
        System.out.println("After removing index 1: " + browsers); // [Chrome, Brave, Edge, Safari]

        // remove(object) - remove first occurrence of the object
        browsers.remove("Edge"); // Finds and removes "Edge"
        System.out.println("After removing Edge: " + browsers); // [Chrome, Brave, Safari]


        // ========== Checking Elements ==========

        // contains(object) - check if element exists (returns true/false)
        boolean hasChrome = browsers.contains("Chrome");
        System.out.println("Contains Chrome? " + hasChrome); // Output: true

        boolean hasFirefox = browsers.contains("Firefox");
        System.out.println("Contains Firefox? " + hasFirefox); // Output: false


        // indexOf(object) - get index of element (returns -1 if not found)
        int index = browsers.indexOf("Brave");
        System.out.println("Index of Brave: " + index); // Output: 1

        int notFound = browsers.indexOf("Opera");
        System.out.println("Index of Opera: " + notFound); // Output: -1 (not in list)


        // ========== Other Useful Methods ==========

        // isEmpty() - check if ArrayList is empty
        System.out.println("Is list empty? " + browsers.isEmpty()); // Output: false

        // clear() - remove all elements
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Test");
        System.out.println("Before clear: " + temp.size()); // Output: 1
        temp.clear(); // Removes all elements
        System.out.println("After clear: " + temp.size()); // Output: 0
    }
}