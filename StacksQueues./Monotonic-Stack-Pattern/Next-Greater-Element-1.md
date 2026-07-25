# 🚀 Next Greater Element I (LeetCode 496)

## 📝 Problem Statement

You are given two arrays **`nums1`** and **`nums2`**, where `nums1` is a subset of `nums2`.

For every element in **`nums1`**, find the **next greater element** that appears to its **right** in `nums2`.

If no greater element exists, return **`-1`** for that element.

---

## 📌 Example

### **Input**

```text
nums1 = [4,1,2]
nums2 = [1,3,4,2]
```

### **Output**

```text
[-1,3,-1]
```

### **Explanation**

- **4** → No greater element exists on its right → **-1**
- **1** → Next greater element is **3**
- **2** → No greater element exists on its right → **-1**

---

# 💡 Brute Force Approach

### 🔹 Steps

1. Create an empty **HashMap** to store each element and its next greater element.
2. Traverse every element in **`nums2`**.
3. For each element, search towards its right to find the **first greater element**.
4. If a greater element is found, store **(current element → next greater element)** in the HashMap.
5. Create the result array and initialize all elements with **`-1`**.
6. Traverse **`nums1`**.
7. For each element, check whether it exists in the HashMap.
8. If it exists, copy the mapped value into the result array.
9. Return the result array.

---

# 💻 Java Code

```java
import java.util.Arrays;
import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        // Find next greater element for every element in nums2
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[i] < nums2[j]) {
                    map.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }

        // Initialize result array with -1
        Arrays.fill(res, -1);

        // Build the answer for nums1
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                res[i] = map.get(nums1[i]);
            }
        }

        return res;
    }
}
```

---

# ⏱️ Time Complexity

### Building the HashMap

- Nested loops over `nums2`

```text
O(n²)
```

### Initializing the Result Array

```text
O(m)
```

### Building the Final Answer

```text
O(m)
```

### ✅ Overall Time Complexity

```text
O(n² + m)
```

If **`m ≈ n`**, then

```text
O(n²)
```

---

# 💾 Space Complexity

### HashMap

```text
O(n)
```

### Result Array

```text
O(m)
```

### ✅ Overall Space Complexity

```text
O(n + m)
```

> **Auxiliary Space (excluding the output array):** `O(n)`

---

# 🔑 Key Observations

- ✔️ Store only the **first greater element** for every element in `nums2`.
- ✔️ A **HashMap** allows **O(1)** average lookup while constructing the final answer.
- ❌ The nested loops make the brute-force approach **O(n²)**.
- 🚀 This can be optimized to **O(n + m)** using a **Monotonic Stack + HashMap**.

---


--------------------------------------------------------------------------------------------------------------

# 🚀 Optimal Approach (Monotonic Stack + HashMap)

Instead of searching for the next greater element for every number repeatedly, we process **`nums2` only once** and store the next greater element for each number in a **HashMap**.

A **Monotonic Decreasing Stack** helps us find the next greater element in **O(n)** time.

---

# 💡 Intuition

Think of the stack as storing the elements that are **still waiting** for their next greater element.

Whenever we encounter a larger element, we can immediately resolve the waiting elements that are smaller than it.

---

# 🔹 Steps

1. Create an empty **Stack** and **HashMap**.
2. Traverse every element in **`nums2`** from left to right.
3. While the stack is not empty **and** the current element is greater than the top of the stack:
   - The current element is the **next greater element** of the stack's top.
   - Store `(stackTop → currentElement)` in the HashMap.
   - Pop the stack.
4. Push the current element onto the stack.
5. After traversal, the elements left in the stack have **no next greater element**.
6. Store `(element → -1)` for every remaining element in the HashMap.
7. Create the result array.
8. Traverse **`nums1`** and fetch the answer directly from the HashMap.
9. Return the result array.

---

# 🔍 Dry Run

### Input

```text
nums2 = [1,3,4,2]
```

### Initial State

```text
Stack = []
Map = {}
```

---

### Current = 1

Push into stack.

```text
Stack = [1]
Map = {}
```

---

### Current = 3

Since **3 > 1**

```text
1 → 3
```

Pop **1** and push **3**.

```text
Stack = [3]
Map = {1=3}
```

---

### Current = 4

Since **4 > 3**

```text
3 → 4
```

Pop **3** and push **4**.

```text
Stack = [4]
Map = {1=3, 3=4}
```

---

### Current = 2

Since **2 < 4**

Push **2**.

```text
Stack = [4,2]
Map = {1=3, 3=4}
```

Traversal completed.

Elements remaining in the stack have no greater element.

```text
4 → -1
2 → -1
```

Final Map

```text
{
1=3,
3=4,
4=-1,
2=-1
}
```

Now for

```text
nums1 = [4,1,2]
```

Answer becomes

```text
4 → -1
1 → 3
2 → -1
```

Output

```text
[-1,3,-1]
```

---

# 💻 Java Code

```java
import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Build next greater map
        for (int num : nums2) {

            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        // Remaining elements have no next greater element
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build result
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}
```

---

# ⏱️ Time Complexity

### Processing `nums2`

- Every element is **pushed once**.
- Every element is **popped at most once**.

```text
O(n)
```

### Building the Result

```text
O(m)
```

### ✅ Overall Time Complexity

```text
O(n + m)
```

---

# 💾 Space Complexity

### Stack

```text
O(n)
```

### HashMap

```text
O(n)
```

### Result Array

```text
O(m)
```

### ✅ Overall Space Complexity

```text
O(n + m)
```

> **Auxiliary Space (excluding the output array):** `O(n)`

---

# 🔑 Key Observations

- ✔️ The stack stores elements whose **next greater element has not been found yet**.
- ✔️ Whenever a larger element is encountered, it becomes the next greater element for all smaller elements on the top of the stack.
- ✔️ Each element is pushed and popped **only once**, giving an **O(n)** stack-processing time.
- 🚀 This is much more efficient than the brute-force **O(n²)** approach.
