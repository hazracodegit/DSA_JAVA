# 🎯 Stack Patterns

> One of the most important skills in DSA is identifying **which pattern a problem belongs to**. This guide covers the most common stack patterns asked in coding interviews.

---

# 📖 Table of Contents

1. Balanced Parentheses
2. Monotonic Stack
3. Expression Conversion & Evaluation
4. Undo / Redo
5. Backtracking
6. Function Call Stack
7. DFS using Stack
8. Pattern Recognition Cheat Sheet
9. Must-Do Problems

---

# 1️⃣ Balanced Parentheses Pattern

## 💡 Idea

Whenever an **opening bracket** appears,

- Push it into the stack.

Whenever a **closing bracket** appears,

- Check whether it matches the top of the stack.
- If it matches, pop it.
- Otherwise, the expression is invalid.

---

## Used In

- Valid Parentheses
- Minimum Add to Make Parentheses Valid
- Remove Outermost Parentheses

---

## Common Keywords

- Parentheses
- Brackets
- Matching Symbols
- Nested Structures

---

## Template

```java
Stack<Character> stack = new Stack<>();

for(char ch : s.toCharArray()){

    if(ch == '(' || ch == '{' || ch == '['){

        stack.push(ch);

    }else{

        if(stack.isEmpty())
            return false;

        if(matches(stack.peek(), ch))
            stack.pop();
        else
            return false;
    }
}

return stack.isEmpty();
```

---

# 2️⃣ Monotonic Stack Pattern

## 💡 Idea

The stack always maintains a specific order.

- Increasing Stack
- Decreasing Stack

Used to find

- Next Greater
- Next Smaller
- Previous Greater
- Previous Smaller

---

## Used In

- Next Greater Element I
- Next Greater Element II
- Daily Temperatures
- Stock Span
- Largest Rectangle in Histogram
- Trapping Rain Water
- Sum of Subarray Minimums

---

## Common Keywords

- Next Greater
- Next Smaller
- Previous Greater
- Previous Smaller
- Nearest Greater
- Nearest Smaller

---

# 3️⃣ Expression Conversion & Evaluation

## 💡 Idea

Stacks are used to convert and evaluate mathematical expressions.

Examples

- Infix → Postfix
- Infix → Prefix
- Postfix Evaluation
- Prefix Evaluation

---

## Used In

- Expression Evaluation
- Calculator Problems

---

## Common Keywords

- Expression
- Prefix
- Postfix
- Infix
- Calculator

---

# 4️⃣ Undo / Redo Pattern

## 💡 Idea

Every operation is stored in a stack.

Undo

- Pop the last operation.

Redo

- Store undone operations in another stack.

---

## Applications

- MS Word
- VS Code
- Photoshop
- Browser Navigation

---

## Common Keywords

- Undo
- Redo
- History

---

# 5️⃣ Backtracking Pattern

## 💡 Idea

While exploring different possibilities,

store previous states in a stack.

If the current path fails,

return to the previous state.

---

## Used In

- Maze Problems
- Path Finding
- Sudoku
- N-Queens (recursive stack)

---

## Common Keywords

- Backtrack
- Return
- Previous State

---

# 6️⃣ Function Call Stack

## 💡 Idea

Every function call is pushed onto the call stack.

When a function finishes,

it is popped from the stack.

---

## Used In

- Recursion
- Recursive DFS
- Divide and Conquer

---

## Example

```text
main()

↓

A()

↓

B()

↓

C()
```

When `C()` finishes,

```text
C pops

↓

B pops

↓

A pops

↓

main
```

---

# 7️⃣ DFS Using Stack

## 💡 Idea

Depth First Search can be implemented using an explicit stack instead of recursion.

---

## Template

```java
Stack<Integer> stack = new Stack<>();

stack.push(start);

while(!stack.isEmpty()){

    int node = stack.pop();

    // Process node

    // Push neighbours
}
```

---

## Used In

- Graph Traversal
- Tree Traversal
- Maze Problems

---

# 🔍 Pattern Recognition Cheat Sheet

| If the Question Says... | Think... |
|--------------------------|----------|
| Parentheses | Balanced Parentheses |
| Next Greater | Monotonic Stack |
| Next Smaller | Monotonic Stack |
| Previous Greater | Monotonic Stack |
| Previous Smaller | Monotonic Stack |
| Infix / Prefix / Postfix | Expression Evaluation |
| Undo / Redo | History Stack |
| Browser History | Undo / Redo |
| DFS | Stack |
| Recursive Calls | Call Stack |

---

# 🏆 Must-Do Problems

## 🟢 Easy

- ✅ 20. Valid Parentheses
- ✅ 496. Next Greater Element I
- ✅ 503. Next Greater Element II

---

## 🟡 Medium

- ✅ 739. Daily Temperatures
- ✅ 901. Online Stock Span
- ✅ 71. Simplify Path
- ✅ 150. Evaluate Reverse Polish Notation
- ✅ 84. Largest Rectangle in Histogram
- ✅ 42. Trapping Rain Water

---

## 🔴 Hard

- ✅ 85. Maximal Rectangle
- ✅ 907. Sum of Subarray Minimums
- ✅ 2104. Sum of Subarray Ranges

---

# 🎯 Which Pattern Should I Learn First?

## Phase 1

- ✅ Stack Basics
- ✅ Stack Methods
- ✅ HashMap Methods

---

## Phase 2

- ✅ Valid Parentheses
- ✅ Stack Pattern Recognition

---

## Phase 3

- ✅ Monotonic Stack
- ✅ Next Greater Element I
- ✅ Next Greater Element II
- ✅ Daily Temperatures

---

## Phase 4

- ✅ Largest Rectangle in Histogram
- ✅ Trapping Rain Water
- ✅ Sum of Subarray Minimums

---

# ⭐ Key Takeaways

- Use a **Stack** when the **last inserted item should be processed first (LIFO)**.
- Parentheses problems usually use the **Balanced Parentheses Pattern**.
- Nearest greater/smaller problems usually use the **Monotonic Stack Pattern**.
- Expression problems often use **Stack-based Conversion or Evaluation**.
- Undo/Redo systems maintain a history using stacks.
- DFS can be implemented using a stack instead of recursion.
- Recognizing the pattern is often more important than memorizing the code.

 

Level 1: Basic Stack Operations

1. Implement Stack using Array


2. Implement Stack using Linked List


3. Implement Stack using Queues


4. Design Min Stack



Level 2: Parentheses Problems

5. Valid Parentheses


6. Minimum Add to Make Parentheses Valid


7. Remove Outermost Parentheses


8. Maximum Nesting Depth of Parentheses


9. Longest Valid Parentheses (Hard)



Level 3: Expression Problems

10. Infix to Postfix


11. Infix to Prefix


12. Postfix Evaluation


13. Prefix Evaluation


14. Postfix to Infix


15. Prefix to Infix



Level 4: Monotonic Stack

16. Next Greater Element I


17. Next Greater Element II


18. Previous Greater Element


19. Next Smaller Element


20. Previous Smaller Element


21. Daily Temperatures


22. Stock Span Problem



Level 5: Histogram & Matrix

23. Largest Rectangle in Histogram


24. Maximal Rectangle


25. Trapping Rain Water (Stack approach)



Level 6: Advanced Stack Problems

26. Asteroid Collision


27. Remove K Digits


28. Decode String


29. Simplify Path


30. Basic Calculator


31. Score of Parentheses


32. Online Stock Span



Level 7: Hard Problems

33. Car Fleet


34. Sum of Subarray Minimums


35. Sum of Subarray Ranges


36. 132 Pattern


37. Remove Duplicate Letters


38. Exclusive Time of Functions




---

Recommended order for interviews

1. ✅ Implement Stack


2. ✅ Min Stack


3. ✅ Valid Parentheses


4. ✅ Next Greater Element I


5. ✅ Daily Temperatures


6. ✅ Stock Span


7. ✅ Largest Rectangle in Histogram


8. ✅ Trapping Rain Water


9. ✅ Asteroid Collision


10. ✅ Sum of Subarray Minimums




