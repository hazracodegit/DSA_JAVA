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
