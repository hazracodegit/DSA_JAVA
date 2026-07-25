# Minimum String Length After Removing Substrings ✂️

A Java solution for the **"Minimum String Length After Removing Substrings"** problem using the **Stack Data Structure**.

---

## 📌 Problem Statement
You are given a string `s` consisting only of uppercase English letters. You can repeatedly remove any occurrence of the substrings `"AB"` or `"CD"` from `s`. 

* Note that after removing a substring, the remaining parts concatenate, which can potentially create new `"AB"` or `"CD"` substrings.
* Return the **minimum possible length** of the resulting string after performing all possible operations.

### Examples

| Input String (`s`) | Output | Explanation |
| :--- | :---: | :--- |
| `"ABFCACDB"` | `2` | Removing `"AB"`, `"CD"`, and then the newly formed `"AB"` results in `"FC"`, length `2`. |
| `"ACBBD"` | `5` | No `"AB"` or `"CD"` substrings exist initially, so the length remains unchanged. |

---

## 💡 Why use a Stack Data Structure?
* This is a classic cancellation problem. When `"AB"` or `"CD"` is removed, characters that were previously separated become adjacent, potentially forming new matching pairs.
* A **Stack** keeps track of the preceding characters dynamically, allowing us to check the top element (`stack.peek()`) in $\mathcal{O}(1)$ time to instantly catch and pop valid pairs (`A` followed by `B`, or `C` followed by `D`).

---

## ⚙️ Algorithm (Step-by-Step)

1. Initialize an empty `Stack<Character>`.
2. Iterate through each character `ch` in the string:
   * Check if the stack is **not empty** and if the top of the stack combined with `ch` forms `"AB"` (`stack.peek() == 'A'` and `ch == 'B'`) or `"CD"` (`stack.peek() == 'C'` and `ch == 'D'`).
   * **If a match occurs:** Pop the top element from the stack (effectively removing both characters).
   * **Otherwise:** Push `ch` onto the stack.
3. After checking all characters, return the **size of the stack**, which represents the minimum length of the remaining string.

---

## 💻 Java Source Code

```java
import java.util.Stack;

public class MinimumStringLength {

    public static int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // Check if current character forms "AB" or "CD" with the stack's top
            if (!stack.isEmpty() && 
                ((stack.peek() == 'A' && ch == 'B') || 
                 (stack.peek() == 'C' && ch == 'D'))) {
                
                // Remove the matching opening character
                stack.pop();
            } else {
                // Otherwise, push the current character onto the stack
                stack.push(ch);
            }
        }

        // The remaining size of the stack is the minimum length of the string
        return stack.size();
    }

    public static void main(String[] args) {
        String s = "ABFCACDB";
        System.out.println(minLength(s)); // Output: 2
    }
}
