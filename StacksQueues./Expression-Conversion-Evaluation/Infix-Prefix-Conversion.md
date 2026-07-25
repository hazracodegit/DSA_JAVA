# Infix to Prefix Expression Conversion 📐➡️🔄

A comprehensive guide and Java implementation for converting an **Infix Expression** to a **Prefix Expression (Polish Notation)** using the **Stack Data Structure**.

---

## 📌 Problem Statement & Concepts

* **Infix Expression:** Operators are written *between* the operands (e.g., `A + B`). 
* **Prefix Expression (Polish Notation):** Operators come *before* their operands (e.g., `+AB`). 

### Example

* **Infix:** `A + B * C`
* **Prefix:** `+A*BC`

---

## 💡 Why use a Stack Data Structure?
* Just like infix-to-postfix conversion, prefix conversion requires managing operator precedence and associativity. 
* A **Stack** is used to temporarily hold operators and parentheses in the correct order, ensuring that mathematical hierarchy is respected.

---

## ⚙️ Algorithm Steps (The Reversal Method)

The cleanest and most standard way to convert Infix to Prefix is by leveraging the existing Infix-to-Postfix algorithm using these steps:

1. **Reverse the Infix expression:** 
   * Swap all opening parentheses `(` with closing parentheses `)` and vice-versa (e.g., `(A+B)` becomes `)(B+A(` then reversed structurally).
2. **Convert the reversed expression to Postfix:** 
   * Use the standard Infix-to-Postfix logic, with one minor adjustment for right-associative operators (like `^`).
3. **Reverse the resulting Postfix expression:** 
   * The final reversed postfix string gives you the correct **Prefix expression**.

---

## 💻 Java Source Code

```java
import java.util.Stack;

public class InfixToPrefix {

    // Method to return precedence of operators
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Method to convert Infix to Prefix
    public static String convertToPrefix(String expression) {
        StringBuilder reversedExpression = new StringBuilder();

        // Step 1: Reverse the string and swap brackets
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (c == '(') {
                reversedExpression.append(')');
            } else if (c == ')') {
                reversedExpression.append('(');
            } else {
                reversedExpression.append(c);
            }
        }

        // Step 2: Get Postfix of the reversed expression
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < reversedExpression.length(); i++) {
            char c = reversedExpression.charAt(i);

            // If operand, add to postfix
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }
            // If '(', push to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If ')', pop until '('
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            // An operator is encountered
            else {
                // Special handling for right-associative '^' operator
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        // Step 3: Reverse the postfix expression to get prefix
        return postfix.reverse().toString();
    }

    public static void main(String[] args) {
        String exp = "A+B*C+D";
        System.out.println("Infix: " + exp);
        System.out.println("Prefix: " + convertToPrefix(exp)); // Output: ++A*BCD
    }
}
