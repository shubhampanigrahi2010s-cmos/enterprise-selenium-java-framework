package day4.strings;

public class SeleniumStringScenarios {
    public static void main(String[] args) {

        // Scenario 1: Building dynamic XPath using strings
        String baseXpath = "//input[@id='";
        String fieldName = "username";
        String closingXpath = "']";
        // Concatenating to create complete XPath
        String completeXpath = baseXpath + fieldName + closingXpath;
        System.out.println("XPath: " + completeXpath);
        // Output: //input[@id='username']

        // Scenario 2: Extracting data from web element text
        String priceText = "Price: $1,234.56";
        // Remove currency symbol and comma
        String cleanPrice = priceText.replace("Price: $", "").replace(",", "");
        // Convert to double for calculations
        double price = Double.parseDouble(cleanPrice);
        System.out.println("Numeric price: " + price); // 1234.56

        // Scenario 3: Validating error messages
        String actualError = "  Username is required  ";
        String expectedError = "Username is required";
        // Trim spaces before comparison
        boolean isErrorMatch = actualError.trim().equals(expectedError);
        System.out.println("Error message matches? " + isErrorMatch);

        // Scenario 4: Handling alert messages with contains
        String alertText = "Are you sure you want to delete this record?";
        if(alertText.contains("delete") || alertText.contains("remove")) {
            System.out.println("Confirmation alert detected");
        }

        // Scenario 5: Parsing table data
        String tableRow = "1|John Doe|john@test.com|Active";
        String[] columns = tableRow.split("\\|"); // Escape | as it's regex special char
        System.out.println("ID: " + columns[0]);
        System.out.println("Name: " + columns[1]);
        System.out.println("Email: " + columns[2]);
        System.out.println("Status: " + columns[3]);

        // Scenario 6: Generating test data with formatted strings
        // Using String.format() for formatted output
        String firstName = "John";
        String lastName = "Doe";
        int age = 30;
        // %s for string, %d for integer
        String formattedData = String.format("User: %s %s, Age: %d",
                firstName, lastName, age);
        System.out.println(formattedData);

        // Scenario 7: URL manipulation
        String currentUrl = "https://www.example.com/products/123?category=electronics";
        // Extract product ID
        int startIndex = currentUrl.indexOf("/products/") + 10;
        int endIndex = currentUrl.indexOf("?");
        String productId = currentUrl.substring(startIndex, endIndex);
        System.out.println("Product ID: " + productId); // 123

        // Scenario 8: Creating CSV test data
        String[] testData = {"test1@email.com", "password123", "John", "Doe"};
        // Joining array elements with comma
        String csvLine = String.join(",", testData);
        System.out.println("CSV: " + csvLine);
        // Output: test1@email.com,password123,John,Doe

        // Scenario 9: Validating dropdown options
        String dropdownOption = "Select Country";
        boolean isPlaceholder = dropdownOption.startsWith("Select") ||
                dropdownOption.startsWith("Choose");
        System.out.println("Is placeholder? " + isPlaceholder);

        // Scenario 10: StringBuilder for efficient string concatenation in loops
        // Use StringBuilder when building strings in loops - more efficient
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Test Report\n");
        reportBuilder.append("=============\n");
        for(int i = 1; i <= 3; i++) {
            reportBuilder.append("Test Case ").append(i).append(": Passed\n");
        }
        String finalReport = reportBuilder.toString();
        System.out.println(finalReport);
    }
}
