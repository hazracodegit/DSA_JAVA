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

# ⚙️ Stack Methods in Java

> This guide covers all the commonly used methods of the `Stack` class in Java with syntax, examples, and time complexities.

---

# 📖 Creating a Stack

```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
```

---

# 📌 Stack Methods

| Method | Description | Time Complexity |
|---------|-------------|-----------------|
| `push()` | Inserts an element at the top | O(1) |
| `pop()` | Removes and returns the top element | O(1) |
| `peek()` | Returns the top element without removing it | O(1) |
| `isEmpty()` | Checks whether the stack is empty | O(1) |
| `size()` | Returns the number of elements | O(1) |
| `search()` | Returns the position of an element from the top | O(n) |
| `clear()` | Removes all elements | O(n) |

---

# 1️⃣ push()

Adds an element to the top of the stack.

### Syntax

```java
stack.push(element);
```

### Example

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack);
```

### Output

```text
[10, 20, 30]
```

---

# 2️⃣ pop()

Removes and returns the top element.

### Syntax

```java
stack.pop();
```

### Example

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.pop());
System.out.println(stack);
```

### Output

```text
30
[10, 20]
```

---

# 3️⃣ peek()

Returns the top element without removing it.

### Syntax

```java
stack.peek();
```

### Example

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.peek());
System.out.println(stack);
```

### Output

```text
30
[10, 20, 30]
```

---

# 4️⃣ isEmpty()

Checks whether the stack is empty.

### Syntax

```java
stack.isEmpty();
```

### Example

```java
Stack<Integer> stack = new Stack<>();

System.out.println(stack.isEmpty());

stack.push(10);

System.out.println(stack.isEmpty());
```

### Output

```text
true
false
```

---

# 5️⃣ size()

Returns the total number of elements in the stack.

### Syntax

```java
stack.size();
```

### Example

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.size());
```

### Output

```text
3
```

---

# 6️⃣ search()

Returns the **1-based position** of an element from the **top** of the stack.

If the element is not present, it returns **-1**.

### Syntax

```java
stack.search(element);
```

### Example

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.search(30));
System.out.println(stack.search(20));
System.out.println(stack.search(10));
System.out.println(stack.search(50));
```

### Output

```text
1
2
3
-1
```

Explanation

```text
Top

30 ← Position 1
20 ← Position 2
10 ← Position 3
```

---

# 7️⃣ clear()

Removes all elements from the stack.

### Syntax

```java
stack.clear();
```

### Example

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);

stack.clear();

System.out.println(stack);
```

### Output

```text
[]
```

---

# 📝 Complete Example

```java
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack : " + stack);

        System.out.println("Top : " + stack.peek());

        System.out.println("Size : " + stack.size());

        System.out.println("Search 20 : " + stack.search(20));

        System.out.println("Pop : " + stack.pop());

        System.out.println("Stack : " + stack);

        System.out.println("Is Empty : " + stack.isEmpty());

        stack.clear();

        System.out.println("After Clear : " + stack);
    }
}
```

### Output

```text
Stack : [10, 20, 30]
Top : 30
Size : 3
Search 20 : 2
Pop : 30
Stack : [10, 20]
Is Empty : false
After Clear : []
```

---

# ⚠️ Common Exceptions

## EmptyStackException

Calling `pop()` or `peek()` on an empty stack throws an exception.

### Example

```java
Stack<Integer> stack = new Stack<>();

stack.pop();
```

Output

```text
Exception in thread "main"
java.util.EmptyStackException
```

Always check first:

```java
if (!stack.isEmpty()) {
    stack.pop();
}
```

---

# 🎯 Time Complexity Summary

| Method | Time Complexity |
|---------|-----------------|
| `push()` | O(1) |
| `pop()` | O(1) |
| `peek()` | O(1) |
| `isEmpty()` | O(1) |
| `size()` | O(1) |
| `search()` | O(n) |
| `clear()` | O(n) |

---

# ⭐ Key Takeaways

- `push()` inserts an element onto the stack.
- `pop()` removes and returns the top element.
- `peek()` returns the top element without removing it.
- `isEmpty()` checks if the stack contains any elements.
- `size()` returns the current number of elements.
- `search()` returns the 1-based position from the top.
- `clear()` removes every element from the stack.
- Always check `isEmpty()` before calling `pop()` or `peek()` to avoid `EmptyStackException`.
