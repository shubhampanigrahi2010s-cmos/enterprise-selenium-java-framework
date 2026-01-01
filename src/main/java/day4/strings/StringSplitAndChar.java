package day4.strings;


public class StringSplitAndChar {
    public static void main(String[] args) {

        // Splitting strings - parsing CSV data or breaking down complex text
        String csvData = "John,Doe,john@example.com,25";
        // split() divides string into array based on delimiter
        String[] userData = csvData.split(",");
        System.out.println("First Name: " + userData[0]); // John
        System.out.println("Last Name: " + userData[1]);  // Doe
        System.out.println("Email: " + userData[2]);       // john@example.com
        System.out.println("Age: " + userData[3]);         // 25

        // Splitting by space - breaking sentences into words
        String sentence = "Selenium WebDriver Automation Testing";
        String[] words = sentence.split(" ");
        System.out.println("Number of words: " + words.length); // 4
        for(int i = 0; i < words.length; i++) {
            System.out.println("Word " + (i+1) + ": " + words[i]);
        }

        // Getting character at specific index - validation of individual characters
        String username = "testuser123";
        char firstChar = username.charAt(0);
        char lastChar = username.charAt(username.length() - 1);
        System.out.println("First character: " + firstChar); // t
        System.out.println("Last character: " + lastChar);   // 3

        // Finding index of character or substring - locating specific text
        String message = "Error occurred at line 45";
        int indexOfError = message.indexOf("Error");
        System.out.println("Index of 'Error': " + indexOfError); // 0

        int indexOfLine = message.indexOf("line");
        System.out.println("Index of 'line': " + indexOfLine); // 22

        // lastIndexOf - finding last occurrence
        String logMessage = "Test Test Test";
        int lastIndex = logMessage.lastIndexOf("Test");
        System.out.println("Last index of 'Test': " + lastIndex); // 10

        // Converting string to character array - processing each character
        String password = "Pass@123";
        char[] charArray = password.toCharArray();
        System.out.println("Password characters:");
        for(char c : charArray) {
            System.out.print(c + " "); // P a s s @ 1 2 3
        }
        System.out.println();

        // Checking if string is blank (Java 11+) - validates if string has meaningful content
        String emptyString = "   ";
        // isBlank() returns true if string is empty or contains only whitespace
        // boolean isBlank = emptyString.isBlank(); // Uncomment for Java 11+
    }
}