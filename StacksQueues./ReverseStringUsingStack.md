# Reverse String Using Stack 🔤

A Java program demonstrating how to reverse a string using the **Stack Data Structure**.

---

## 📌 Overview
This script illustrates the **LIFO (Last-In, First-Out)** property of stacks to reverse a given string. By pushing every character of a string onto the stack one by one, the last character entered ends up at the top, allowing us to pop them out in reverse order.

---

## ⚙️ Algorithm (Step-by-Step)

1. Initialize an empty `Stack<Character>`.
2. Iterate through each character of the input string (`"hello"`) and **push** each character onto the stack.
3. While the stack is **not empty**:
   * Print the top element using `stack.peek()`.
   * Remove the top element using `stack.pop()`. *(Alternatively, you can just use `stack.pop()` directly to retrieve and remove in one step).*

---

## 💻 Java Source Code

```java
import java.util.Stack;

public class ReverseStringUsingStack {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String str = "hello";

        // Push each character of the string onto the stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // Pop characters from the stack to get them in reverse order
        while (!stack.isEmpty()) {
            System.out.print(stack.peek()); // Prints the top character
            stack.pop();                    // Removes the top character
        }
    }
}
