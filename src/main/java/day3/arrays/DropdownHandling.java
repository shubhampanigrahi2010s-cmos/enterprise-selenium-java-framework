package day3.arrays;
import java.util.ArrayList;

public class DropdownHandling {
    public static void main(String[] args) {

        // ========== Scenario: Handling Dropdown Options ==========
        // In Selenium, we often fetch all options from a dropdown

        // Simulating dropdown options for "Country" field
        ArrayList<String> countryOptions = new ArrayList<>();
        countryOptions.add("United States");
        countryOptions.add("Canada");
        countryOptions.add("United Kingdom");
        countryOptions.add("Australia");
        countryOptions.add("India");
        countryOptions.add("Germany");

        System.out.println("=== Country Dropdown Analysis ===");
        System.out.println("Total options available: " + countryOptions.size());


        // ========== Verify if specific country exists ==========
        String expectedCountry = "India";

        if (countryOptions.contains(expectedCountry)) {
            System.out.println("✓ '" + expectedCountry + "' is available in dropdown");
        } else {
            System.out.println("✗ '" + expectedCountry + "' is NOT available");
        }


        // ========== Print all dropdown options ==========
        System.out.println("\n=== All Available Countries ===");

        int optionNumber = 1;
        for (String country : countryOptions) {
            System.out.println(optionNumber + ". " + country);
            optionNumber++;
        }
        // Output:
        // 1. United States
        // 2. Canada
        // 3. United Kingdom
        // ... and so on


        // ========== Select specific option by name ==========
        String selectCountry = "Canada";
        int position = countryOptions.indexOf(selectCountry);

        if (position != -1) { // -1 means not found
            System.out.println("\nSelecting '" + selectCountry + "' at position " + position);
        }


        // ========== Filter countries starting with 'U' ==========
        System.out.println("\n=== Countries starting with 'U' ===");

        for (String country : countryOptions) {
            if (country.startsWith("U")) { // Check if starts with 'U'
                System.out.println("- " + country);
            }
        }
        // Output:
        // - United States
        // - United Kingdom
    }
}
