Day 1 – Java Control Flow Revision (For Selenium Automation)

## Objective
Revise core Java control flow concepts that are **directly used in Selenium automation**, focusing on clarity, decision-making, and execution flow rather than syntax memorization.

This day is a **revision**, not relearning Java.

---

## Topics Covered

### 1. Variables in Automation Context
Used to store:
- Test names
- Environment details (DEV, QA, STAGING, PROD)
- Browser type (Chrome, Firefox, Edge)
- Retry counts
- Performance timings
- Test status flags

**Common data types used in Selenium:**
- `String` → URLs, locators, environment, browser
    - Example: `String testUrl = "https://example.com/login";`
- `int` → retries, counts, indexes
    - Example: `int maxRetries = 3;`
- `double` → page load time, execution time (requires decimal precision)
    - Example: `double pageLoadTime = 2.4;`
- `boolean` → pass/fail flags, visibility checks, element state
    - Example: `boolean isElementVisible = true;`

**Best Practice:**
- Use meaningful variable names
    - ✅ `maxRetries` instead of ❌ `mr` or `x`
- Avoid magic numbers
    - ✅ `if (retryCount < maxRetries)` instead of ❌ `if (retryCount < 3)`
- Keep variables readable and intention-revealing
    - Variable name should explain its purpose without needing comments

---

### 2. Conditional Statements (`if / else`)
Used to make **decisions during test execution**.

**Automation use cases:**
- **Pass / Fail determination**
    - Check if assertions passed
- **Performance threshold validation**
    - Verify page loads within acceptable time
- **Environment safety checks**
    - Prevent destructive operations in production
- **Feature enable/disable logic**
    - Run tests only when feature flags are enabled

**Example logic:**
```java
if (testPassed) {
    // Log success
    System.out.println("Test Status: PASS");
} else {
    // Log failure and take action (screenshot, stack trace)
    System.out.println("Test Status: FAIL");
}
```

**Key Points:**
- Conditions evaluate to `true` or `false`
- Comparison operators: `==`, `!=`, `<`, `>`, `<=`, `>=`
- Logical operators: `&&` (AND), `||` (OR), `!` (NOT)

---

### 3. Environment Safety Checks
Automation should behave differently based on environment.

**Typical rule:**
- ✅ Allow execution in QA / STAGE
- ❌ Block destructive execution in PROD

**Implementation:**
```java
boolean isProduction = environment.equalsIgnoreCase("prod");
if (!isProduction) {
    // Safe to execute tests
} else {
    // Block execution
}
```

**Used with:**
- `equalsIgnoreCase()` → Case-insensitive string comparison
    - Handles "PROD", "prod", "Prod" consistently
- Logical NOT (`!`) → Inverts boolean value
    - `!true` becomes `false`
    - `!false` becomes `true`

**Why This Matters:**
Prevents accidental data corruption, deletion, or unwanted API calls in production environments during test runs.

---

### 4. Retry Logic (Core Automation Concept)
Retry logic helps handle:
- Network instability (temporary timeouts)
- Flaky elements (StaleElementReferenceException)
- Temporary application issues (slow server response)
- Asynchronous operations (AJAX, dynamic loading)

**Key components:**
- **Maximum retry limit** → Prevents infinite loops
- **Retry counter** → Tracks current attempt
- **Exit condition** → Success OR max retries reached

**Implementation Pattern:**
```java
int maxRetries = 3;
int retryCount = 0;
boolean testPassed = false;

while (retryCount < maxRetries && !testPassed) {
    // Attempt test execution
    retryCount++;
    
    // Check if passed
    if (conditionMet) {
        testPassed = true;
    }
}
```

**Important rule:**
- ❌ Never retry infinitely
- ✅ Always fail gracefully after max retries
- 📊 Log each retry attempt for debugging

**Real-World Example:**
Selenium WebDriver waiting for an element to become clickable with retries.

---

### 5. Loops (Controlled Usage)
Loops are used to:
- Retry test steps until condition met
- Simulate repeated execution (stress testing)
- Poll for conditions (wait strategies)
- Iterate through test data sets

**Used loops:**

**`while` loop** → Retry until condition met (unknown iterations)
```java
while (retryCount < maxRetries && !testPassed) {
    // Execute test logic
}
```
- Used when number of iterations is **unknown**
- Condition checked **before** each iteration

**`for` loop** → Controlled iteration (known iterations)
```java
for (int i = 1; i <= 3; i++) {
    // Execute test run
}
```
- Used when number of iterations is **known** in advance
- Clear start, end, and increment

**Loops should always have:**
- ✅ Clear exit condition
- ✅ Predictable execution count
- ✅ Protection against infinite loops

---

### 6. Advanced Control Flow
Includes:
- `break` → Stop execution on critical failure
- `continue` → Skip current iteration
- Nested `if` → Layered validation logic

**Automation examples:**

**`break` - Exit Loop Immediately**
```java
if (criticalError) {
    System.out.println("Critical issue detected");
    break; // Stop all further iterations
}
```
- Use case: Stop test suite on critical environment failure

**`continue` - Skip Current Iteration**
```java
if (shouldSkip) {
    System.out.println("Skipping optional step");
    continue; // Jump to next iteration
}
```
- Use case: Skip non-critical test steps that are temporarily unavailable

**Nested `if` - Layered Validation**
```java
if (elementVisible) {
    if (elementEnabled) {
        // Element is ready for interaction
        element.click();
    } else {
        // Element visible but disabled
    }
} else {
    // Element not visible
}
```
- Use case: Validate element readiness (visible + enabled) before interaction
- Prevents `ElementNotInteractableException` in Selenium

**Why This Matters:**
Advanced control flow provides granular control over test execution, allowing tests to handle edge cases gracefully.

---

### 7. Percentage & Result Calculation
Used in:
- **Test reports** (pass/fail summary)
- **Pass percentage** (quality metrics)
- **Coverage metrics** (how much of app is tested)
- **Performance benchmarking** (success rate over time)

**Formula used:**
```
passPercentage = (passCount / totalCount) × 100
```

**Implementation:**
```java
int totalTests = 10;
int passedTests = 8;

// Type casting required for accurate decimal division
double passPercentage = (passedTests / (double) totalTests) * 100;

System.out.println("Pass percentage: " + passPercentage + "%");
// Output: Pass percentage: 80.0%
```

**Critical Point - Type Casting:**
- ❌ Without casting: `8 / 10 = 0` (integer division truncates)
- ✅ With casting: `8 / 10.0 = 0.8` (decimal division)

**Why Cast to `double`?**
Integer division in Java discards the decimal portion. Casting one operand to `double` forces decimal division, giving accurate percentages.

**Alternative Approach:**
```java
double passPercentage = (passedTests * 100.0) / totalTests;
```
Multiplying by `100.0` (double) automatically converts the calculation to floating-point.

---

## Package Structure Used
```text
src/main/java/day1/controlflow
├── JavaVariablesAndConditions.java      # Variables, if/else, environment checks
├── JavaRetryAndLoopLogic.java           # while loop, for loop, retry patterns
└── JavaAdvancedControlFlow.java         # break, continue, nested conditions, casting
```

**Why This Structure?**
- Organized by concept for easy navigation
- Reflects real automation framework packages
- Separates concerns (basic → intermediate → advanced)

---

## Key Takeaways for Selenium Automation

1. **Variables** store test configuration and state
2. **Conditionals** drive test decision-making (pass/fail, environment)
3. **Loops** enable retries and polling for dynamic web elements
4. **Break/Continue** provide fine-grained execution control
5. **Type casting** ensures accurate calculations in reports
