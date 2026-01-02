package day5.oop_part1;
// Complete example combining all OOP concepts for automation testing
public class AutomationTest {
    // Main method - entry point of program
    public static void main(String[] args) {
        // Creating Browser object using default constructor
        TestBrowser browser = new TestBrowser();
        browser.displayBrowserInfo();

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Creating Browser object with parameterized constructor
        TestBrowser chrome = new TestBrowser("Chrome", "120.0", true);
        chrome.displayBrowserInfo();

        // Testing setter with validation
        chrome.setHeadless(false);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Creating User object and demonstrating encapsulation
        TestUser user = new TestUser("automation_tester", "Test@12345", "tester@qa.com");
        user.displayUserInfo();

        // Attempting to change password with validation
        user.setPassword("weak"); // Will fail validation
        user.setPassword("StrongPass@123"); // Will succeed

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Creating LoginPage object demonstrating access modifiers
        WebLoginPage loginPage = new WebLoginPage("https://example.com/login");
        loginPage.displayPageInfo();

        // Attempting login with user credentials
        loginPage.performLogin(user.getUsername(), "StrongPass@123");
    }
}

// Browser class with constructors and this keyword
class TestBrowser {
    // Private instance variables (encapsulation)
    private String name;
    private String version;
    private boolean isHeadless;

    // Default constructor
    public TestBrowser() {
        // Using 'this' to call another constructor (constructor chaining)
        this("Firefox", "119.0", false);
        System.out.println("Default constructor: Creating default browser configuration");
    }

    // Parameterized constructor
    public TestBrowser(String name, String version, boolean isHeadless) {
        // Using 'this' keyword to distinguish between instance variables and parameters
        this.name = name;
        this.version = version;
        this.isHeadless = isHeadless;
        System.out.println("Parameterized constructor: Browser configured");
    }

    // Getter methods (providing controlled READ access)
    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isHeadless() {
        return this.isHeadless;
    }

    // Setter methods (providing controlled WRITE access with validation)
    public void setName(String name) {
        // Validation logic
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setHeadless(boolean isHeadless) {
        // Adding business logic in setter
        this.isHeadless = isHeadless;
        System.out.println("Browser mode changed to: " +
                (isHeadless ? "Headless" : "GUI Mode"));
    }

    // Public method to display browser info
    public void displayBrowserInfo() {
        System.out.println("Browser Name: " + getName());
        System.out.println("Version: " + getVersion());
        System.out.println("Headless Mode: " + isHeadless());
    }
}

// User class demonstrating complete encapsulation
class TestUser {
    // All variables are private (data hiding)
    private String username;
    private String password;
    private String email;
    private boolean isVerified;

    // Constructor with validation
    public TestUser(String username, String password, String email) {
        // Using setters to apply validation during object creation
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.isVerified = false; // Default value
    }

    // Getters
    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean isVerified() {
        return this.isVerified;
    }

    // Setters with validation (core of encapsulation)
    public void setUsername(String username) {
        // Validation: username must be at least 5 characters
        if (username != null && username.length() >= 5) {
            this.username = username;
        } else {
            System.out.println("Error: Username must be at least 5 characters");
            this.username = "default_user";
        }
    }

    public void setPassword(String password) {
        // Validation: password must have minimum length and special character
        if (password != null && password.length() >= 8 &&
                password.matches(".*[@#$%^&+=].*")) {
            this.password = password;
            System.out.println("Password updated successfully");
        } else {
            System.out.println("Error: Password must be 8+ characters with special character");
        }
    }

    public void setEmail(String email) {
        // Basic email validation
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Error: Invalid email format");
        }
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    // Method demonstrating use of private data
    public void displayUserInfo() {
        System.out.println("User Information:");
        System.out.println("  Username: " + getUsername());
        System.out.println("  Email: " + getEmail());
        System.out.println("  Verified: " + isVerified());
        System.out.println("  Password: [PROTECTED]"); // Not exposing actual password
    }
}

// LoginPage class demonstrating access modifiers
class WebLoginPage {
    // Different access modifiers demonstrated
    public String pageUrl;           // public - accessible everywhere
    private String pageTitle;        // private - only within this class
    protected int loadTimeSeconds;   // protected - same package + subclasses
    String pageId;                   // default - same package only

    // Private variable to track login attempts
    private int loginAttempts;

    // Constructor
    public WebLoginPage(String pageUrl) {
        this.pageUrl = pageUrl;
        this.pageTitle = "Login Page";
        this.loadTimeSeconds = 5;
        this.pageId = "LOGIN_PAGE_001";
        this.loginAttempts = 0;
    }

    // Public method - accessible from anywhere
    public void displayPageInfo() {
        System.out.println("Page URL: " + this.pageUrl);
        System.out.println("Page Title: " + this.pageTitle); // Can access private within class
        System.out.println("Load Time: " + this.loadTimeSeconds + " seconds");
    }

    // Private method - only accessible within this class
    private boolean validateCredentials(String username, String password) {
        // Private method for internal validation logic
        return username != null && password != null &&
                username.length() > 0 && password.length() >= 8;
    }

    // Public method using private method internally
    public void performLogin(String username, String password) {
        // Incrementing login attempts
        this.loginAttempts++;

        // Using private method for validation
        if (validateCredentials(username, password)) {
            System.out.println("Login successful for user: " + username);
            System.out.println("Login attempts: " + this.loginAttempts);
        } else {
            System.out.println("Login failed - Invalid credentials");
        }
    }

    // Protected method - accessible in same package and subclasses
    protected void resetPage() {
        this.loginAttempts = 0;
        System.out.println("Page reset completed");
    }

    // Getter for private variable
    public int getLoginAttempts() {
        return this.loginAttempts;
    }
}
