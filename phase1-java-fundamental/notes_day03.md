Part 1: Arrays
1.1 What is an Array?
An array is a container that holds a fixed number of values of a single data type.
Real-world analogy:

Think of an array like a row of lockers in a gym
Each locker has a number (index) starting from 0
All lockers store the same type of items (only shoes, only bags, etc.)
The number of lockers is fixed - you can't add more once built

Why do we need arrays?
Without arrays:
String browser1 = "Chrome";
String browser2 = "Firefox";
String browser3 = "Edge";
String browser4 = "Safari";
String browser5 = "Opera";
// Imagine handling 100 browsers this way! 😱
With arrays:
String[] browsers = {"Chrome", "Firefox", "Edge", "Safari", "Opera"};
// All in one place! Easy to manage! 😊

1.2 Array Characteristics
CharacteristicDescriptionFixed SizeOnce created, size cannot changeSame Data TypeAll elements must be the same type (all String, all int, etc.)Index-BasedAccess elements using index (position) starting from 0Contiguous MemoryElements are stored in consecutive memory locationsFast AccessDirect access to any element using index - O(1) time complexity

1.3 Array Index
Important concept: Array indexing starts at 0, not 1!
Array: ["Chrome", "Firefox", "Edge", "Safari"]
Index:     0         1         2        3

Total elements (length): 4
Valid indices: 0, 1, 2, 3
Last index: length - 1 = 3
Why index starts at 0?

Historical reason from C programming
Represents offset from the start of array in memory
Most programming languages follow this convention


1.4 Types of Arrays
A) One-Dimensional Array (1D Array)
A simple list of elements in a single row.
Syntax:
dataType[] arrayName = new dataType[size];
Visual representation:
browsers = ["Chrome", "Firefox", "Edge"]
Index 0    Index 1    Index 2
Common uses in Selenium:

Store multiple test data values (usernames, URLs, browser names)
Store locator values
Store expected vs actual results


B) Two-Dimensional Array (2D Array)
An array of arrays - represents data in rows and columns (like a table).
Syntax:
dataType[][] arrayName = new dataType[rows][columns];
Visual representation:
loginData = [
["user1@test.com", "pass123"],    ← Row 0
["user2@test.com", "pass456"],    ← Row 1
["user3@test.com", "pass789"]     ← Row 2
]
Column 0          Column 1
Common uses in Selenium:

Store username-password pairs
Store multiple test scenarios with inputs and expected outputs
Represent test data tables (like Excel data)


1.5 Array Declaration Methods
Method 1: Declare, then initialize
String[] browsers;                    // Declaration
browsers = new String[3];             // Memory allocation
browsers[0] = "Chrome";               // Assignment
browsers[1] = "Firefox";
browsers[2] = "Edge";
Method 2: Declare and initialize separately
String[] browsers = new String[3];    // Declare + allocate memory
browsers[0] = "Chrome";               // Then assign values
browsers[1] = "Firefox";
browsers[2] = "Edge";
Method 3: Declare and initialize together (Array Literal)
String[] browsers = {"Chrome", "Firefox", "Edge"};
// Size is automatically calculated (3 in this case)
Method 4: Using 'new' with values
String[] browsers = new String[]{"Chrome", "Firefox", "Edge"};
Best practice: Use Method 3 (array literal) when you know values upfront - it's concise and readable.

1.6 Array Operations
Accessing Elements
arrayName[index]

Returns the element at specified index
Throws ArrayIndexOutOfBoundsException if index is invalid

Modifying Elements
arrayName[index] = newValue;

Updates the element at specified index

Getting Array Length
arrayName.length

Returns the total number of elements
Note: It's a property, not a method (no parentheses)

Traversing (Looping Through) Arrays
Option 1: Traditional for loop
for (int i = 0; i < arrayName.length; i++) {
// Access element using arrayName[i]
}

Use when you need the index
More control over iteration

Option 2: Enhanced for loop (for-each)
for (dataType element : arrayName) {
// 'element' holds the current value
}

Use when you only need the values
More readable and concise
Cannot modify original array


1.7 Array Limitations
LimitationDescriptionImpactFixed SizeCannot add/remove elements after creationIf you need 1 more element, must create new arrayNo Built-in MethodsLimited functionalityNo easy way to search, sort, or insertCannot Store Mixed TypesAll elements must be same typeCannot mix String and int in same arrayManual Size ManagementMust track how many elements are actually usedExtra complexity in code
Example of limitation:
String[] browsers = new String[3];
browsers[0] = "Chrome";
browsers[1] = "Firefox";
browsers[2] = "Edge";
// Now you want to add "Safari" - NOT POSSIBLE!
// Must create new array with size 4 and copy all elements

Part 2: ArrayList
2.1 What is ArrayList?
ArrayList is a resizable array implementation in Java. It's part of Java's Collection Framework.
Key differences from Array:

Dynamic size - automatically grows/shrinks
Rich methods - built-in functionality for add, remove, search, etc.
Only stores objects - cannot store primitive types directly (must use wrapper classes)

Real-world analogy:

Array = Fixed parking lot with numbered spaces
ArrayList = Expandable parking lot that adds spaces as more cars arrive


2.2 ArrayList Characteristics
CharacteristicDescriptionDynamic SizeAutomatically resizes when elements are added/removedFlexibleCan insert, delete, search elements easilyType-SafeUses generics <Type> to ensure type safetyZero-IndexedLike arrays, indexing starts at 0Allows DuplicatesCan store duplicate valuesMaintains OrderElements stay in insertion order

2.3 ArrayList Syntax
Import Statement
import java.util.ArrayList;

Required at the top of your Java file
ArrayList is not built-in; it's in java.util package

Declaration
ArrayList<DataType> name = new ArrayList<>();
Components explained:

ArrayList - The class name
<DataType> - Generic type (what type of data it holds)
name - Variable name
new ArrayList<>() - Creates new ArrayList object
<> - Diamond operator (type inference in Java 7+)

Examples:
ArrayList<String> names = new ArrayList<>();      // Stores Strings
ArrayList<Integer> numbers = new ArrayList<>();   // Stores Integers
ArrayList<Boolean> flags = new ArrayList<>();     // Stores Booleans

2.4 Important ArrayList Methods
Adding Elements
MethodDescriptionExampleadd(element)Adds element at the endlist.add("Chrome")add(index, element)Inserts element at specific positionlist.add(1, "Firefox")
Accessing Elements
MethodDescriptionExampleget(index)Returns element at specified indexString browser = list.get(0)size()Returns number of elementsint total = list.size()
Modifying Elements
MethodDescriptionExampleset(index, element)Replaces element at specified indexlist.set(0, "Edge")
Removing Elements
MethodDescriptionExampleremove(index)Removes element at specified indexlist.remove(1)remove(object)Removes first occurrence of objectlist.remove("Chrome")clear()Removes all elementslist.clear()
Searching Elements
MethodDescriptionReturn ValueExamplecontains(object)Checks if element existstrue or falselist.contains("Chrome")indexOf(object)Returns index of first occurrenceIndex number or -1 if not foundlist.indexOf("Firefox")
Checking Status
MethodDescriptionReturn ValueExampleisEmpty()Checks if list is emptytrue or falselist.isEmpty()size()Returns number of elementsIntegerlist.size()

2.5 ArrayList Traversal Methods
Method 1: Traditional for loop
for (int i = 0; i < list.size(); i++) {
String element = list.get(i);
// Use element and index
}

Use when you need index

Method 2: Enhanced for loop
for (String element : list) {
// Use element directly
}

Use when you only need values
Most common and readable

Method 3: forEach with Lambda (Java 8+)
list.forEach(element -> {
// Use element
});

Modern Java approach
Functional programming style


2.6 Wrapper Classes
ArrayList cannot store primitive types (int, boolean, char, etc.) directly. Must use wrapper classes.
Primitive TypeWrapper ClassExampleintIntegerArrayList<Integer>doubleDoubleArrayList<Double>booleanBooleanArrayList<Boolean>charCharacterArrayList<Character>
Example:
// ❌ Wrong - cannot use primitive
ArrayList<int> numbers = new ArrayList<>();

// ✅ Correct - use wrapper class
ArrayList<Integer> numbers = new ArrayList<>();
Note: Java automatically converts between primitive and wrapper (called autoboxing/unboxing).

Part 3: Array vs ArrayList - Complete Comparison
3.1 Detailed Comparison Table
FeatureArrayArrayListSizeFixed - decided at creationDynamic - grows/shrinks automaticallySyntaxString[] arr = new String[5]ArrayList<String> list = new ArrayList<>()Data TypesCan store primitives and objectsOnly stores objects (use wrappers for primitives)PerformanceFaster - less overheadSlightly slower - more functionalityLength/Sizearr.length (property)list.size() (method)Access Elementarr[0]list.get(0)Modify Elementarr[0] = "value"list.set(0, "value")Add ElementNot possiblelist.add("value")Remove ElementNot possible (can only set to null)list.remove(0) or list.remove("value")MemoryEfficient - contiguous memoryLess efficient - overhead for resizingBuilt-in MethodsVery limitedRich set of methodsType SafetyLimitedBetter with generics <Type>Multi-dimensionalYes - int[][]Not directly (use ArrayList<ArrayList<>>)

3.2 When to Use Array?
Use Array when:
✅ You know the exact size beforehand
String[] weekDays = new String[7];  // Always 7 days
✅ Need better performance (speed matters)
int[] priorities = {1, 2, 3, 1, 2};  // Fixed priorities
✅ Working with primitive types extensively
int[] testScores = new int[100];  // Storing int values
✅ Need multi-dimensional structures
String[][] testData = new String[10][3];  // Table structure
✅ Memory constraints (arrays use less memory)
Examples in Selenium:

Fixed set of browser names
Known number of test priorities
Locator strategy types (ID, Name, CSS, XPath - always 8)


3.3 When to Use ArrayList?
Use ArrayList when:
✅ Size is unknown or changes frequently
ArrayList<String> dynamicTests = new ArrayList<>();
// Can keep adding tests as discovered
✅ Need to add/remove elements dynamically
testResults.add("Test 1 - Pass");
testResults.remove("Test 5 - Skip");
✅ Need built-in methods (search, contains, etc.)
if (browsers.contains("Chrome")) {
// Do something
}
✅ Working with Collections framework (sorting, filtering)
Collections.sort(testNames);  // Easy sorting
✅ Storing objects (String, custom classes)
ArrayList<User> users = new ArrayList<>();  // Store User objects
Examples in Selenium:

Storing WebElement references (number varies)
Collecting dropdown options dynamically
Tracking test results during execution
Storing dynamic test data from external sources


3.4 Performance Comparison
OperationArrayArrayListWinnerAccess by indexO(1) - ConstantO(1) - ConstantTie ✅Add at endN/AO(1) - AmortizedArrayList ✅Add at specific indexN/AO(n) - LinearArrayList ✅RemoveN/AO(n) - LinearArrayList ✅SearchO(n) - LinearO(n) - LinearTie ✅Memory usageLessMore (overhead)Array ✅Creation speedFasterSlowerArray ✅
Notation explained:

O(1) = Constant time - always same speed regardless of size
O(n) = Linear time - time increases with size
Amortized = Average time over many operations


Part 4: Practical Selenium Context
4.1 Common Selenium Use Cases
Arrays in Selenium:
1. Fixed Test Data
   String[] browsers = {"Chrome", "Firefox", "Edge"};
   String[] environments = {"DEV", "QA", "STAGING", "PROD"};
2. Known Locator Strategies
   String[] locatorTypes = {"id", "name", "className", "xpath", "cssSelector"};
3. Test Priorities
   int[] priorities = {1, 2, 3, 1, 2};  // Test execution priorities

ArrayList in Selenium:
1. Dynamic WebElement Collections
   ArrayList<String> dropdownOptions = new ArrayList<>();
   // Fetch all options dynamically from dropdown
2. Test Execution Tracking
   ArrayList<String> passedTests = new ArrayList<>();
   ArrayList<String> failedTests = new ArrayList<>();
   // Add tests as they execute
3. Data-Driven Testing
   ArrayList<String> testUsers = new ArrayList<>();
   // Read users from Excel/Database - size unknown
4. Page Links Collection
   ArrayList<String> allLinks = new ArrayList<>();
   // Collect all hrefs from a page dynamically
5. Test Reports
   ArrayList<String> testSteps = new ArrayList<>();
   testSteps.add("Step 1: Open browser");
   testSteps.add("Step 2: Navigate to URL");
   // Steps added dynamically during test

4.2 Data-Driven Testing Example
Scenario: Testing login with multiple user credentials
Using Array (Fixed data):
String[] usernames = {"user1@test.com", "user2@test.com", "user3@test.com"};
String[] passwords = {"pass123", "pass456", "pass789"};

// Loop through all users
for (int i = 0; i < usernames.length; i++) {
// Test login with usernames[i] and passwords[i]
}
Using ArrayList (Dynamic data from file/DB):
ArrayList<String> usernames = new ArrayList<>();
ArrayList<String> passwords = new ArrayList<>();

// Read from Excel file - don't know how many rows
while (hasNextRow) {
usernames.add(readUsername());
passwords.add(readPassword());
}

// Loop through all users
for (int i = 0; i < usernames.size(); i++) {
// Test login with usernames.get(i) and passwords.get(i)
}
