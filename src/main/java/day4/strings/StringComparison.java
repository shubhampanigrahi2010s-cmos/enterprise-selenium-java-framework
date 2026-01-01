package day4.strings;

public class StringComparison {
    public static void main(String[] args) {

        // compareTo() - lexicographic comparison, returns integer
        String str1 = "Apple";
        String str2 = "Banana";
        // Returns negative if str1 < str2, 0 if equal, positive if str1 > str2
        int result = str1.compareTo(str2);
        System.out.println("Compare result: " + result); // Negative value

        if(result < 0) {
            System.out.println(str1 + " comes before " + str2);
        }

        // compareToIgnoreCase() - case-insensitive comparison
        String text1 = "selenium";
        String text2 = "SELENIUM";
        int caseInsensitiveResult = text1.compareToIgnoreCase(text2);
        System.out.println("Case-insensitive compare: " + caseInsensitiveResult); // 0

        // Comparing strings using == vs equals()
        String s1 = "Selenium"; // Stored in String Pool
        String s2 = "Selenium"; // Points to same object in String Pool
        String s3 = new String("Selenium"); // New object in heap

        // == compares reference (memory address), not content
        System.out.println("s1 == s2: " + (s1 == s2)); // true (same reference)
        System.out.println("s1 == s3: " + (s1 == s3)); // false (different reference)

        // equals() compares actual content - ALWAYS USE THIS
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true (same content)

        // Real Selenium scenario - validating actual vs expected
        String expectedUrl = "https://www.google.com/";
        String actualUrl = "https://www.google.com/";

        // Correct way to validate in Selenium
        if(expectedUrl.equals(actualUrl)) {
            System.out.println("URL validation passed!");
        } else {
            System.out.println("URL validation failed!");
        }

        // Validating multiple conditions
        String pageTitle = "Selenium - Web Browser Automation";
        boolean isValid = pageTitle.contains("Selenium") &&
                pageTitle.contains("Automation") &&
                pageTitle.length() > 10;
        System.out.println("Is title valid? " + isValid);

        // Null check before string operations - prevents NullPointerException
        String elementText = null;
        // Always check for null before calling methods on string
        if(elementText != null && !elementText.isEmpty()) {
            System.out.println("Text: " + elementText);
        } else {
            System.out.println("Element text is null or empty");
        }
    }
}