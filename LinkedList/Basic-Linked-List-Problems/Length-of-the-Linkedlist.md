# Find Length of a Linked List in Java

## 📌 Problem Statement

Given the head of a singly linked list, find the number of nodes present in the linked list.

The length of a linked list is the total count of nodes from the first node (`head`) to the last node (`null`).

---

## 💡 Example

### Input

```
Head
 |
 v
10 -> 20 -> 30 -> 40 -> null
```

### Output

```
Length = 4
```

### Explanation

The linked list contains 4 nodes:

```
10, 20, 30, 40
```

Therefore, the length of the linked list is `4`.

---

# Approach 1: Iterative Traversal

## 🧠 Logic

The simplest way to find the length of a linked list is to traverse through every node and maintain a counter.

### Steps

1. Initialize a counter variable `count` with `0`.
2. Create a temporary pointer `temp` pointing to `head`.
3. Traverse the linked list until `temp` becomes `null`.
4. For every node:
   - Increment `count`.
   - Move `temp` to the next node.
5. Return the final count.

---

# Java Implementation

```java
public class LinkedListLength {


    static class Node {

        int data;
        Node next;


        Node(int data) {

            this.data = data;
            this.next = null;
        }
    }


    static Node head;


    static int getLength() {

        int count = 0;

        Node temp = head;


        while(temp != null) {

            count++;

            temp = temp.next;
        }


        return count;
    }



    public static void main(String[] args) {


        head = new Node(10);

        head.next = new Node(20);

        head.next.next = new Node(30);

        head.next.next.next = new Node(40);



        int length = getLength();


        System.out.println("Length = " + length);
    }
}
```

---

# Output

```
Length = 4
```

---

# Dry Run

Linked List:

```
10 -> 20 -> 30 -> 40 -> null
```

Initial:

```
count = 0
temp = 10
```

### Iteration 1

```
count = 1
temp = 20
```

### Iteration 2

```
count = 2
temp = 30
```

### Iteration 3

```
count = 3
temp = 40
```

### Iteration 4

```
count = 4
temp = null
```

Loop stops because `temp == null`.

Final answer:

```
Length = 4
```

---

# Approach 2: Recursive Solution

## 🧠 Logic

A linked list can be considered as:

```
Current Node + Remaining Linked List
```

For every node:

```
length = 1 + length(next node)
```

When we reach `null`, we return `0`.

---

# Java Implementation

```java
static int getLengthRecursive(Node temp) {

    if(temp == null)
        return 0;


    return 1 + getLengthRecursive(temp.next);
}
```

Calling:

```java
int length = getLengthRecursive(head);
```

---

# Recursive Working

Example:

```
10 -> 20 -> 30 -> null
```

Function calls:

```
length(10)
= 1 + length(20)

= 1 + 1 + length(30)

= 1 + 1 + 1 + length(null)

= 3
```

---

# Complexity Analysis

## Iterative Approach

| Type | Complexity |
|------|------------|
| Time | O(n) |
| Space | O(1) |

Explanation:

- Every node is visited once.
- Only one pointer and one counter are used.

---

## Recursive Approach

| Type | Complexity |
|------|------------|
| Time | O(n) |
| Space | O(n) |

Explanation:

- Every node is visited once.
- Recursive calls use stack memory.

---

# Edge Cases

## 1. Empty Linked List

Input:

```
head = null
```

Output:

```
Length = 0
```

---

## 2. Single Node

Input:

```
10 -> null
```

Output:

```
Length = 1
```

---

## 3. Multiple Nodes

Input:

```
10 -> 20 -> 30
```

Output:

```
Length = 3
```

---

# Concepts Learned

- Linked List Traversal
- Node References
- Iteration
- Recursion
- Time Complexity Analysis

---

# Related Problems

After solving this problem, practice:

1. Search an element in Linked List
2. Reverse a Linked List
3. Find Middle Node
4. Detect Cycle in Linked List
5. Remove Nth Node From End
6. Merge Two Sorted Linked Lists

---

# Author

Created as part of Data Structures and Algorithms practice using Java.
