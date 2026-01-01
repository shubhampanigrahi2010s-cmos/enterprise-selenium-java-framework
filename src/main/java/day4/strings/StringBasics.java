package day4.strings;


public class StringBasics {
    public static void main(String[] args) {

        // Method 1: String Literal - Stored in String Pool for memory optimization
        String url1 = "https://www.selenium.dev";

        // Method 2: Using new keyword - Creates object in heap memory
        String url2 = new String("https://www.selenium.dev");

        // Getting length of string - useful for validation in Selenium
        int length = url1.length();
        System.out.println("URL Length: " + length); // Output: 25

        // Checking if string is empty - important before performing actions
        boolean isEmpty = url1.isEmpty();
        System.out.println("Is URL empty? " + isEmpty); // Output: false

        // Concatenating strings - building dynamic locators or URLs
        String baseUrl = "https://www.google.com";
        String searchQuery = "/search?q=selenium";
        String fullUrl = baseUrl + searchQuery; // Using + operator
        System.out.println("Full URL: " + fullUrl);

        // Using concat() method - alternative to + operator
        String completeUrl = baseUrl.concat(searchQuery);
        System.out.println("Complete URL: " + completeUrl);

        // String comparison using equals() - ALWAYS use this, not ==
        String expectedTitle = "Selenium";
        String actualTitle = "Selenium";
        boolean isMatch = expectedTitle.equals(actualTitle);
        System.out.println("Titles match? " + isMatch); // Output: true

        // Case-insensitive comparison - useful for validation
        String title1 = "Selenium WebDriver";
        String title2 = "selenium webdriver";
        boolean isMatchIgnoreCase = title1.equalsIgnoreCase(title2);
        System.out.println("Match ignoring case? " + isMatchIgnoreCase); // Output: true
    }
}