# 📚 Stack - Complete Interview Guide


> This repository contains everything you need to master **Stack** and **Monotonic Stack** for coding interviews and competitive programming.

---

# 📖 Table of Contents

1. 📦 Stack Theory
2. ⚙️ Stack Methods (Java)
3. 🗺️ HashMap Methods (Java)
4. 🎯 Stack Patterns
5. 📈 Monotonic Stack
6. 📄 Monotonic Stack Templates
7. 🧩 Important Problems
8. 🛣️ Learning Roadmap

---

# 📦 Stack Theory

## What is a Stack?

A **Stack** is a linear data structure that follows the **LIFO (Last In, First Out)** principle.

The last element inserted into the stack is the first element removed.

Example

```text
Push(10)
Push(20)
Push(30)

Stack

30
20
10
```

Pop()

```text
20
10
```

---

## Applications of Stack

- Function Calls (Call Stack)
- Undo / Redo
- Browser History
- Expression Evaluation
- Parentheses Matching
- Backtracking
- DFS
- Monotonic Stack Problems

---

# ⚙️ Stack Methods (Java)

```java
Stack<Integer> stack = new Stack<>();
```

| Method | Description | Time |
|---------|-------------|------|
| `push(x)` | Insert element | O(1) |
| `pop()` | Remove top element | O(1) |
| `peek()` | View top element | O(1) |
| `isEmpty()` | Check if empty | O(1) |
| `size()` | Number of elements | O(1) |
| `search(x)` | Position from top | O(n) |
| `clear()` | Remove all elements | O(n) |

Example

```java
stack.push(10);
stack.push(20);

stack.peek();      //20

stack.pop();       //20

stack.isEmpty();   //false

stack.size();      //1
```

---

# 🗺️ HashMap Methods (Java)

```java
HashMap<Integer,Integer> map = new HashMap<>();
```

| Method | Description |
|---------|-------------|
| `put(key,value)` | Insert or update |
| `get(key)` | Get value |
| `getOrDefault(key,default)` | Default if absent |
| `containsKey(key)` | Check key |
| `containsValue(value)` | Check value |
| `remove(key)` | Remove key |
| `replace(key,value)` | Replace value |
| `size()` | Number of entries |
| `isEmpty()` | Check empty |
| `clear()` | Remove all entries |
| `keySet()` | All keys |
| `values()` | All values |
| `entrySet()` | Key-value pairs |

Example

```java
map.put(1,10);

map.get(1);

map.containsKey(1);

map.remove(1);
```

---

# 🎯 Stack Patterns

## Pattern 1

Balanced Parentheses

Problems

- Valid Parentheses
- Minimum Add to Make Parentheses Valid

---

## Pattern 2

Next Greater / Smaller

Problems

- Next Greater Element I
- Next Greater Element II
- Daily Temperatures

---

## Pattern 3

Previous Greater / Smaller

Problems

- Stock Span
- Histogram

---

## Pattern 4

Expression Evaluation

Problems

- Infix to Postfix
- Prefix Evaluation
- Postfix Evaluation

---

## Pattern 5

Undo / Redo

Applications

- Text Editor
- Browser History

---

## Pattern 6

Monotonic Stack

Used for

- Next Greater
- Next Smaller
- Previous Greater
- Previous Smaller
- Histogram
- Rain Water
- Daily Temperatures

---

# 📈 Monotonic Stack

A **Monotonic Stack** is a stack whose elements are maintained in either increasing or decreasing order.

Types

- Monotonically Increasing Stack
- Monotonically Decreasing Stack

The stack stores

> **Elements whose answer has not yet been found.**

Every element is pushed once and popped at most once.

Time Complexity

```text
O(n)
```

---

# 📄 Monotonic Stack Templates

### Next Greater Element

```java
Stack<Integer> stack = new Stack<>();

for(int i=0;i<n;i++){

    while(!stack.isEmpty() &&
          nums[stack.peek()]<nums[i]){

        stack.pop();
    }

    stack.push(i);
}
```

---

### Next Smaller Element

```java
Stack<Integer> stack = new Stack<>();

for(int i=0;i<n;i++){

    while(!stack.isEmpty() &&
          nums[stack.peek()]>nums[i]){

        stack.pop();
    }

    stack.push(i);
}
```

---

# 🧩 Important Problems

## Easy

- ✅ Valid Parentheses
- ✅ Next Greater Element I
- ✅ Next Greater Element II
- ✅ Next Smaller Element
- ✅ Previous Greater Element
- ✅ Previous Smaller Element

## Medium

- ✅ Daily Temperatures
- ✅ Online Stock Span
- ✅ Largest Rectangle in Histogram
- ✅ Trapping Rain Water
- ✅ Remove K Digits

## Hard

- ✅ Maximal Rectangle
- ✅ Sum of Subarray Minimums
- ✅ Sum of Subarray Ranges

---

# 🛣️ Learning Roadmap

### Phase 1

- Stack Basics
- HashMap Basics
- Stack Methods
- Stack Patterns

### Phase 2

- Monotonic Stack Theory
- Next Greater Element I
- Next Greater Element II
- Next Smaller Element

### Phase 3

- Daily Temperatures
- Stock Span
- Largest Rectangle in Histogram

### Phase 4

- Trapping Rain Water
- Remove K Digits
- Sum of Subarray Minimums

---

# ⭐ Golden Rules

- Use a stack when you need **LIFO** behavior.
- Use a monotonic stack when searching for the **nearest greater/smaller element**.
- Store **indices** when positions, distances, or duplicate values matter.
- Every element is pushed once and popped at most once in monotonic stack problems.
- Most monotonic stack problems have **O(n)** time complexity.
