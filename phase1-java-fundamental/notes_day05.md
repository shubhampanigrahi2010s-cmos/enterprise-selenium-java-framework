OOP Part 1 (Foundation) - Theory Notes
📌 What is Object-Oriented Programming (OOP)?
Object-Oriented Programming is a programming paradigm that organizes code around objects rather than functions and logic. It models real-world entities as software objects that contain both data (attributes) and behavior (methods).
Key Benefits:

Code reusability
Better organization and structure
Easier maintenance and debugging
Models real-world scenarios effectively
Reduces code complexity


🏗️ Class vs Object
Class

A blueprint or template for creating objects
Defines the structure (what data it holds) and behavior (what it can do)
Does not occupy memory until an object is created
Written once and can create multiple objects from it

Real-world analogy: A class is like an architectural blueprint of a house.
Object

An instance of a class
A concrete entity created from the class blueprint
Occupies memory when created
Each object has its own copy of instance variables

Real-world analogy: An object is like an actual house built from the blueprint.
Example scenario:

Class: Car (blueprint defining properties like color, model, speed)
Objects: myCar, yourCar, friendCar (actual cars with specific values)


📊 Instance Variables vs Local Variables
Instance Variables

Declared inside the class but outside any method
Belong to the object (each object gets its own copy)
Created when object is created, destroyed when object is destroyed
Have default values if not initialized (0 for numbers, null for objects, false for boolean)
Can be accessed throughout the class using this keyword
Scope: Entire class

Local Variables

Declared inside a method, constructor, or block
Belong to the method (exist only during method execution)
Created when method is called, destroyed when method completes
Do NOT have default values (must be initialized before use)
Cannot be accessed outside the method where declared
Scope: Only within the method/block

Key Difference: Instance variables persist as long as the object exists, while local variables exist only during method execution.

🏗️ Constructors
A constructor is a special method used to initialize objects when they are created.
Characteristics:

Has the same name as the class
No return type (not even void)
Called automatically when an object is created using new keyword
Used to set initial values for object attributes

Types of Constructors:
1. Default Constructor (No-Argument Constructor)

Takes no parameters
If you don't create any constructor, Java provides a default one automatically
Used when you want to create objects with default/standard values
Once you create a parameterized constructor, Java no longer provides the default one

2. Parameterized Constructor

Takes one or more parameters
Allows you to provide different values when creating different objects
Provides flexibility to initialize objects with custom values
You can have multiple parameterized constructors (constructor overloading)

Constructor Overloading

Having multiple constructors with different parameter lists in the same class
Java determines which constructor to call based on the arguments passed
Provides flexibility in object creation


🎯 The this Keyword
The this keyword is a reference variable that refers to the current object.
Uses of this:
1. Distinguish Between Instance Variables and Parameters
   When parameter names are the same as instance variable names, this helps differentiate them.
2. Call Other Constructors (Constructor Chaining)
   One constructor can call another constructor of the same class using this().
3. Pass Current Object as Parameter
   Can pass the current object to another method.
4. Return Current Object
   A method can return the current object using return this.
   Key Point: this always refers to the object on which the method is being called.

🔒 Access Modifiers
Access modifiers control the visibility and accessibility of classes, variables, methods, and constructors.
Types of Access Modifiers:
1. public

Most permissive
Accessible from anywhere - same class, same package, different package, subclass
Use when you want something to be universally accessible
Common for: methods that form the public interface of a class

2. private

Most restrictive
Accessible only within the same class
Not accessible from outside the class, not even from subclasses
Use for: data hiding, internal implementation details
Best practice: Keep instance variables private

3. default (package-private)

No keyword used (when you don't specify any modifier)
Accessible within the same package only
Not accessible from different packages
Use for: package-level features that shouldn't be exposed outside

4. protected

Accessible within the same package and by subclasses in any package
More restrictive than public, less restrictive than default
Use for: members that should be accessible to child classes
Common in: inheritance scenarios

Access Level Summary (from most to least restrictive):

private - same class only
default - same package
protected - same package + all subclasses
public - everywhere

Best Practices:

Start with the most restrictive access level
Only make things public if absolutely necessary
Keep instance variables private
Provide public getters/setters for controlled access


🛡️ Getters and Setters
Getters and Setters are public methods that provide controlled access to private instance variables.
Getter (Accessor Method)

Used to retrieve/read the value of a private variable
Naming convention: get + VariableName (e.g., getName())
For boolean variables: is + VariableName (e.g., isActive())
Returns the value of the private variable
Provides read access

Setter (Mutator Method)

Used to modify/write the value of a private variable
Naming convention: set + VariableName (e.g., setName())
Takes a parameter (new value)
Returns void (usually)
Provides write access

Why Use Getters and Setters?
1. Encapsulation

Hide internal representation
Control how data is accessed and modified

2. Validation

Can add validation logic before setting values
Prevent invalid data from being stored

3. Read-Only or Write-Only Fields

Provide only getter (read-only)
Provide only setter (write-only)

4. Flexibility

Can change internal implementation without affecting outside code
Can add logic (logging, notifications) when data changes

5. Computed Values

Getter can calculate and return values instead of just returning stored values

Best Practices:

Always make instance variables private
Provide public getters and setters as needed
Add validation in setters
Don't create getters/setters for every variable automatically - only when needed
Consider returning copies of mutable objects in getters (defensive copying)


🔐 Encapsulation
Encapsulation is one of the four fundamental OOP principles. It refers to bundling data (variables) and methods that operate on that data within a single unit (class), and restricting direct access to some of the object's components.
Key Concepts:
Data Hiding

Making instance variables private
Preventing direct access from outside the class
Protecting object's internal state from unauthorized access

Controlled Access

Providing public getter and setter methods
Controlling how data is read and modified
Adding validation and business logic

Benefits of Encapsulation:
1. Data Protection

Prevents invalid data from being set
Maintains object integrity

2. Flexibility

Internal implementation can change without affecting external code
Only the public interface needs to remain consistent

3. Maintainability

Changes are localized to the class
Easier to debug and modify

4. Increased Security

Sensitive data can be hidden
Access can be controlled and logged

5. Better Control

Can make fields read-only or write-only
Can validate before allowing changes

How to Achieve Encapsulation:

Declare instance variables as private
Create public getter methods to read values
Create public setter methods to write values (with validation)
Keep implementation details private
Expose only necessary functionality through public methods

Real-World Analogy:
Think of a television:

Internal circuits and components are hidden (private)
You interact through remote control buttons (public methods)
You don't need to know how it works internally
The manufacturer can change internal components without affecting how you use the remote


🎯 Why OOP for Automation Testing?
Page Object Model (POM) Benefits:

Each page is a class
Page elements are instance variables
Page actions are methods
Encapsulation keeps element locators private

Test Data Management:

User credentials as objects
Browser configurations as objects
Test environment settings as objects

Reusability:

Create objects once, use multiple times
Inheritance for common functionality
Reduce code duplication

Maintainability:

Changes in one place reflect everywhere
Easy to update locators or test data
Clear structure and organization


📝 Key Points to Remember

Class is a blueprint, Object is an instance
Instance variables belong to objects, local variables belong to methods
Constructors initialize objects; can be default or parameterized
this refers to the current object
Access modifiers control visibility: private → default → protected → public
Getters/Setters provide controlled access to private variables
Encapsulation = data hiding + controlled access through methods
Always prefer private variables with public getters/setters
Add validation in setters to maintain data integrity
Use meaningful names following Java naming conventions


🔄 OOP Principles (Brief Introduction)
While Day 7 focuses on foundation, here are the four pillars of OOP for context:

Encapsulation - Bundling data and methods, hiding internal details (covered today)
Inheritance - Creating new classes from existing ones (upcoming)
Polymorphism - One interface, multiple implementations (upcoming)
Abstraction - Hiding complexity, showing only essential features (upcoming)


✅ Day 7 Checklist

Understand difference between class and object
Know instance variables vs local variables
Understand default and parameterized constructors
Know when and how to use this keyword
Memorize all four access modifiers and their scope
Understand purpose of getters and setters
Grasp the concept of encapsulation
Practice creating classes with proper encapsulation
Apply OOP concepts to automation scenarios


💡 Quick Tips for Automation Testing

Keep page locators private, expose actions as public methods
Use constructors to initialize WebDriver or page elements
Create separate classes for different pages (LoginPage, HomePage, etc.)
Store test data in objects with proper encapsulation
Use getters to retrieve element states for assertions
Implement validation in setters for test configuration
