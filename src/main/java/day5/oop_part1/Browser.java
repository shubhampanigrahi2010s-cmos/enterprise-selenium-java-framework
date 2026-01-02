package day5.oop_part1;
// Class is a blueprint/template for creating objects
public class Browser {
    // Instance variables - belong to each object created from this class
    // These are different from local variables which exist only inside methods
    String browserName;
    String version;
    int windowCount;

    // Main method to test our Browser class
    public static void main(String[] args) {
        // Creating an object (instance) of Browser class using 'new' keyword
        Browser chrome = new Browser();

        // Accessing and setting instance variables using dot operator
        chrome.browserName = "Chrome";
        chrome.version = "120.0";
        chrome.windowCount = 3;

        // Printing object details
        System.out.println("Browser: " + chrome.browserName);
        System.out.println("Version: " + chrome.version);
        System.out.println("Windows Open: " + chrome.windowCount);

        // Creating another object - each object has its own copy of instance variables
        Browser firefox = new Browser();
        firefox.browserName = "Firefox";
        firefox.version = "119.0";
        firefox.windowCount = 1;

        System.out.println("\nBrowser: " + firefox.browserName);
        System.out.println("Version: " + firefox.version);
    }
}