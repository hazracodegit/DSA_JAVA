# 📚 Stack Basics

> A complete guide to understanding the **Stack** data structure, its operations, applications, and time complexities.

---

# 📖 What is a Stack?

A **Stack** is a linear data structure that follows the **LIFO (Last In, First Out)** principle.

This means the **last element inserted into the stack is the first element removed**.

Think of a stack of plates.

- You place a new plate on the top.
- You remove the top plate first.

Example

```text
Push(10)
Push(20)
Push(30)

Stack

30 ← Top
20
10
```

Now,

```text
Pop()
```

removes

```text
30
```

Remaining Stack

```text
20
10
```

---

# 🎯 LIFO Principle

LIFO stands for

> **Last In, First Out**

Example

```text
Push(1)

Stack

1
```

```text
Push(2)

Stack

2
1
```

```text
Push(3)

Stack

3
2
1
```

Now,

```text
Pop()
```

Output

```text
3
```

because **3 was inserted last.**

---

# 🏗️ Basic Operations

| Operation | Description | Time Complexity |
|-----------|-------------|-----------------|
| Push | Insert an element | O(1) |
| Pop | Remove top element | O(1) |
| Peek / Top | View top element | O(1) |
| isEmpty | Check if stack is empty | O(1) |
| Size | Number of elements | O(1) |

---

# 📦 Push Operation

Adds an element to the top of the stack.

Example

```text
Before

20
10
```

```java
stack.push(30);
```

After

```text
30
20
10
```

---

# 📦 Pop Operation

Removes the top element.

Example

```text
Before

30
20
10
```

```java
stack.pop();
```

After

```text
20
10
```

---

# 👀 Peek Operation

Returns the top element without removing it.

Example

```java
stack.peek();
```

Output

```text
30
```

Stack remains

```text
30
20
10
```

---

# ❓ isEmpty()

Checks whether the stack is empty.

```java
stack.isEmpty();
```

Returns

```text
true
```

or

```text
false
```

---

# 📏 Size

Returns the number of elements in the stack.

```java
stack.size();
```

Example

```text
Stack

30
20
10
```

Output

```text
3
```

---

# 💻 Creating a Stack in Java

```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
```

---

# 💻 Example Program

```java
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack);

        System.out.println(stack.peek());

        System.out.println(stack.pop());

        System.out.println(stack);

        System.out.println(stack.isEmpty());

        System.out.println(stack.size());
    }
}
```

Output

```text
[10, 20, 30]
30
30
[10, 20]
false
2
```

---

# ⚡ Time Complexity

| Operation | Time Complexity |
|-----------|-----------------|
| Push | O(1) |
| Pop | O(1) |
| Peek | O(1) |
| isEmpty | O(1) |
| Size | O(1) |

---

# 🌍 Applications of Stack

Stacks are widely used in computer science.

### 1. Function Calls

Every function call is stored in the **Call Stack**.

---

### 2. Undo / Redo

Used in

- Text Editors
- MS Word
- VS Code

---

### 3. Browser History

Pressing the **Back** button uses a stack.

---

### 4. Parentheses Matching

Problems like

```text
()[]{}
```

are solved using stacks.

---

### 5. Expression Evaluation

Used in

- Infix to Postfix
- Prefix Evaluation
- Postfix Evaluation

---

### 6. Depth First Search (DFS)

DFS uses a stack (explicitly or through recursion).

---

### 7. Monotonic Stack

Many array problems use stacks to achieve **O(n)** solutions.

Examples

- Next Greater Element
- Daily Temperatures
- Largest Rectangle in Histogram

---

# 🎯 When Should You Think of a Stack?

Think of using a stack when:

- The last inserted item should be processed first.
- You need to undo previous operations.
- You need to match opening and closing symbols.
- You need to process nested structures.
- The problem involves nearest greater/smaller elements (Monotonic Stack).

---

# ⭐ Key Takeaways

- A Stack follows the **LIFO (Last In, First Out)** principle.
- Insert using **push()**.
- Remove using **pop()**.
- Access the top using **peek()**.
- All basic stack operations run in **O(1)** time.
- Stacks are commonly used in recursion, expression evaluation, browser history, undo/redo operations, DFS, and monotonic stack problems.
