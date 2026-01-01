package day4.strings;


public class StringManipulation {
    public static void main(String[] args) {

        // Converting to uppercase - useful for case-insensitive comparisons
        String errorMsg = "Error: Invalid username";
        String upperMsg = errorMsg.toUpperCase();
        System.out.println("Uppercase: " + upperMsg); // ERROR: INVALID USERNAME

        // Converting to lowercase - normalizing text for validation
        String pageTitle = "Welcome To SELENIUM";
        String lowerTitle = pageTitle.toLowerCase();
        System.out.println("Lowercase: " + lowerTitle); // welcome to selenium

        // Trimming whitespace - cleaning up extracted text from web elements
        String textWithSpaces = "   Login Successful   ";
        String trimmedText = textWithSpaces.trim();
        System.out.println("Trimmed: '" + trimmedText + "'"); // 'Login Successful'

        // Getting substring - extracting portions of text
        String fullName = "John Smith Doe";
        // substring(startIndex) - from index to end
        String lastName = fullName.substring(10);
        System.out.println("Last name: " + lastName); // Doe

        // substring(startIndex, endIndex) - from start to end (exclusive)
        String firstName = fullName.substring(0, 4);
        System.out.println("First name: " + firstName); // John

        // Replacing characters - modifying URLs or text
        String url = "https://www.example.com/user/123";
        String newUrl = url.replace("123", "456");
        System.out.println("Modified URL: " + newUrl);

        // Replace all occurrences using replaceAll with regex
        String text = "Price: $100 and $200";
        String modifiedText = text.replaceAll("\\$", "Rs.");
        System.out.println("Modified text: " + modifiedText);

        // Checking if string contains substring - validation
        String pageSource = "Welcome to Automation Testing";
        boolean containsWord = pageSource.contains("Automation");
        System.out.println("Contains 'Automation'? " + containsWord); // true

        // Checking if string starts with prefix - URL validation
        String websiteUrl = "https://www.google.com";
        boolean isSecure = websiteUrl.startsWith("https");
        System.out.println("Is secure URL? " + isSecure); // true

        // Checking if string ends with suffix - file type validation
        String fileName = "report.pdf";
        boolean isPdf = fileName.endsWith(".pdf");
        System.out.println("Is PDF file? " + isPdf); // true
    }
}
