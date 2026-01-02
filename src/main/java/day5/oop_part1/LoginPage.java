package day5.oop_part1;
// Class demonstrating different access modifiers
public class LoginPage {
    // public - accessible from anywhere (within and outside package)
    public String pageTitle;

    // private - accessible only within this class (most restricted)
    private String adminPassword;

    // default (no modifier) - accessible only within same package
    String sessionId;

    // protected - accessible within same package and subclasses (even in different packages)
    protected boolean isLoggedIn;

    // public constructor - can be called from anywhere
    public LoginPage() {
        // Can access all variables within the same class regardless of access modifier
        this.pageTitle = "Login - Automation Test";
        this.adminPassword = "superSecret123";
        this.sessionId = "SESSION_" + System.currentTimeMillis();
        this.isLoggedIn = false;
    }

    // public method - accessible from anywhere
    public void displayPageTitle() {
        System.out.println("Page Title: " + pageTitle);
    }

    // private method - only accessible within this class
    private boolean validateAdminPassword(String password) {
        // Can access private variable within same class
        return this.adminPassword.equals(password);
    }

    // public method that uses private method internally
    public void adminLogin(String password) {
        // Calling private method from within same class is allowed
        if (validateAdminPassword(password)) {
            this.isLoggedIn = true;
            System.out.println("Admin login successful!");
        } else {
            System.out.println("Invalid admin password!");
        }
    }

    // protected method - accessible in same package and subclasses
    protected void resetSession() {
        this.sessionId = "SESSION_" + System.currentTimeMillis();
        this.isLoggedIn = false;
        System.out.println("Session reset completed");
    }

    // Main method to demonstrate access modifiers
    public static void main(String[] args) {
        // Creating LoginPage object
        LoginPage loginPage = new LoginPage();

        // Accessing public variable - works fine
        System.out.println("Accessing public variable: " + loginPage.pageTitle);

        // Accessing default variable - works because we're in same class
        System.out.println("Accessing default variable: " + loginPage.sessionId);

        // Accessing protected variable - works because we're in same class
        System.out.println("Accessing protected variable: " + loginPage.isLoggedIn);

        // CANNOT access private variable directly - would give compilation error
        // System.out.println(loginPage.adminPassword); // This line would cause error

        // Calling public method - works fine
        loginPage.displayPageTitle();

        // CANNOT call private method directly - would give compilation error
        // loginPage.validateAdminPassword("test"); // This line would cause error

        // Can use private functionality through public method
        loginPage.adminLogin("superSecret123");

        // Calling protected method - works because we're in same class
        loginPage.resetSession();
    }
}