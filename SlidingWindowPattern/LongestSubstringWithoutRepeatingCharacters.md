# Longest Substring Without Repeating Characters

## Problem Statement

Given a string `s`, find the **length of the longest substring without repeating characters**.

### Example

```text
Input:
s = "abcabcbb"

Output:
3
```

The longest substring without repeating characters is `"abc"`.

---

# Core Concept: Variable-Size Sliding Window

This is a classic **variable-sized sliding window** problem.

We maintain a window:

```text
[left ... right]
```

Two pointers control the window:

- `right` → expands the window
- `left` → shrinks the window

The rule is:

> The current window must contain **no duplicate characters**.

When `right` adds a character that already exists in the current window, the window becomes invalid. We then move `left` forward until the duplicate is removed.

## General Pattern

```text
right moves → expand
       ↓
add current element
       ↓
check whether window is valid
       ↓
if invalid
       ↓
left moves → shrink
       ↓
window becomes valid
       ↓
update answer
```

The **expansion and shrinking logic is common** in all three approaches. The only difference is how we track the characters.

---

# Approach 1: HashSet + Sliding Window

## Idea

A `HashSet` stores all characters currently present inside the window.

A `HashSet` is useful because we can quickly ask:

```java
set.contains(ch)
```

> "Is this character already inside my current window?"

If the answer is `true`, adding the character would create a duplicate.

---

## Step-by-Step Example

Consider:

```text
s = "abcabcbb"
```

Start with:

```text
left = 0
Set = {}
```

### Add `a`

```text
Window = "a"
Set = {a}
```

Valid.

### Add `b`

```text
Window = "ab"
Set = {a, b}
```

Valid.

### Add `c`

```text
Window = "abc"
Set = {a, b, c}
```

Valid.

Current maximum length:

```text
3
```

### Add another `a`

Now:

```text
Window = "abca"
```

But `a` is already in the set.

```text
set.contains('a') → true
```

So the window is invalid.

We now move `left`.

First remove the character at `left`:

```text
a b c a
↑
left
```

Remove `a`:

```text
Window = "bca"
Set = {b, c}
```

Now we can add the new `a`:

```text
Set = {a, b, c}
```

The window is valid again.

### Important Point

We **do not assume that the first character is the duplicate**.

For example:

```text
a b c d c
↑       ↑
L       R
```

The duplicate is `c`, not `a`.

We remove from the left:

```text
remove a
remove b
remove c
```

until the old `c` is removed.

---

## Code

```java
import java.util.HashSet;

public class Solution {

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Shrink while duplicate exists
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character
            set.add(ch);

            // Calculate current window length
            int currentLength = right - left + 1;

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
```

## Why does the `while` loop work?

Suppose:

```text
s = "abcdc"
```

When the second `c` arrives:

```text
a b c d c
↑       ↑
L       R
```

`c` already exists.

So:

```java
while (set.contains(c))
```

runs.

### First iteration

Remove `a`:

```text
b c d c
```

`c` still exists.

### Second iteration

Remove `b`:

```text
c d c
```

`c` still exists.

### Third iteration

Remove old `c`:

```text
d c
```

Now `c` no longer exists in the set.

The loop stops.

Then we add the new `c`.

---

## Complexity

```text
Time:  O(n)
Space: O(k)
```

where `k` is the number of distinct characters.

---

# Approach 2: HashMap + Sliding Window

## Idea

Instead of only storing whether a character exists, a `HashMap` stores its **frequency**.

For example:

```text
a → 2
b → 1
c → 1
```

This allows us to know exactly how many times a character occurs in the current window.

---

## Step-by-Step Example

Consider:

```text
s = "abca"
```

Initially:

```text
Map = {}
```

### Add `a`

```text
a → 1
```

### Add `b`

```text
a → 1
b → 1
```

### Add `c`

```text
a → 1
b → 1
c → 1
```

Everything is unique.

### Add second `a`

Now:

```text
a → 2
b → 1
c → 1
```

Because:

```text
a → 2
```

we know the window contains a duplicate.

So we shrink from the left.

Remove the old `a`:

```text
a → 1
b → 1
c → 1
```

Now the window is valid.

---

## Code

```java
import java.util.HashMap;

public class Solution {

    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Increase frequency
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Shrink while current character is duplicated
            while (map.get(ch) > 1) {

                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                left++;
            }

            int currentLength = right - left + 1;

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
```

---

## Why do we check `map.get(ch) > 1`?

`ch` is the character that we just added.

If:

```text
map.get(ch) == 1
```

then it is unique.

If:

```text
map.get(ch) == 2
```

then it is duplicated.

So:

```java
while (map.get(ch) > 1)
```

means:

> Keep shrinking until the newly added character occurs only once.

---

## Complexity

```text
Time:  O(n)
Space: O(k)
```

---

# Approach 3: Frequency Array + Sliding Window

## Idea

If the problem guarantees that the string contains only lowercase English letters (`a-z`), we don't need a `HashMap`.

We can use:

```java
int[] freq = new int[26];
```

Each array index represents one letter:

```text
0 → a
1 → b
2 → c
...
25 → z
```

For a character:

```java
ch - 'a'
```

converts the character into an array index.

For example:

```text
'a' - 'a' = 0
'b' - 'a' = 1
'c' - 'a' = 2
```

---

## Step-by-Step Example

Consider:

```text
s = "abca"
```

Initially:

```text
freq = [0, 0, 0, ...]
```

### Add `a`

```text
freq[0] = 1
```

### Add `b`

```text
freq[1] = 1
```

### Add `c`

```text
freq[2] = 1
```

### Add second `a`

```text
freq[0] = 2
```

Now:

```text
freq['a' - 'a'] > 1
```

So we have a duplicate.

Move `left` forward.

Remove the old `a`:

```java
freq[s.charAt(left) - 'a']--;
```

Now:

```text
freq[0] = 1
```

The window is valid again.

---

## Code

```java
public class Solution {

    public static int lengthOfLongestSubstring(String s) {

        int[] freq = new int[26];

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Add current character
            freq[ch - 'a']++;

            // Shrink while duplicate exists
            while (freq[ch - 'a'] > 1) {

                char leftChar = s.charAt(left);

                freq[leftChar - 'a']--;

                left++;
            }

            int currentLength = right - left + 1;

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
```

---

# Comparing the Three Approaches

| Approach | Stores | Time | Space | Best For |
|---|---|---:|---:|---|
| **HashSet** | Character existence | O(n) | O(k) | ⭐ Easiest to understand |
| **HashMap** | Character frequency | O(n) | O(k) | Frequency-based problems |
| **Frequency Array** | Character frequency | O(n) | O(1)* | ⭐ Fixed alphabet |

`*` O(1) because the array always has 26 positions for lowercase English letters.

---

# What Is Actually Common?

This is the most important thing to remember.

The **data structure changes**, but the **sliding-window logic remains the same**.

### HashSet

```java
while (set.contains(ch)) {
    set.remove(s.charAt(left));
    left++;
}
```

### HashMap

```java
while (map.get(ch) > 1) {
    char leftChar = s.charAt(left);
    map.put(leftChar, map.get(leftChar) - 1);
    left++;
}
```

### Frequency Array

```java
while (freq[ch - 'a'] > 1) {
    freq[s.charAt(left) - 'a']--;
    left++;
}
```

Notice the common structure:

```text
right → expands
        ↓
condition becomes invalid
        ↓
left → shrinks
        ↓
condition becomes valid
        ↓
calculate answer
```

---

# Why Is the Optimized Approach O(n)?

You might wonder:

> "There is a `for` loop and a `while` loop. Why isn't it O(n²)?"

Because both pointers only move forward.

```text
right:
0 → 1 → 2 → 3 → ... → n-1

left:
0 → 1 → 2 → 3 → ... → n-1
```

`right` moves at most `n` times.

`left` also moves at most `n` times.

Therefore:

```text
n + n = 2n
```

Ignoring constants:

```text
O(n)
```

So the optimized sliding-window solution is **O(n)**.

---

# Which Approach Should You Use?

## For Learning Sliding Window

### HashSet ⭐

It is the easiest because we only ask:

```text
"Does this character already exist?"
```

No frequency calculation is needed.

---

## When Frequency Matters

### HashMap

Use it when the problem requires:

```text
character → count
```

For example:

- character frequency
- anagram problems
- frequency matching
- counting occurrences inside a window

---

## When Character Set Is Fixed

### Frequency Array ⭐

If the problem guarantees:

```text
only lowercase a-z
```

then:

```java
int[] freq = new int[26];
```

is simple and efficient.

---

# Final Mental Model

Whenever you see:

> **Longest substring/subarray satisfying a condition**

think:

```text
             Variable Sliding Window
                       ↓
                 left + right
                       ↓
                 right expands
                       ↓
              Check the condition
                       ↓
                Window invalid?
                       ↓
                  left shrinks
                       ↓
                Window valid
                       ↓
                Update maximum
```

## Most Important Rule

> **`right` expands the window. `left` shrinks the window. The data structure only helps us determine whether the current window is valid.**

For this problem:

```text
Valid window = no repeated characters
Invalid window = at least one repeated character
```

So the core pattern is:

```text
Expand → Detect duplicate → Shrink → Become valid → Update answer
```
