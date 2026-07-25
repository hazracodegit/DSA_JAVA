# Prefix Expression Evaluation 🧮⬅️

A comprehensive guide and Java implementation for evaluating a **Prefix Expression (Polish Notation)** using the **Stack Data Structure**.

---

## 📌 Problem Statement & Concepts

* **Prefix Expression (Polish Notation):** Operators appear *before* their operands (e.g., `+AB`). 
* **Evaluation Objective:** Given a valid prefix expression (typically space-separated to support multi-digit numbers), compute and return the final numerical result.

### Example

* **Prefix Expression:** `+ * 2 3 5` (equivalent to infix `(2 * 3) + 5`)
* **Step-by-Step Execution (Scanning Right-to-Left):**
  1. Scan `5` $\rightarrow$ Push `5` $\rightarrow$ Stack: `[5]`
  2. Scan `3` $\rightarrow$ Push `3` $\rightarrow$ Stack: `[5, 3]`
  3. Scan `2` $\rightarrow$ Push `2` $\rightarrow$ Stack: `[5, 3, 2]`
  4. Scan `*`: Pop `2` as `val1` and `3` as `val2`, compute `2 * 3 = 6`, push `6` $\rightarrow$ Stack: `[5, 6]`
  5. Scan `+`: Pop `6` as `val1` and `5` as `val2`, compute `6 + 5 = 11`, push `11` $\rightarrow$ Stack: `[11]`
* **Final Output:** `11`

---

## 💡 Why use a Stack Data Structure?
* Unlike postfix evaluation which scans from left-to-right, **prefix evaluation scans from right-to-left**. 
* As we scan backwards, operands are pushed onto the stack, and when an operator is encountered, the top elements of the stack are popped to perform the operation in the correct order.

---

## ⚙️ Algorithm (Step-by-Step)

1. Split the input expression by spaces into an array of tokens.
2. Initialize an empty `Stack<Integer>` to store operands.
3. **Iterate through the tokens from right-to-left** (from the last element back to the first):
   * **If the token is a number** (parsed using `Integer.parseInt()`): **Push** it onto the stack.
   * **If the token is an operator** (`+`, `-`, `*`, `/`, `^`):
     * Pop the top element from the stack as the **first operand** (`val1`).
     * Pop the next element from the stack as the **second operand** (`val2`).
     * Perform the operation: `result = val1 [operator] val2`. *(Note the order: val1 comes first because it appeared closer to the operator when scanning right-to-left).*
     * **Push** the resulting value back onto the stack.
4. After the loop finishes, return the final remaining value in the stack.

---

## 💻 Java Source Code

```java
import java.util.Stack;

public class PrefixEvaluation {

    public static int evaluatePrefix(String exp) {
        Stack<Integer> stack = new Stack<>();

        // Split the expression by spaces into tokens
        String[] tokens = exp.split("\\s+");

        // Iterate through tokens from right to left
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            // If the token is empty, skip it
            if (token.isEmpty()) {
                continue;
            }

            // Check if the token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^")) {
                int val1 = stack.pop(); // First operand
                int val2 = stack.pop(); // Second operand

                switch (token) {
                    case "+":
                        stack.push(val1 + val2);
                        break;
                    case "-":
                        stack.push(val1 - val2);
                        break;
                    case "*":
                        stack.push(val1 * val2);
                        break;
                    case "/":
                        stack.push(val1 / val2);
                        break;
                    case "^":
                        stack.push((int) Math.pow(val1, val2));
                        break;
                }
            } 
            // Otherwise, the token is a number
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        // The final result is the only element left on the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String exp = "+ * 2 3 5";
        System.out.println("Prefix Expression: " + exp);
        System.out.println("Evaluation Result: " + evaluatePrefix(exp)); // Output: 11
    }
}
