# Remove All Adjacent Duplicates In String 🗑️

A Java solution for the **"Remove All Adjacent Duplicates In String"** problem using the **Stack Data Structure**.

---

## 📌 Problem Statement
You are given a string `s` consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them. 

* We repeatedly make duplicate removals on `s` until no more adjacent duplicates remain.
* Return the final string after all such duplicate removals have been made. (The answer is guaranteed to be unique).

### Examples

| Input String (`s`) | Output | Explanation |
| :--- | :---: | :--- |
| `"abbaca"` | `"ca"` | Remove `"bb"` $\rightarrow$ `"aaca"`, then remove `"aa"` $\rightarrow$ `"ca"`. |
| `"azxxzy"` | `"ay"` | Remove `"xx"` $\rightarrow$ `"azzy"`, then remove `"zz"` $\rightarrow$ `"ay"`. |

---

## 💡 Why use a Stack Data Structure?
* Adjacent duplicates naturally follow a **LIFO (Last-In, First-Out)** order. 
* When a pair of duplicates is removed, a new adjacency is created with the preceding character. A **Stack** efficiently keeps track of the preceding sequence, allowing us to inspect the top element (`stack.peek()`) in $\mathcal{O}(1)$ time.

---

## ⚙️ Algorithm (Step-by-Step)

1. Initialize an empty `Stack<Character>`.
2. Iterate through each character `ch` of the string:
   * **Check:** If the stack is **not empty** and the top element of the stack equals the current character `ch` (`stack.peek() == ch`).
   * **If they match:** Pop the top element from the stack (removing the duplicate pair).
   * **Otherwise:** Push `ch` onto the stack.
3. After the loop finishes, reconstruct the final string from the remaining characters in the stack using a `StringBuilder` and return it.

---

## 💻 Java Source Code

```java
import java.util.Stack;

public class RemoveAdjacentDuplicates {

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // If stack is not empty and the top matches the current character
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop(); // Remove the duplicate
            } else {
                stack.push(ch); // Otherwise, add character to stack
            }
        }

        // Reconstruct the string from the stack elements
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s)); // Output: ca
    }
}
