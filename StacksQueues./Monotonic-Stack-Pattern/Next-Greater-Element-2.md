# 🔄 Next Greater Element II (LeetCode 503)

A comprehensive guide and Java implementation for finding the **Next Greater Element** in a **circular array** using both Bruteforce and Monotonic Stack approaches.

---

## 📝 Problem Statement

Given a **circular integer array** `nums` (meaning the next element of the last element is the first element of the array), return the **next greater element** for every element in the array.

The **next greater element** of a number is the **first greater number** encountered while traversing the array to its right. If no such element exists, return **`-1`** for that position.

### Example

* **Input:** `nums = [1, 2, 1]`
* **Output:** `[2, -1, 2]`
* **Explanation:**
  * For `1`, the next greater element is `2`.
  * For `2`, no greater element exists to its right or wrapped around $\rightarrow$ **`-1`**.
  * For the second `1`, since the array is circular, we wrap around to the beginning and find `2`.

---

# 🐢 Bruteforce Approach

## 💡 Intuition
For each element at index `i`, we can simply search through the next `n - 1` elements by using a nested loop and wrapping around using the modulo operator (`% n`). The first element we encounter that is strictly greater than `nums[i]` is our answer. If we complete a full circle without finding a greater element, we assign `-1`.

## ⚙️ Algorithm (Step-by-Step)
1. Initialize a result array `ans` of size `n` filled with `-1`.
2. Outer loop `i` from `0` to `n - 1` to pick each element.
3. Inner loop `j` from `1` to `n - 1` to check subsequent elements using index `(i + j) % n`.
4. If a greater element is found (`nums[(i + j) % n] > nums[i]`), assign it to `ans[i]` and break the inner loop.
5. Return the `ans` array.

## 💻 Java Source Code (Bruteforce)

```java
import java.util.Arrays;

class SolutionBruteforce {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // Check for every element
        for (int i = 0; i < n; i++) {
            // Look ahead for the next greater element in a circular manner
            for (int j = 1; j < n; j++) {
                int nextIndex = (i + j) % n;
                if (nums[nextIndex] > nums[i]) {
                    ans[i] = nums[nextIndex];
                    break; // Found the first greater element, stop searching
                }
            }
        }

        return ans;
    }
}

```


---

# 💡 Intuition

Unlike **Next Greater Element I**, this array is **circular**.

For the last element, we may have to continue searching from the beginning of the array.

Instead of actually creating a doubled array, we simply **traverse the array twice** using:


nums[i % n]
```

The modulo operator (`%`) wraps the index back to the beginning.

---

# 🚀 Optimal Approach (Monotonic Stack)

We use a **Monotonic Decreasing Stack** to store the **indices** of elements whose next greater element has not yet been found.

Whenever the current element is greater than the element at the top index of the stack:

- We have found its next greater element.
- Store the answer.
- Pop the index from the stack.

---

# 🔹 Algorithm

1. Create a result array and initialize all values with **`-1`**.
2. Create an empty **Stack** to store indices.
3. Traverse the array from **`0` to `2 × n - 1`**.
4. Get the current element using **`nums[i % n]`**.
5. While the stack is not empty and the current element is greater than the element at the top index:
   - Store the current element as the next greater element.
   - Pop the stack.
6. Push indices into the stack **only during the first traversal (`i < n`)**.
7. Return the result array.

---

# 🔍 Dry Run

### Input

```text
nums = [1,2,1]
```

### Initial State

```text
Stack = []
Answer = [-1,-1,-1]
```

---

### i = 0

```text
Current = 1

Push index 0

Stack = [0]
```

---

### i = 1

```text
Current = 2

2 > 1

Answer[0] = 2

Pop index 0

Push index 1

Stack = [1]
```

Answer

```text
[2,-1,-1]
```

---

### i = 2

```text
Current = 1

1 > 2 ?

No

Push index 2

Stack = [1,2]
```

---

### Second Traversal

### i = 3

```text
Current = nums[3 % 3]

Current = 1

1 > nums[2] ?

No
```

---

### i = 4

```text
Current = nums[4 % 3]

Current = 2

2 > nums[2]

Yes

Answer[2] = 2

Pop index 2
```

Now

```text
2 > nums[1] ?

No
```

Final Answer

```text
[2,-1,2]
```

---

# 💻 Java Code

```java
import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] < nums[i % n]) {

                ans[stack.pop()] = nums[i % n];
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return ans;
    }
}
```

---

# ⏱️ Time Complexity

### Traversing the Array

- Every index is **pushed exactly once**.
- Every index is **popped at most once**.

```text
O(n)
```

Although we traverse `2 × n` elements, `2n` is still linear.

### ✅ Overall Time Complexity

```text
O(n)
```

---

# 💾 Space Complexity

### Stack

```text
O(n)
```

### Result Array

```text
O(n)
```

### ✅ Overall Space Complexity

```text
O(n)
```

> **Auxiliary Space (excluding the output array):** `O(n)`

---

# 🔑 Key Observations

- ✔️ The array is **circular**, so every element may need to search beyond the last index.
- ✔️ Traversing the array **twice** simulates circular traversal.
- ✔️ `i % n` wraps the index back to the beginning.
- ✔️ The stack stores **indices whose next greater element has not been found**.
- ✔️ Each index is pushed once and popped at most once, resulting in **O(n)** time complexity.
- 🚀 This is an optimized Monotonic Stack 
