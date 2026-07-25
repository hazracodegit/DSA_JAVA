# Evaluating Postfix Expressions with Multi-Digit Numbers 🔢

A Java solution and guide for evaluating **Postfix Expressions** where operands can consist of multiple digits or negative numbers, separated by spaces.

---

## 📌 The Multi-Digit Challenge
In standard simple expressions (like `"23*5+"`), every character is a single digit. However, real-world expressions often contain numbers like `15`, `120`, or negative numbers. 

* **The Problem:** If we read character by character, we would treat `15` as two separate operands (`1` and `5`) instead of a single number.
* **The Solution:** We use spaces to separate tokens (operands and operators) and parse tokens using a `String` array or `StringTokenizer`.

---

## 💡 Example with Spaces

* **Expression:** `"10 2 3 * + 5 -"` (equivalent to infix `10 + (2 * 3) - 5`)
* **Step-by-Step Execution:**
  1. Push `10` $\rightarrow$ Stack: `[10]`
  2. Push `2` $\rightarrow$ Stack: `[10, 2]`
  3. Push `3` $\rightarrow$ Stack: `[10, 2, 3]`
  4. Encounter `*`: Pop `3` and `2`, compute `2 * 3 = 6`, push `6` $\rightarrow$ Stack: `[10, 6]`
  5. Encounter `+`: Pop `6` and `10`, compute `10 + 6 = 16`, push `16` $\rightarrow$ Stack: `[16]`
  6. Push `5` $\rightarrow$ Stack: `[16, 5]`
  7. Encounter `-`: Pop `5` and `16`, compute `16 - 5 = 11`, push `11` $\rightarrow$ Stack: `[11]`
* **Final Output:** `11`

---

## ⚙️ Algorithm (Step-by-Step)

1. Split the input string by spaces (`" "`) into an array of tokens.
2. Initialize an empty `Stack<Integer>`.
3. Iterate through each token:
   * **If the token is a number** (can be parsed using `Integer.parseInt()`): Convert it to an integer and **push** it onto the stack.
   * **If the token is an operator** (`+`, `-`, `*`, `/`, `^`):
     * Pop `val2` (second operand) and `val1` (first operand) from the stack.
     * Perform the arithmetic operation.
     * Push the result back onto the stack.
4. Return the final remaining element in the stack.

---

## 💻 Java Source Code

```java
import java.util.Stack;

public class PostfixEvaluationMultiDigit {

    public static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        // Split the expression by spaces to handle multi-digit numbers properly
        String[] tokens = exp.split("\\s+");

        for (String token : tokens) {
            // If the token is empty, skip it
            if (token.isEmpty()) {
                continue;
            }

            // Check if the token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^")) {
                int val2 = stack.pop(); // Second operand
                int val1 = stack.pop(); // First operand

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
            // Otherwise, the token is a multi-digit number
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        // The final result is the only element left on the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String exp = "10 2 3 * + 5 -";
        System.out.println("Postfix Expression: " + exp);
        System.out.println("Evaluation Result: " + evaluatePostfix(exp)); // Output: 11
    }
}
