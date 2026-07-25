# Make The String Great ✨

A Java solution for the **"Make The String Great"** problem using the **Stack Data Structure**.

---

## 📌 Problem Statement
Given a string `s` of lower and upper case English letters:
* A **good string** does not have two adjacent characters `s[i]` and `s[i + 1]` where one is the lowercase and the other is the uppercase version of the same letter (or vice-versa).
* To make a string good, you can choose two adjacent characters that make it bad and remove them, repeating this process until the string is good.
* Return the final good string. (An empty string is also considered good).

### Examples

| Input String (`s`) | Output | Explanation |
| :--- | :---: | :--- |
| `"leEeetcode"` | `"leetcode"` | Removing `"eE"` or `"Ee"` reduces the string to `"leetcode"`. |
| `"abBAcC"` | `""` | Repeated removal of adjacent opposing cases results in an empty string. |

---

## 💡 Why use a Stack Data Structure?
* This problem requires checking adjacent characters and eliminating them dynamically. When a pair is eliminated, the characters that were previously separated by them become adjacent.
* A **Stack** naturally tracks the current sequence of characters and allows us to look at the most recently added character (`stack.peek()`) to check for a bad pair in $\mathcal{O}(1)$ time.

---

## ⚙️ Algorithm (Step-by-Step)

1. Initialize an empty `Stack<Character>`.
2. Iterate through each character `ch` in the string:
   * Check if the stack is **not empty** and if `ch` forms a bad pair with the top of the stack (same letter, opposite cases).
   * **If it's a bad pair:** Pop the top element from the stack (canceling out both characters).
   * **Otherwise:** Push `ch` onto the stack.
3. After the loop, reconstruct the final string from the remaining elements in the stack using a `StringBuilder` and return it.

---

## 💻 Java Source Code

```java
import java.util.Stack;

public class MakeTheStringGreat {

    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // Check if stack is not empty and forms a bad pair with the top element
            if (!stack.isEmpty() &&
                Character.toLowerCase(ch) == Character.toLowerCase(stack.peek()) &&
                ((Character.isUpperCase(ch) && Character.isLowerCase(stack.peek())) ||
                 (Character.isLowerCase(ch) && Character.isUpperCase(stack.peek())))) {
                
                // Remove the matching bad character from the stack
                stack.pop();
            } else {
                // Otherwise, push the current character onto the stack
                stack.push(ch);
            }
        }

        // Reconstruct the final string from the stack
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(makeGood(s)); // Output: leetcode
    }
}
