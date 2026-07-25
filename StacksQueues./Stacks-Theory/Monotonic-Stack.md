# 📈 Monotonic Stack Theory

> A **Monotonic Stack** is a special type of stack that maintains its elements in a specific order (increasing or decreasing). It helps solve many array problems in **O(n)** time.

---

# 📖 Table of Contents

1. What is a Monotonic Stack?
2. Why Do We Need It?
3. Types of Monotonic Stacks
4. Core Idea
5. Why Do Elements Wait?
6. Why Do We Push Elements?
7. Why Store Indices Instead of Values?
8. Time Complexity Proof
9. Universal Templates
10. How to Identify Monotonic Stack Problems
11. Common Mistakes
12. Must-Do Problems

---

# 📖 What is a Monotonic Stack?

A **Monotonic Stack** is a stack that always maintains its elements in a particular order.

There are two types:

- **Monotonically Increasing Stack**
- **Monotonically Decreasing Stack**

Unlike a normal stack, elements may be removed before inserting the current element to maintain the required order.

---

# 🚀 Why Do We Need It?

Consider the problem:

> Find the **Next Greater Element** for every element in an array.

### Brute Force

For every element,

- Search all elements to its right.

Time Complexity

```text
O(n²)
```

---

Using a Monotonic Stack,

- Every element is pushed once.
- Every element is popped at most once.

Time Complexity

```text
O(n)
```

---

# 📌 Types of Monotonic Stacks

## 1️⃣ Monotonically Increasing Stack

The stack keeps elements in **increasing order**.

Before pushing a smaller element,

remove all larger elements.

Example

```text
Current Stack

2
5
8

Current = 4

8 > 4

Pop 8

Push 4

Final Stack

2
5
4
```

---

## 2️⃣ Monotonically Decreasing Stack

The stack keeps elements in **decreasing order**.

Before pushing a larger element,

remove all smaller elements.

Example

```text
Current Stack

9
6
3

Current = 7

3 < 7

Pop 3

Pop 6

Push 7

Final Stack

9
7
```

---

# 💡 Core Idea

The stack stores

> **Elements whose answer has not yet been found.**

Whenever a new element arrives,

check whether it can answer the waiting elements.

If yes,

- Store the answer.
- Pop those elements.

Finally,

push the current element because **its own answer is still unknown**.

---

# ❓ Why Do Elements Wait?

Example

```text
nums = [2,1,3]
```

Start with

```text
2
```

Can we say its next greater element?

No.

Maybe it is

```text
2 5
```

Maybe

```text
2 100
```

Maybe

```text
2 1
```

We haven't seen the future.

So,

we let it **wait** inside the stack.

When we later encounter `3`,

we immediately know

```text
Next Greater of 2 = 3
```

The waiting element receives its answer and leaves the stack.

---

# ❓ Why Do We Push Elements?

Every element is pushed because **its answer is not yet known**.

Example

```text
nums = [1,3,2]
```

Current element

```text
1
```

Do we know its next greater element?

No.

Push it.

Later,

```text
3
```

Now

```text
3 > 1
```

Answer found.

Pop `1`.

Then push `3`.

Why?

Because **3 also doesn't know its next greater element yet.**

---

# ❓ Why Store Indices Instead of Values?

Most monotonic stack problems store **indices**.

Example

```text
nums = [1,2,1]
```

If we push values,

```text
Stack

1
2
1
```

Which `1` is this?

- First `1`
- Last `1`

We don't know.

Instead,

store indices.

```text
Stack

0
1
2
```

Now,

- Index 0 → Value 1
- Index 2 → Value 1

Each element is uniquely identified.

---

## Another Advantage

Once you have the index,

you can access

```java
nums[index]
```

You also know

- Position
- Distance
- Width

which is required in problems like

- Daily Temperatures
- Largest Rectangle in Histogram

---

# ⏱️ Why is the Time Complexity O(n)?

Every element is

- pushed once
- popped at most once

Example

```text
1 3 2 5 4
```

Each element enters the stack exactly one time.

Once removed,

it never comes back.

Therefore,

```text
Total Pushes = n

Total Pops = n
```

Overall

```text
O(2n)

=

O(n)
```

---

# 📄 Universal Templates

## Next Greater Element

```java
Stack<Integer> stack = new Stack<>();

for(int i = 0; i < n; i++){

    while(!stack.isEmpty() &&
          nums[stack.peek()] < nums[i]){

        // Process answer

        stack.pop();
    }

    stack.push(i);
}
```

---

## Next Smaller Element

```java
Stack<Integer> stack = new Stack<>();

for(int i = 0; i < n; i++){

    while(!stack.isEmpty() &&
          nums[stack.peek()] > nums[i]){

        stack.pop();
    }

    stack.push(i);
}
```

---

## Circular Array

```java
for(int i = 0; i < 2 * n; i++){

    int current = nums[i % n];

}
```

---

# 🔍 How to Identify Monotonic Stack Problems

If the question contains words like

- Next Greater
- Next Smaller
- Previous Greater
- Previous Smaller
- Nearest Greater
- Nearest Smaller
- Circular Array
- Histogram
- Span
- Temperature
- Rectangle
- Rain Water

👉 Think **Monotonic Stack**.

---

# ⚠️ Common Mistakes

## ❌ Storing Values Instead of Indices

Use indices whenever

- Duplicates exist.
- Distances are needed.
- Positions matter.

---

## ❌ Forgetting to Pop

Always remove elements while the monotonic condition is violated.

---

## ❌ Using the Wrong Stack Type

Remember

| Problem | Stack |
|---------|-------|
| Next Greater | Decreasing |
| Next Smaller | Increasing |
| Previous Greater | Decreasing |
| Previous Smaller | Increasing |

---

## ❌ Pushing During the Second Traversal

For circular array problems,

only push during the **first traversal**.

The second traversal is only to resolve unanswered elements.

---

# 🏆 Must-Do Problems

## 🟢 Easy

- ✅ Next Greater Element I
- ✅ Next Greater Element II

---

## 🟡 Medium

- ✅ Daily Temperatures
- ✅ Online Stock Span
- ✅ Largest Rectangle in Histogram
- ✅ Trapping Rain Water

---

## 🔴 Hard

- ✅ Maximal Rectangle
- ✅ Sum of Subarray Minimums
- ✅ Sum of Subarray Ranges

---

# ⭐ Golden Rules

- The stack stores **elements whose answer is still unknown**.
- Push an element because **its answer hasn't been found yet**.
- Pop an element once its answer is found.
- Store **indices** instead of values when duplicates or positions matter.
- Every element is pushed once and popped at most once.
- Most monotonic stack problems run in **O(n)** time.
- If you see **Next/Previous Greater/Smaller**, think **Monotonic Stack** first.
