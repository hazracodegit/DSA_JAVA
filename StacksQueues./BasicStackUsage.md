# Basic Stack Usage in Java 📚

A simple Java program demonstrating fundamental operations of the `Stack` data structure (`push`, `pop`, `isEmpty`, and `size`).

---

## 📌 Overview
This script illustrates how elements are added and removed from a Java `Stack` following the **LIFO (Last-In, First-Out)** principle, along with how to check its current status.

---

## ⚙️ Operations Breakdown

1. **`push(item)`**: Adds an item to the top of the stack.
2. **`pop()`**: Removes the top item from the stack.
3. **`isEmpty()`**: Returns `true` if the stack contains no items, otherwise `false`.
4. **`size()`**: Returns the number of elements currently in the stack.

---

## 💻 Java Source Code

```java
import java.util.Stack;

public class BasicStackUsage {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        // Pushing elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        // Stack state: [10, 20, 30, 40, 50] (top is 50)

        // Removing elements from the top (LIFO)
        stack.pop(); // Removes 50
        stack.pop(); // Removes 40
        // Stack state: [10, 20, 30] (top is 30)

        // Checking if the stack is empty
        System.out.println(stack.isEmpty()); // Output: false

        // Checking the current size of the stack
        System.out.println(stack.size());    // Output: 3
    }
}
