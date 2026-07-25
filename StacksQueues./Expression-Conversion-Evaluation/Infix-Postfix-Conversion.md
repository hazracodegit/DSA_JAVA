# Infix to Postfix Expression Conversion 📐➡️📝

A comprehensive guide and Java implementation for converting an **Infix Expression** to a **Postfix Expression** using the **Stack Data Structure**.

---

## 📌 Problem Statement & Concepts

* **Infix Expression:** Operators are written *between* the operands (e.g., `A + B`). This is how humans naturally write expressions.
* **Postfix Expression (Reverse Polish Notation):** Operators come *after* their operands (e.g., `AB+`). This notation eliminates the need for parentheses and is much easier for computers and stack-based systems to evaluate.

### Example

* **Infix:** `A + B * C`
* **Postfix:** `ABC*+`

---

## 💡 Why use a Stack Data Structure?
* Operators have strict **precedence** and **associativity** rules. 
* A **Stack** allows us to temporarily hold operators while we scan the infix expression, ensuring higher-precedence operators are processed first and maintaining the correct order of operations.

---

## ⚙️ Operator Precedence & Associativity Rules

1. **Precedence:**
   * `^` (Exponentiation): Highest precedence (Right-to-Left associativity)
   * `*`, `/` (Multiplication, Division): Medium precedence (Left-to-Right)
   * `+`, `-` (Addition, Subtraction): Lowest precedence (Left-to-Right)
2. **Parentheses:** Opening parentheses `(` are pushed onto the stack. When a closing parenthesis `)` is encountered, operators are popped from the stack and outputted until the matching opening parenthesis `(` is reached.

---

## 📋 Algorithm (Step-by-Step)

1. Initialize an empty `Stack<Character>` for operators and a `StringBuilder` (or String) for the output expression.
2. Scan the given infix expression character by character:
   * **If the character is an operand** (letter or digit), output it directly to the result.
   * **If the character is an opening parenthesis `(`**, push it onto the stack.
   * **If the character is a closing parenthesis `)`**, pop from the stack and output operators until an opening parenthesis `(` is encountered. Pop and discard the `(`.
   * **If the character is an operator (`+`, `-`, `*`, `/`, `^`)**:
     * While the stack is not empty, and the precedence of the current operator is **less than or equal to** the precedence of the operator at the top of the stack (and they are not right-associative like `^`), pop the stack and output the operator.
     * Push the current operator onto the stack.
3. After scanning all characters, pop any remaining operators from the stack and append them to the output.

---

## 💻 Java Source Code

```java
import java.util.Stack;

public class InfixToPostfix {

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

    // Method to convert Infix to Postfix
    public static String convertToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If the scanned character is an '(', push it to the stack.
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is an ')', pop and output from the stack 
            // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            // An operator is encountered
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String exp = "A+B*C+D";
        System.out.println("Infix: " + exp);
        System.out.println("Postfix: " + convertToPostfix(exp)); // Output: ABC*+D+
    }
}
