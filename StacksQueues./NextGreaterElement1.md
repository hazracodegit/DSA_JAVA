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
