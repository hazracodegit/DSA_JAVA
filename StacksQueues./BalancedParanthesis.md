# Balanced Parenthesis Checker 🧩

A Java implementation to check whether a given string of brackets is balanced, utilizing the **Stack Data Structure**.

---

## 📌 Problem Statement
Given a string containing only opening and closing brackets (`(`, `)`, `{`, `}`, `[`, `]`), return `true` if it follows the rules of balanced parentheses, and `false` otherwise.

### Conditions for Balanced Parentheses:
1. Every closing bracket must have a corresponding opening bracket.
2. Every opening bracket must have a corresponding closing bracket.
3. The correct order/nesting of the brackets must be maintained.

---

## 💡 Why use a Stack Data Structure?
* **LIFO (Last-In, First-Out) Order:** Brackets follow a nested structure where the bracket that is *most recently opened* is the *first one to be closed*. 
* Because of this behavior, a **Stack** is the ideal data structure:
  * The opening bracket that appears first is closed **last**.
  * The opening bracket that appears last is closed **first**.

---

## 📋 Examples

| Input String | Output | Reason |
| :--- | :---: | :--- |
| `(){()[]}` | `true` | All brackets are properly opened, closed, and nested. |
| `([]}{}[)]` | `false` | Mismatched closing and opening brackets / incorrect order. |

---

## ⚙️ Algorithm (Step-by-Step)

1. Traverse the string character by character.
2. **If the character is an opening bracket** (`(`, `{`, `[`):
   * Push it onto the stack.
3. **If the character is a closing bracket** (`)`, `}`, `]`):
   * **Check 1:** The stack must **not** be empty. If it is empty, there is no matching opening bracket $\rightarrow$ return `false`.
   * **Check 2:** Pop the top element from the stack and verify if it matches the current closing bracket.
   * **Check 3:** If it doesn't match $\rightarrow$ return `false`.
4. **At the end of traversal:**
   * **Check 1:** The stack **must be empty** (meaning all opening brackets were successfully closed) $\rightarrow$ return `true`.
   * **Check 2:** If the stack is not empty (unclosed opening brackets remain) $\rightarrow$ return `false`.

---

## 💻 Java Source Code

```java
import java.util.Stack;

public class BalancedParenthesis {

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // If opening bracket → push onto stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // If closing bracket
            else {
                // Stack empty → no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check matching pair
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty → balanced, otherwise unbalanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[()]}";
        System.out.println(isBalanced(s)); // Output: true
    }
}
