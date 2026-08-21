Save the following directly as README.md:

# Sliding Window Pattern — Fixed Size

The **Sliding Window** is a very important algorithmic pattern used to solve problems involving **contiguous subarrays or substrings** efficiently.

This README explains the **Fixed-Size Sliding Window** from:

- Brute-force approach
- Understanding the loops
- Why brute force is inefficient
- Optimized sliding-window approach
- Dry run
- General template
- Common mistakes
- Complexity
- Practice problems

---

# Table of Contents

- [1. What is a Window?](#1-what-is-a-window)
- [2. What is Sliding Window?](#2-what-is-sliding-window)
- [3. When Should We Use Sliding Window?](#3-when-should-we-use-sliding-window)
- [4. Types of Sliding Window](#4-types-of-sliding-window)
- [5. Fixed-Size Sliding Window](#5-fixed-size-sliding-window)
- [6. Example Problem](#6-example-problem)
- [7. Brute-Force Approach](#7-brute-force-approach)
- [8. Understanding the Brute-Force Code](#8-understanding-the-brute-force-code)
- [9. Understanding the Outer Loop](#9-understanding-the-outer-loop)
- [10. Understanding the Inner Loop](#10-understanding-the-inner-loop)
- [11. Inner Loop Condition](#11-inner-loop-condition)
- [12. Why Brute Force is Inefficient](#12-why-brute-force-is-inefficient)
- [13. Optimized Sliding Window](#13-optimized-sliding-window)
- [14. Core Idea of Sliding Window](#14-core-idea-of-sliding-window)
- [15. Complete Optimized Java Code](#15-complete-optimized-java-code)
- [16. Step-by-Step Dry Run](#16-step-by-step-dry-run)
- [17. Understanding `right - k`](#17-understanding-right---k)
- [18. Fixed-Size Sliding Window Template](#18-fixed-size-sliding-window-template)
- [19. Brute Force vs Optimized](#19-brute-force-vs-optimized)
- [20. Time and Space Complexity](#20-time-and-space-complexity)
- [21. Common Mistakes](#21-common-mistakes)
- [22. How to Recognize Fixed-Size Problems](#22-how-to-recognize-fixed-size-problems)
- [23. Important Mental Model](#23-important-mental-model)
- [24. Practice Problems](#24-practice-problems)
- [25. Quick Revision](#25-quick-revision)

---

# 1. What is a Window?

A **window** is simply a contiguous portion of an array or string.

Consider:

```text
[10, 20, 30, 40, 50]
```

If the window size is:

```text
k = 3
```

then the possible windows are:

```text
[10, 20, 30]

[20, 30, 40]

[30, 40, 50]
```

Each group of consecutive elements is called a **window**.

---

# 2. What is Sliding Window?

Sliding Window means that instead of looking at the entire array repeatedly, we maintain a **window** and move it forward.

For example:

```text
[10, 20, 30] 40 50
```

Move the window one position:

```text
10 [20, 30, 40] 50
```

Move again:

```text
10 20 [30, 40, 50]
```

So the window is:

```text
[10, 20, 30]
       ↓
[20, 30, 40]
       ↓
[30, 40, 50]
```

The important observation is that consecutive windows **overlap**.

For example:

```text
Previous window:
[10, 20, 30]

Next window:
[20, 30, 40]
```

The elements:

```text
20, 30
```

are present in both windows.

The Sliding Window technique tries to **reuse this existing information** instead of calculating everything again.

---

# 3. When Should We Use Sliding Window?

Sliding Window is commonly useful when a problem involves:

- Arrays
- Strings
- Subarrays
- Substrings
- Consecutive elements
- Contiguous elements

Look for keywords such as:

```text
consecutive
contiguous
subarray
substring
window
k consecutive elements
k sized window
maximum sum
minimum sum
```

For example:

> Find the maximum sum of `k` consecutive elements.

This is a strong indication that we should consider a **Fixed-Size Sliding Window**.

---

# 4. Types of Sliding Window

There are two major types.

## 1. Fixed-Size Sliding Window

The window size is already known.

Example:

```text
k = 3
```

Every window must contain exactly `3` elements.

```text
[10, 20, 30]
[20, 30, 40]
[30, 40, 50]
```

---

## 2. Variable-Size Sliding Window

The window size is not fixed.

Instead, a **condition** determines when the window should expand or shrink.

Example:

> Find the longest subarray whose sum is less than or equal to `K`.

Here, the window can have different sizes.

We will cover Variable-Size Sliding Window separately.

---

# 5. Fixed-Size Sliding Window

In a Fixed-Size Sliding Window:

```text
Window size = k
```

For example:

```text
arr = [10, 20, 30, 40, 50]
k = 3
```

The windows are:

```text
Window 1:
[10, 20, 30]

Window 2:
[20, 30, 40]

Window 3:
[30, 40, 50]
```

Every window has exactly:

```text
3 elements
```

---

# 6. Example Problem

## Problem

Given an integer array, find the **maximum sum of `k` consecutive elements**.

### Input

```text
arr = [10, 20, 30, 40, 50]
k = 3
```

### Possible Windows

```text
[10, 20, 30]
```

Sum:

```text
10 + 20 + 30 = 60
```

---

```text
[20, 30, 40]
```

Sum:

```text
20 + 30 + 40 = 90
```

---

```text
[30, 40, 50]
```

Sum:

```text
30 + 40 + 50 = 120
```

Therefore:

```text
Maximum Sum = 120
```

---

# 7. Brute-Force Approach

Before learning the optimized approach, it is important to understand the brute-force solution.

The idea is:

1. Choose a starting position.
2. Take `k` elements.
3. Calculate their sum.
4. Compare the sum with the current maximum.
5. Move to the next starting position.
6. Repeat.

### Java Code

```java
public class Main {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        int k = 3;
        int n = arr.length;

        int maxSum = Integer.MIN_VALUE;

        for (int right = 0; right <= n - k; right++) {

            int sum = 0;

            for (int left = right; left < right + k; left++) {
                sum += arr[left];
            }

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}
```

### Output

```text
120
```

---

# 8. Understanding the Brute-Force Code

The important part is:

```java
for (int right = 0; right <= n - k; right++) {

    int sum = 0;

    for (int left = right; left < right + k; left++) {
        sum += arr[left];
    }

    maxSum = Math.max(maxSum, sum);
}
```

There are two loops.

```text
Outer Loop
    ↓
Chooses the starting position

Inner Loop
    ↓
Processes k elements inside that window
```

---

# 9. Understanding the Outer Loop

The outer loop is:

```java
for (int right = 0; right <= n - k; right++)
```

Its job is to choose where the current window starts.

Given:

```text
arr = [10, 20, 30, 40, 50]
n = 5
k = 3
```

We have:

```text
n - k = 5 - 3 = 2
```

Therefore:

```text
right = 0
right = 1
right = 2
```

These represent:

```text
right = 0

[10, 20, 30]
```

```text
right = 1

[20, 30, 40]
```

```text
right = 2

[30, 40, 50]
```

So:

> `right` represents the starting index of the current window.

---

# 10. Understanding the Inner Loop

The inner loop is:

```java
for (int left = right; left < right + k; left++)
```

Its job is to process all `k` elements inside the current window.

Suppose:

```text
right = 0
k = 3
```

Then:

```java
for (int left = 0; left < 0 + 3; left++)
```

becomes:

```java
for (int left = 0; left < 3; left++)
```

Therefore:

```text
left = 0
left = 1
left = 2
```

We access:

```text
arr[0] = 10
arr[1] = 20
arr[2] = 30
```

So the window is:

```text
[10, 20, 30]
```

---

# 11. Inner Loop Condition

The important condition is:

```java
left < right + k
```

This means:

> Start from `right` and process exactly `k` elements.

---

## Example 1

Suppose:

```text
right = 0
k = 3
```

Condition:

```text
left < right + k
```

becomes:

```text
left < 3
```

Therefore:

```text
left = 0
left = 1
left = 2
```

Exactly `3` elements.

---

## Example 2

Suppose:

```text
right = 1
k = 3
```

Condition:

```text
left < 1 + 3
```

becomes:

```text
left < 4
```

Therefore:

```text
left = 1
left = 2
left = 3
```

Window:

```text
[20, 30, 40]
```

Again, exactly `3` elements.

---

## Why `<` and not `<=`?

Suppose:

```text
right = 0
k = 3
```

If we use:

```java
left <= right + k
```

then:

```text
left = 0
left = 1
left = 2
left = 3
```

That's `4` elements.

But we need exactly `3`.

Therefore:

```java
left < right + k
```

is correct.

---

# 12. Why Brute Force is Inefficient

Consider these windows:

```text
Window 1:
[10, 20, 30]

Window 2:
[20, 30, 40]
```

The brute-force approach calculates:

```text
10 + 20 + 30
```

Then calculates again:

```text
20 + 30 + 40
```

But:

```text
20
30
```

were already part of the previous window.

We are doing repeated work.

The same thing happens for every window.

---

# 13. Optimized Sliding Window

The optimized approach avoids recalculating the entire window.

The key idea is:

```text
New Sum
=
Old Sum
-
Element Leaving
+
Element Entering
```

Consider:

```text
Old Window:

[10, 20, 30]
```

Sum:

```text
60
```

Move the window:

```text
[20, 30, 40]
```

What changed?

```text
10 → left the window
40 → entered the window
```

Therefore:

```text
New Sum
=
60 - 10 + 40

= 90
```

We don't need to calculate:

```text
20 + 30 + 40
```

again.

---

# 14. Core Idea of Sliding Window

The entire optimization can be remembered as:

```text
Build First Window
        ↓
Calculate Sum
        ↓
Move Window
        ↓
Remove Element Leaving
        ↓
Add Element Entering
        ↓
Update Answer
        ↓
Repeat
```

The main formula is:

```text
newSum = oldSum - leavingElement + enteringElement
```

 # Algorithm
# Fixed-Size Sliding Window Algorithm

## Steps

1. **Initialize the variables**
   - Set `windowSum = 0`.
   - Set `maxSum` after calculating the first window.

2. **Build the first window**
   - Add the first `k` elements of the array.
   - This gives the sum of the first window.

3. **Initialize the answer**
   - Set `maxSum = windowSum`.

4. **Start sliding the window**
   - Start from `right = k`.
   - Continue until `right < n`.

5. **Remove the element leaving the window**
   - The leaving element is:
   
   arr[right - k]


Add the element entering the window

The entering element is:
arr[right]


Update the window sum

windowSum = windowSum - arr[right - k] + arr[right]


Update the answer

Compare the current windowSum with maxSum.
Store the larger value.

Repeat

Continue steps 5–8 until the window reaches the end of the array.

Return the answer

maxSum contains the maximum sum of any window of size k.
Core Idea
Build First Window
        ↓
Remove Leaving Element
        ↓
Add Entering Element
        ↓
Update Answer
        ↓
Slide Again

Complexity
Time Complexity  : O(n)
Space Complexity : O(1)


---

# 15. Complete Optimized Java Code

```java
public class Main {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        int k = 3;
        int n = arr.length;

        int windowSum = 0;

        // Build the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Slide the window
        for (int right = k; right < n; right++) {

            // Remove the element leaving
            // Add the element entering
            windowSum = windowSum - arr[right - k] + arr[right];

            // Update maximum
            maxSum = Math.max(maxSum, windowSum);
        }

        System.out.println(maxSum);
    }
}
```

### Output

```text
120
```

---

# 16. Step-by-Step Dry Run

Given:

```text
arr = [10, 20, 30, 40, 50]
k = 3
```

---

## Step 1: Build the First Window

Code:

```java
for (int i = 0; i < k; i++) {
    windowSum += arr[i];
}
```

### `i = 0`

```text
windowSum = 0 + arr[0]
          = 0 + 10
          = 10
```

### `i = 1`

```text
windowSum = 10 + arr[1]
          = 10 + 20
          = 30
```

### `i = 2`

```text
windowSum = 30 + arr[2]
          = 30 + 30
          = 60
```

First window:

```text
[10, 20, 30]
```

Sum:

```text
60
```

Therefore:

```java
int maxSum = windowSum;
```

So:

```text
maxSum = 60
```

---

# Step 2: Start Sliding

Code:

```java
for (int right = k; right < n; right++)
```

Since:

```text
k = 3
n = 5
```

`right` will be:

```text
3
4
```

---

## `right = 3`

Current window:

```text
[10, 20, 30]
```

Next window:

```text
[20, 30, 40]
```

Element leaving:

```text
10
```

Element entering:

```text
40
```

Formula:

```text
windowSum = windowSum - arr[right - k] + arr[right]
```

Substitute values:

```text
windowSum = 60 - arr[3 - 3] + arr[3]

          = 60 - arr[0] + arr[3]

          = 60 - 10 + 40

          = 90
```

Update:

```text
maxSum = max(60, 90)

       = 90
```

---

## `right = 4`

Current window:

```text
[20, 30, 40]
```

Next window:

```text
[30, 40, 50]
```

Element leaving:

```text
20
```

Element entering:

```text
50
```

Formula:

```text
windowSum = 90 - 20 + 50

          = 120
```

Update:

```text
maxSum = max(90, 120)

       = 120
```

Final answer:

```text
120
```

---

# 17. Understanding `right - k`

This is one of the most important parts of the optimized solution.

We use:

```java
arr[right - k]
```

to find the element that is **leaving the window**.

---

## Example

Suppose:

```text
k = 3
right = 3
```

Then:

```text
right - k

= 3 - 3

= 0
```

Therefore:

```java
arr[right - k]
```

is:

```java
arr[0]
```

which is:

```text
10
```

And `10` is exactly the element leaving:

```text
[10, 20, 30]
  ↓
[20, 30, 40]
```

---

## Next Iteration

Suppose:

```text
right = 4
k = 3
```

Then:

```text
right - k

= 4 - 3

= 1
```

Therefore:

```java
arr[right - k]
```

is:

```java
arr[1]
```

which is:

```text
20
```

And `20` is exactly the element leaving:

```text
[20, 30, 40]
  ↓
[30, 40, 50]
```

Therefore:

```java
arr[right - k]
```

means:

> Element leaving the window.

And:

```java
arr[right]
```

means:

> Element entering the window.

---

# 18. Fixed-Size Sliding Window Template

This is the general template.

```java
int windowSum = 0;

// 1. Build the first window
for (int i = 0; i < k; i++) {
    windowSum += arr[i];
}

// 2. Store the initial answer
int answer = windowSum;

// 3. Slide the window
for (int right = k; right < n; right++) {

    // Remove element leaving
    // Add element entering
    windowSum = windowSum - arr[right - k] + arr[right];

    // Update answer
    answer = Math.max(answer, windowSum);
}
```

The core operation is:

```text
Remove → Add → Update
```

Or:

```text
Old Window
     ↓
Remove Leaving Element
     ↓
Add Entering Element
     ↓
New Window
```

---

# 19. Brute Force vs Optimized

## Brute Force

```java
for (int right = 0; right <= n - k; right++) {

    int sum = 0;

    for (int left = right; left < right + k; left++) {
        sum += arr[left];
    }

    maxSum = Math.max(maxSum, sum);
}
```

The approach is:

```text
Window 1 → Calculate everything

Window 2 → Calculate everything again

Window 3 → Calculate everything again
```

---

## Optimized Sliding Window

```java
// First window
for (int i = 0; i < k; i++) {
    windowSum += arr[i];
}

// Remaining windows
for (int right = k; right < n; right++) {

    windowSum =
        windowSum
        - arr[right - k]
        + arr[right];

    maxSum = Math.max(maxSum, windowSum);
}
```

The approach is:

```text
First Window
     ↓
Calculate Once
     ↓
Remove Old
     ↓
Add New
     ↓
Update
     ↓
Repeat
```

---

# 20. Time and Space Complexity

## Brute Force

The outer loop processes approximately `n` windows.

For every window, the inner loop processes `k` elements.

Therefore:

```text
Time Complexity = O(n × k)
```

Space:

```text
Space Complexity = O(1)
```

---

## Sliding Window

First window:

```text
O(k)
```

Sliding:

```text
O(n)
```

Therefore:

```text
O(k + n)
```

Since:

```text
k <= n
```

we simplify this to:

```text
Time Complexity = O(n)
```

Space:

```text
Space Complexity = O(1)
```

---

## Comparison

| Approach | Time Complexity | Space Complexity |
|---|---:|---:|
| Brute Force | `O(n × k)` | `O(1)` |
| Sliding Window | `O(n)` | `O(1)` |

The optimization changes:

```text
O(n × k)
```

to:

```text
O(n)
```

---

# 21. Common Mistakes

## Mistake 1: Using `arr[k]` Instead of `arr[i]`

### Wrong

```java
for (int i = 0; i < k; i++) {
    windowSum += arr[k];
}
```

If:

```text
k = 3
```

this repeatedly adds:

```text
arr[3]
```

which is:

```text
40
```

So you get:

```text
40 + 40 + 40 = 120
```

instead of:

```text
10 + 20 + 30 = 60
```

### Correct

```java
for (int i = 0; i < k; i++) {
    windowSum += arr[i];
}
```

This adds:

```text
arr[0]
arr[1]
arr[2]
```

which gives:

```text
10 + 20 + 30 = 60
```

---

# Mistake 2: Using `left < left + k`

### Wrong

```java
for (int left = right; left < left + k; left++)
```

The condition is always true because `left + k` also increases when `left` increases.

### Correct

```java
for (int left = right; left < right + k; left++)
```

Here:

```text
right = fixed starting position
left  = moves inside the window
```

---

# Mistake 3: Using `<=` Instead of `<`

### Wrong

```java
left <= right + k
```

This processes:

```text
k + 1
```

elements.

### Correct

```java
left < right + k
```

This processes exactly:

```text
k
```

elements.

---

# Mistake 4: Forgetting to Remove the Leaving Element

### Wrong

```java
windowSum += arr[right];
```

This only adds new elements.

It never removes the old element.

### Correct

```java
windowSum =
    windowSum
    - arr[right - k]
    + arr[right];
```

---

# Mistake 5: Forgetting to Initialize the Answer

After building the first window:

```java
int maxSum = windowSum;
```

Then update it after every slide:

```java
maxSum = Math.max(maxSum, windowSum);
```

---

# 22. How to Recognize Fixed-Size Problems

Look for phrases like:

### Maximum sum of `k` consecutive elements

```text
→ Fixed-Size Sliding Window
```

### Minimum sum of `k` consecutive elements

```text
→ Fixed-Size Sliding Window
```

### Average of every `k` consecutive elements

```text
→ Fixed-Size Sliding Window
```

### Maximum number of vowels in a substring of length `k`

```text
→ Fixed-Size Sliding Window
```

### Count distinct elements in every window of size `k`

```text
→ Fixed-Size Sliding Window
```

The strongest signals are:

```text
"exactly k"

"size k"

"length k"

"k consecutive"

"k contiguous"
```

---

# 23. Important Mental Model

The easiest way to remember Fixed-Size Sliding Window is:

```text
              WINDOW SIZE = K
                     ↓

        ┌─────────────────────┐
        │                     │
        ↓                     ↓
   Element Leaving       Element Entering
        ↓                     ↓
      REMOVE                ADD
        │                     │
        └──────────┬──────────┘
                   ↓
              NEW WINDOW
                   ↓
              UPDATE ANSWER
```

For a sum:

```text
New Sum
=
Old Sum
-
Element Leaving
+
Element Entering
```

---

# 24. Practice Problems

Once you understand the basic maximum-sum problem, practice these.

## Beginner

1. Find the maximum sum of `k` consecutive elements.
2. Find the minimum sum of `k` consecutive elements.
3. Find the average of every `k` consecutive elements.
4. Find the maximum number of vowels in a substring of length `k`.
5. Find the maximum number of `1`s in a binary array within a window of size `k`.

## Intermediate

6. Find the first negative number in every window of size `k`.
7. Find the maximum element in every window of size `k`.
8. Find the minimum element in every window of size `k`.
9. Find the count of distinct elements in every window of size `k`.
10. Find the sum of every window of size `k`.

For problems involving maximum/minimum in every window, you will eventually encounter the **Deque-based Sliding Window** technique.

---

# 25. Quick Revision

## Fixed-Size Sliding Window

### Problem Signal

```text
Exactly K consecutive/contiguous elements
```

---

## Brute Force

```java
for (int right = 0; right <= n - k; right++) {

    int sum = 0;

    for (int left = right; left < right + k; left++) {
        sum += arr[left];
    }

    // Process sum
}
```

Complexity:

```text
O(n × k)
```

---

## Optimized Approach

### Step 1

Build the first window:

```java
for (int i = 0; i < k; i++) {
    windowSum += arr[i];
}
```

### Step 2

Store the answer:

```java
int answer = windowSum;
```

### Step 3

Slide the window:

```java
for (int right = k; right < n; right++) {

    windowSum =
        windowSum
        - arr[right - k]
        + arr[right];

    answer = Math.max(answer, windowSum);
}
```

Complexity:

```text
O(n)
```

---

# ⭐ Most Important Formula

```text
newSum = oldSum - leavingElement + enteringElement
```

For arrays:

```java
windowSum =
    windowSum
    - arr[right - k]
    + arr[right];
```

Remember:

```text
arr[right - k] → Element Leaving

arr[right]      → Element Entering
```

---

# 🧠 One-Line Memory Trick

> **Fixed Window = Build Once → Remove Left → Add Right → Update Answer**

---

# 🔜 Next Topic: Variable-Size Sliding Window

After mastering Fixed-Size Sliding Window, the next concept is **Variable-Size Sliding Window**.

The main difference is:

```text
Fixed Size:

Window size is fixed.
Example: k = 3
```

Whereas:

```text
Variable Size:

Window size can change.
A condition controls when to expand and shrink.
```

The basic mental model is:

```text
right → Expand the window

left  → Shrink the window

condition → Determines when to shrink
```

The general pattern becomes:

```text
Expand
   ↓
Check Condition
   ↓
Shrink if Necessary
   ↓
Update Answer
   ↓
Repeat
```

---
