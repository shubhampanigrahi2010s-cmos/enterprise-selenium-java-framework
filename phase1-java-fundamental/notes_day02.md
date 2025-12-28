# Java Methods - Day 02 Notes

## Table of Contents
1. [What are Methods?](#what-are-methods)
2. [Method Structure](#method-structure)
3. [Types of Methods](#types-of-methods)
4. [Return Types](#return-types)
5. [Parameters vs Arguments](#parameters-vs-arguments)
6. [Method Overloading](#method-overloading)
7. [Static vs Instance Methods](#static-vs-instance-methods)
8. [Access Modifiers](#access-modifiers)
9. [Instance Variables](#instance-variables)
10. [Getter and Setter Methods](#getter-and-setter-methods)
11. [Helper Methods](#helper-methods)
12. [Method Calling Patterns](#method-calling-patterns)
13. [Return Statement Rules](#return-statement-rules)
14. [Validation Patterns](#validation-patterns)
15. [Common Mistakes](#common-mistakes)
16. [Best Practices](#best-practices)

---

## What are Methods?

**Definition:** Methods are reusable blocks of code that perform specific tasks.

**Why use methods?**
- **Reusability:** Write once, use multiple times
- **Organization:** Break complex problems into smaller parts
- **Maintainability:** Easier to update and debug
- **Readability:** Makes code easier to understand

**Real-world analogy:** Think of a method like a recipe - it has a name, ingredients (parameters), steps (code), and produces a result (return value).

---

## Method Structure

### Basic Syntax
```java
accessModifier static? returnType methodName(parameterType parameterName, ...) {
    // Method body - code to execute
    return value; // if return type is not void
}
```

### Components Explained

1. **Access Modifier:** Controls where the method can be accessed from
    - `public`, `private`, `protected`, or default (no keyword)

2. **static (optional):** Makes method belong to class instead of objects

3. **Return Type:** What type of data the method returns
    - `void` if nothing is returned
    - `int`, `double`, `String`, `boolean`, etc.

4. **Method Name:** Follows camelCase convention
    - Start with lowercase letter
    - Use descriptive names: `calculateTotal()`, `isValid()`

5. **Parameters:** Input values the method receives (inside parentheses)
    - Can be zero or more
    - Each parameter has a type and name

6. **Method Body:** The code that executes (inside curly braces)

7. **Return Statement:** Sends back a value (if not void)

### Example
```java
public int addNumbers(int a, int b) {
    int sum = a + b;
    return sum;
}
```

---

## Types of Methods

### 1. Void Methods (No Return Value)
```java
public void displayMessage() {
    System.out.println("Hello!");
    // No return statement needed
}
```
- Performs actions but doesn't return anything
- Used for printing, updating values, etc.

### 2. Value-Returning Methods
```java
public int multiply(int x, int y) {
    return x * y;  // MUST return an int
}
```
- Returns a value to the caller
- Must include `return` statement with appropriate type

### 3. Methods Without Parameters
```java
public double getPi() {
    return 3.14159;
}
```
- Empty parentheses `()` but still required
- Always performs the same operation

### 4. Methods With Multiple Parameters
```java
public double calculateArea(double length, double width) {
    return length * width;
}
```
- Can accept multiple inputs
- Parameters separated by commas

---

## Return Types

### Primitive Types
- **`int`** - whole numbers (-2,147,483,648 to 2,147,483,647)
- **`double`** - decimal numbers (fractional values)
- **`char`** - single character ('A', 'z', '3')
- **`boolean`** - true or false only
- **`long`** - larger whole numbers
- **`float`** - smaller decimal numbers

### Reference Types
- **`String`** - text/sequence of characters
- **`Object`** - any object type
- **Arrays** - collection of elements

### void
- Special keyword meaning "nothing returned"
- Method performs actions only

### Examples
```java
// Returns integer
public int getAge() {
    return 25;
}

// Returns double
public double getPrice() {
    return 99.99;
}

// Returns boolean
public boolean isAdult(int age) {
    return age >= 18;
}

// Returns String
public String getName() {
    return "John";
}

// Returns nothing (void)
public void printInfo() {
    System.out.println("Information");
}
```

---

## Parameters vs Arguments

### Parameters
- Variables listed in the method declaration
- Act as placeholders for actual values
- Define what type of data the method expects

```java
public int add(int num1, int num2) {
    // num1 and num2 are PARAMETERS
    return num1 + num2;
}
```

### Arguments
- Actual values passed when calling the method
- Must match parameter types

```java
int result = add(5, 10);
// 5 and 10 are ARGUMENTS
```

### Key Differences
| Parameters | Arguments |
|------------|-----------|
| In method declaration | In method call |
| Variable names | Actual values |
| Define what method needs | Provide the actual data |

### Example
```java
// Parameters: name and age
public void greet(String name, int age) {
    System.out.println("Hello " + name + ", age " + age);
}

// Arguments: "Alice" and 20
greet("Alice", 20);
```

---

## Method Overloading

**Definition:** Creating multiple methods with the **same name** but **different parameters**.

### Rules for Overloading
1. ✅ Same method name
2. ✅ Different number of parameters
3. ✅ Different types of parameters
4. ✅ Different order of parameters
5. ❌ Return type alone is NOT enough

### Why Use Overloading?
- More flexible and convenient to use
- Same operation, different inputs
- Makes code more readable

### Examples

#### Different Number of Parameters
```java
public int add(int a, int b) {
    return a + b;
}

public int add(int a, int b, int c) {
    return a + b + c;
}
```

#### Different Types of Parameters
```java
public int add(int a, int b) {
    return a + b;
}

public double add(double a, double b) {
    return a + b;
}
```

#### Different Order of Parameters
```java
public void display(String name, int age) {
    System.out.println(name + " is " + age);
}

public void display(int age, String name) {
    System.out.println(age + " year old " + name);
}
```

### Invalid Overloading (Won't Compile)
```java
// ❌ WRONG - Only return type is different
public int calculate(int a, int b) {
    return a + b;
}

public double calculate(int a, int b) {  // ERROR!
    return a + b;
}
```

---

## Static vs Instance Methods

### Static Methods
- Belong to the **class** itself
- Called using class name: `ClassName.methodName()`
- Can be called **without creating an object**
- **Cannot** access instance variables directly
- Use `static` keyword

```java
public class MathUtils {
    // Static method
    public static int square(int num) {
        return num * num;
    }
}

// Calling static method - NO OBJECT NEEDED
int result = MathUtils.square(5);
```

**When to use static methods:**
- Utility/helper functions
- Methods that don't need object data
- Mathematical operations
- Factory methods

### Instance Methods
- Belong to **objects** (instances)
- Called using object reference: `object.methodName()`
- **Must create an object** first
- **Can** access instance variables
- No `static` keyword

```java
public class Student {
    private String name;  // Instance variable
    
    // Instance method
    public void setName(String name) {
        this.name = name;  // Accessing instance variable
    }
}

// Calling instance method - OBJECT REQUIRED
Student student = new Student();
student.setName("Alice");
```

**When to use instance methods:**
- Methods that work with object's data
- Methods that modify object state
- Most regular methods

### Comparison Table
| Feature | Static Method | Instance Method |
|---------|---------------|-----------------|
| Belongs to | Class | Object |
| Called with | Class name | Object reference |
| Access instance variables | ❌ No | ✅ Yes |
| Keyword | `static` | None |
| Memory | One copy for class | One copy per object |

### Important Rules
```java
public class Example {
    private int instanceVar = 10;  // Instance variable
    private static int staticVar = 20;  // Static variable
    
    // Static method
    public static void staticMethod() {
        System.out.println(staticVar);  // ✅ OK
        // System.out.println(instanceVar);  // ❌ ERROR
        // instanceMethod();  // ❌ ERROR
    }
    
    // Instance method
    public void instanceMethod() {
        System.out.println(instanceVar);  // ✅ OK
        System.out.println(staticVar);  // ✅ OK
        staticMethod();  // ✅ OK
    }
}
```

---

## Access Modifiers

Control **where** a method can be accessed from.

### 1. public
- Accessible from **anywhere**
- Any class, any package
- Most permissive

```java
public void display() {
    System.out.println("Public method");
}
```

### 2. private
- Accessible **only within the same class**
- Most restrictive
- Used for helper methods

```java
private void calculate() {
    System.out.println("Private method");
}
```

### 3. protected
- Accessible within **same package** and **subclasses**
- Medium restriction

```java
protected void process() {
    System.out.println("Protected method");
}
```

### 4. default (no modifier)
- Accessible within **same package only**
- No keyword written

```java
void execute() {
    System.out.println("Default method");
}
```

### Access Level Summary
| Modifier | Same Class | Same Package | Subclass | Other Package |
|----------|------------|--------------|----------|---------------|
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| default | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

### Best Practice
- Make methods `private` by default
- Use `public` only for methods that need to be accessed externally
- Protects internal implementation details

---

## Instance Variables

**Definition:** Variables declared at class level (outside methods) that belong to each object.

### Declaration
```java
public class Student {
    // Instance variables
    private String name;
    private int age;
    private double gpa;
    
    // Methods can access these variables
}
```

### Characteristics
- Declared inside class, outside methods
- Each object gets its own copy
- Have default values if not initialized
    - Numbers: 0
    - boolean: false
    - Objects: null
- Should usually be `private`
- Accessible by all instance methods in the class

### vs Local Variables

```java
public class Example {
    private int instanceVar = 10;  // Instance variable
    
    public void method() {
        int localVar = 20;  // Local variable
        System.out.println(instanceVar);  // ✅ OK
        System.out.println(localVar);  // ✅ OK
    }
    
    public void anotherMethod() {
        System.out.println(instanceVar);  // ✅ OK
        // System.out.println(localVar);  // ❌ ERROR - not accessible
    }
}
```

| Instance Variable | Local Variable |
|-------------------|----------------|
| Declared at class level | Declared inside method |
| Accessible by all methods | Only in that method |
| Has default value | Must be initialized |
| Lives with object | Lives during method execution |

---

## Getter and Setter Methods

**Purpose:** Provide controlled access to private instance variables.

### Why Use Them?
- Encapsulation (data hiding)
- Validation before setting values
- Can add logic when getting/setting
- Follows Java Bean naming convention

### Getter Methods
- **Purpose:** Return the value of a private variable
- **Naming:** `get` + VariableName
- **Return type:** Same as variable type

```java
public class Student {
    private String name;
    private int age;
    
    // Getter for name
    public String getName() {
        return name;
    }
    
    // Getter for age
    public int getAge() {
        return age;
    }
}
```

### Setter Methods
- **Purpose:** Set/change the value of a private variable
- **Naming:** `set` + VariableName
- **Return type:** Usually `void`
- **Parameter:** New value to set

```java
public class Student {
    private String name;
    private int age;
    
    // Setter for name
    public void setName(String name) {
        this.name = name;  // 'this' refers to instance variable
    }
    
    // Setter for age with validation
    public void setAge(int age) {
        if (age > 0 && age < 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age!");
        }
    }
}
```

### Using Getters and Setters
```java
Student student = new Student();

// Using setter
student.setName("Alice");
student.setAge(20);

// Using getter
String name = student.getName();
int age = student.getAge();
System.out.println(name + " is " + age + " years old");
```

### Boolean Getters
For boolean variables, use `is` instead of `get`:

```java
private boolean passed;

// Getter for boolean
public boolean isPassed() {
    return passed;
}

// Setter for boolean
public void setPassed(boolean passed) {
    this.passed = passed;
}
```

### Benefits
1. **Validation:** Check data before setting
2. **Read-only:** Provide getter without setter
3. **Write-only:** Provide setter without getter
4. **Computed values:** Calculate value when getting
5. **Change implementation:** Modify internal storage without affecting callers

---

## Helper Methods

**Definition:** Private methods that assist public methods but aren't meant to be called from outside.

### Purpose
- Break complex methods into smaller pieces
- Avoid code duplication
- Keep code organized and readable
- Hide implementation details

### Characteristics
- Usually `private`
- Called by other methods in the same class
- Not accessible from outside the class
- More focused and specific tasks

### Example
```java
public class Calculator {
    
    // Public method that uses helper methods
    public void displayCalculations(int a, int b) {
        System.out.println("Sum: " + add(a, b));
        System.out.println("Product: " + multiply(a, b));
        displaySeparator();  // Helper method
    }
    
    // Private helper method
    private int add(int x, int y) {
        return x + y;
    }
    
    // Private helper method
    private int multiply(int x, int y) {
        return x * y;
    }
    
    // Private helper method
    private void displaySeparator() {
        System.out.println("-------------------");
    }
}
```

### Benefits
- Makes public methods cleaner
- Easier to test individual pieces
- Can change helper methods without affecting public API
- Improves code maintainability

---

## Method Calling Patterns

### 1. Call and Store Result
```java
int result = calculator.add(5, 10);
System.out.println(result);
```

### 2. Call and Use Directly
```java
System.out.println(calculator.add(5, 10));
```

### 3. Call Without Using Result (void or ignored)
```java
calculator.displayMessage();  // void method
```

### 4. Method Chaining
```java
student.setName("Alice").setAge(20).setGrade('A');
// Each method returns 'this' to allow chaining
```

### 5. Nested Method Calls
```java
int result = calculator.add(calculator.multiply(2, 3), 5);
// Inner method executes first: multiply(2,3) = 6
// Then outer: add(6, 5) = 11
```

### 6. Calling Methods from Same Class
```java
public class Example {
    public void method1() {
        System.out.println("Method 1");
        method2();  // Call another method
    }
    
    public void method2() {
        System.out.println("Method 2");
    }
}
```

### 7. Calling Static Methods
```java
// From same class
staticMethod();
ClassName.staticMethod();  // Also valid

// From different class
OtherClass.staticMethod();
```

---

## Return Statement Rules

### 1. Required for Non-Void Methods
```java
public int getValue() {
    return 10;  // MUST have return
}
```

### 2. Must Match Return Type
```java
public int getNumber() {
    return 5;        // ✅ OK - int
    // return "5";   // ❌ ERROR - String
    // return 5.5;   // ❌ ERROR - double
}
```

### 3. Can Have Multiple Returns
```java
public String checkAge(int age) {
    if (age >= 18) {
        return "Adult";    // Return here
    } else {
        return "Minor";    // Or return here
    }
}
```

### 4. All Paths Must Return
```java
// ❌ WRONG - missing return for some paths
public int getValue(boolean flag) {
    if (flag) {
        return 10;
    }
    // ERROR: no return if flag is false
}

// ✅ CORRECT
public int getValue(boolean flag) {
    if (flag) {
        return 10;
    } else {
        return 0;
    }
}
```

### 5. Code After Return is Unreachable
```java
public int test() {
    return 5;
    System.out.println("Never executes");  // ❌ ERROR
}
```

### 6. void Methods Can Return Early
```java
public void process(int value) {
    if (value < 0) {
        System.out.println("Invalid");
        return;  // Exit method early
    }
    System.out.println("Processing: " + value);
}
```

### 7. Can Return Expressions
```java
public int calculate(int a, int b) {
    return a * b + 10;  // Expression evaluated first
}
```

---

## Validation Patterns

### 1. Validate Before Processing
```java
public void setAge(int age) {
    if (age < 0 || age > 120) {
        System.out.println("Invalid age");
        return;  // Exit if invalid
    }
    this.age = age;  // Set only if valid
}
```

### 2. Return Boolean for Validity
```java
public boolean isValidEmail(String email) {
    if (email == null || email.isEmpty()) {
        return false;
    }
    if (!email.contains("@")) {
        return false;
    }
    return true;
}
```

### 3. Multiple Validations
```java
public boolean isValidStudent(String name, int age, double gpa) {
    if (name == null || name.isEmpty()) {
        return false;
    }
    if (age < 0 || age > 100) {
        return false;
    }
    if (gpa < 0.0 || gpa > 4.0) {
        return false;
    }
    return true;  // All checks passed
}
```

### 4. Throw Exceptions (Advanced)
```java
public void setScore(int score) {
    if (score < 0 || score > 100) {
        throw new IllegalArgumentException("Score must be 0-100");
    }
    this.score = score;
}
```

---

## Common Mistakes

### 1. Forgetting to Return
```java
// ❌ WRONG
public int add(int a, int b) {
    int sum = a + b;
    // Missing return statement
}

// ✅ CORRECT
public int add(int a, int b) {
    int sum = a + b;
    return sum;
}
```

### 2. Wrong Return Type
```java
// ❌ WRONG
public int divide(int a, int b) {
    return a / b;  // Returns int, loses decimal
}

// ✅ CORRECT
public double divide(int a, int b) {
    return (double) a / b;  // Returns double
}
```

### 3. Not Calling Method (Missing Parentheses)
```java
// ❌ WRONG
System.out.println(calculator.add);  // No ()

// ✅ CORRECT
System.out.println(calculator.add(5, 10));
```

### 4. Confusing Parameters and Arguments
```java
public void greet(String name) {  // 'name' is parameter
    System.out.println("Hello " + name);
}

greet("Alice");  // "Alice" is argument
```

### 5. Trying to Use Local Variable Outside Method
```java
public void method1() {
    int x = 10;
}

public void method2() {
    System.out.println(x);  // ❌ ERROR - x not accessible
}
```

### 6. Calling Instance Method from Static Method
```java
public class Example {
    public void instanceMethod() {
        System.out.println("Instance");
    }
    
    public static void staticMethod() {
        instanceMethod();  // ❌ ERROR - need object
    }
}
```

### 7. Not Creating Object for Instance Methods
```java
// ❌ WRONG
Calculator.add(5, 10);  // If add() is not static

// ✅ CORRECT
Calculator calc = new Calculator();
calc.add(5, 10);
```

---

## Best Practices

### 1. Use Descriptive Method Names
```java
// ❌ Bad
public int calc(int a, int b) { }

// ✅ Good
public int calculateTotal(int price, int quantity) { }
```

### 2. Keep Methods Short and Focused
- One method = One responsibility
- If method is too long, break it into smaller methods
- Aim for 10-20 lines per method

### 3. Use Proper Access Modifiers
```java
// Make fields private
private String name;

// Make helper methods private
private void helperMethod() { }

// Make public only what needs to be accessed externally
public void setName(String name) { }
```

### 4. Validate Input Parameters
```java
public void setAge(int age) {
    if (age < 0) {
        System.out.println("Age cannot be negative");
        return;
    }
    this.age = age;
}
```

### 5. Use Meaningful Parameter Names
```java
// ❌ Bad
public int calc(int a, int b, int c) { }

// ✅ Good
public int calculateTotal(int price, int quantity, int tax) { }
```

### 6. Comment Complex Methods
```java
/**
 * Calculates the final price after applying discount and tax
 * @param basePrice The original price before calculations
 * @param discountPercent The discount percentage (0-100)
 * @param taxPercent The tax percentage (0-100)
 * @return The final calculated price
 */
public double calculateFinalPrice(double basePrice, 
                                  double discountPercent, 
                                  double taxPercent) {
    // Implementation
}
```

### 7. Follow Naming Conventions
- Method names: `camelCase`
- Start with verb: `calculate`, `get`, `set`, `is`, `display`
- Boolean methods: `isValid()`, `hasPermission()`, `canAccess()`

### 8. Return Early for Error Cases
```java
public void processData(String data) {
    if (data == null || data.isEmpty()) {
        return;  // Exit early
    }
    // Process data
}
```

### 9. Don't Repeat Code (DRY Principle)
```java
// ❌ Bad - Repeated code
public void printStudent1() {
    System.out.println("Name: John");
    System.out.println("Age: 20");
}

public void printStudent2() {
    System.out.println("Name: Alice");
    System.out.println("Age: 22");
}

// ✅ Good - Use parameters
public void printStudent(String name, int age) {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
}
```

### 10. Use Constants for Magic Numbers
```java
// ❌ Bad
public boolean isAdult(int age) {
    return age >= 18;
}

// ✅ Good
private static final int ADULT_AGE = 18;

public boolean isAdult(int age) {
    return age >= ADULT_AGE;
}
```

---

## Quick Reference Card

### Method Template
```java
public returnType methodName(Type param1, Type param2) {
    // Code here
    return value;  // If not void
}
```

### Common Method Patterns
```java
// Void method
public void display() { }

// Return value
public int calculate() { return 0; }

// With parameters
public int add(int a, int b) { return a + b; }

// Getter
public String getName() { return name; }

// Setter
public void setName(String name) { this.name = name; }

// Validation
public boolean isValid() { return true/false; }

// Static method
public static void utility() { }
```

---

## Summary Checklist

- ✅ Methods organize code into reusable blocks
- ✅ Use `void` when no value is returned
- ✅ Parameters are inputs, arguments are actual values
- ✅ Method overloading = same name, different parameters
- ✅ Static methods belong to class, instance methods to objects
- ✅ Make fields private, use getters/setters for access
- ✅ Helper methods should be private
- ✅ Always validate input when necessary
- ✅ Return early for error cases
- ✅ Keep methods short and focused

---

## Practice Exercises

1. Create a `BankAccount` class with:
    - Instance variables: `accountNumber`, `balance`, `ownerName`
    - Methods: `deposit()`, `withdraw()`, `getBalance()`, `displayInfo()`
    - Validation: Check sufficient funds before withdrawal

2. Create a `Rectangle` class with:
    - Instance variables: `length`, `width`
    - Methods: `calculateArea()`, `calculatePerimeter()`, `isSquare()`
    - Getters and setters with validation

3. Create a `Temperature` class with:
    - Static methods: `celsiusToFahrenheit()`, `fahrenheitToCelsius()`
    - Instance variables: `temperature`, `unit`
    - Methods: `convert()`, `display()`

---

**End of Notes - Day 02**