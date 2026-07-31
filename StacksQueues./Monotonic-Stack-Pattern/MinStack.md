# LeetCode 155 – Min Stack

## Problem Statement

Design a stack that supports the following operations in **constant time (O(1))**:

* `push(int val)` – Push an element onto the stack.
* `pop()` – Remove the top element.
* `top()` – Return the top element.
* `getMin()` – Retrieve the minimum element currently in the stack.

### Example

```text
Input:
["MinStack","push","push","push","getMin","pop","top","getMin"]

[[],[-2],[0],[-3],[],[],[],[]]

Output:
[null,null,null,null,-3,null,0,-2]
```

### Explanation

```text
MinStack minStack = new MinStack();

minStack.push(-2);
minStack.push(0);
minStack.push(-3);

minStack.getMin(); // returns -3

minStack.pop();

minStack.top();    // returns 0

minStack.getMin(); // returns -2
```

---

# Intuition

A normal stack efficiently supports `push`, `pop`, and `top` operations in **O(1)** time.

However, finding the minimum element requires scanning the entire stack, which takes **O(n)** time.

To make `getMin()` run in **O(1)** time, we need to keep track of the minimum element as values are inserted and removed.

The idea is to use **two stacks**:

1. **Main Stack** – Stores all elements.
2. **Min Stack** – Stores the minimum value corresponding to each position in the main stack.

The top of the Min Stack always represents the minimum element currently present in the Main Stack.

---

# Approach

## Step 1: Push Operation

When pushing a new value:

* Push the value into the Main Stack.
* If the Min Stack is empty, push the value into the Min Stack.
* Otherwise, compare the new value with the current minimum (`minStack.peek()`).
* Push the smaller value into the Min Stack.

### Example

Push 5

```text
Main Stack : [5]
Min Stack  : [5]
```

Push 2

```text
Main Stack : [5,2]
Min Stack  : [5,2]
```

Push 8

```text
Main Stack : [5,2,8]
Min Stack  : [5,2,2]
```

Push 1

```text
Main Stack : [5,2,8,1]
Min Stack  : [5,2,2,1]
```

Notice that the Min Stack stores the **minimum value seen so far** at every position.

---

## Step 2: Pop Operation

Whenever an element is removed from the Main Stack, remove the corresponding element from the Min Stack as well.

Example:

Before Pop

```text
Main Stack : [5,2,8,1]
Min Stack  : [5,2,2,1]
```

After Pop

```text
Main Stack : [5,2,8]
Min Stack  : [5,2,2]
```

Current minimum:

```text
2
```

---

## Step 3: Top Operation

Return the top element from the Main Stack.

```java
return stack.peek();
```

---

## Step 4: Get Minimum

Return the top element of the Min Stack.

```java
return minStack.peek();
```

Since the Min Stack always stores the minimum element corresponding to the current state of the Main Stack, this operation is performed in **O(1)** time.

---

# Algorithm

### Push

```text
push(x)

Push x into Main Stack.

If Min Stack is empty
    Push x into Min Stack.
Else
    Push min(x, Min Stack.top()) into Min Stack.
```

---

### Pop

```text
pop()

Main Stack.pop()
Min Stack.pop()
```

---

### Top

```text
top()

Return Main Stack.top()
```

---

### Get Minimum

```text
getMin()

Return Min Stack.top()
```

---

# Dry Run

Operations

```text
push(5)
push(3)
push(7)
push(2)
pop()
getMin()
```

### After push(5)

```text
Main : [5]
Min  : [5]
```

---

### After push(3)

```text
Main : [5,3]
Min  : [5,3]
```

---

### After push(7)

```text
Main : [5,3,7]
Min  : [5,3,3]
```

---

### After push(2)

```text
Main : [5,3,7,2]
Min  : [5,3,3,2]
```

---

### After pop()

```text
Main : [5,3,7]
Min  : [5,3,3]
```

---

### getMin()

```text
Returns 3
```

---

# Java Solution

```java
import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
```

---

# Complexity Analysis

| Operation | Time Complexity | Space Complexity   |
| --------- | --------------- | ------------------ |
| push()    | O(1)            | O(1) per insertion |
| pop()     | O(1)            | O(1)               |
| top()     | O(1)            | O(1)               |
| getMin()  | O(1)            | O(1)               |

Overall auxiliary space: **O(n)**, where `n` is the number of elements in the stack.

---

# Key Observations

* A normal stack cannot return the minimum element in constant time.
* Maintaining a second stack with the running minimum allows `getMin()` to execute in **O(1)**.
* Both stacks must always have the same number of elements.
* `getMin()` should use `peek()`, **not** `pop()`, otherwise the Min Stack becomes inconsistent with the Main Stack.
* This two-stack approach is the standard interview solution for the Min Stack problem.

---

# Similar Problems

* Valid Parentheses
* Next Greater Element I
* Daily Temperatures
* Online Stock Span
* Largest Rectangle in Histogram
* Trapping Rain Water
* Sum of Subarray Minimums
* Asteroid Collision
* Max Stack (Premium)

---

# Takeaway

The core idea behind the Min Stack is to maintain an additional stack that records the minimum value at every stage of the main stack. Since both stacks are updated together during `push()` and `pop()`, the current minimum is always available at the top of the Min Stack, allowing all operations—including `getMin()`—to run in **O(1)** time.
