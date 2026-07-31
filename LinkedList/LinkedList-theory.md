# Linked List in Java

## 1. What is a Linked List?

A **Linked List** is a linear data structure where elements are stored in individual objects called **nodes**. Each node contains:

** A Linked List is also a collection of nodes. **

1. **Data** - The value stored in the node.
2. **Reference (Pointer)** - A link to the next node in the sequence.

Unlike arrays, linked list elements are **not stored in contiguous memory locations**. Nodes can be placed anywhere in memory and are connected using references.

### Node Structure

A basic singly linked list node looks like this:

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

Example:

```
Head
 |
 v
+------+------+
| 10   |  o----+
+------+------+
              |
              v
        +------+------+
        | 20   |  o----+
        +------+------+
                     |
                     v
               +------+------+
               | 30   | null |
               +------+------+
```

Each node stores:

* The actual value (`data`)
* The address/reference of the next node (`next`)

---

# 2. Why Do We Need Linked Lists?

Arrays have some limitations:

## Problem 1: Fixed Size

Arrays require a predefined size.

Example:

```java
int[] arr = new int[5];
```

If more elements are needed, we need to create a new array and copy the existing elements.

Linked Lists grow dynamically because new nodes can be created whenever required.

---

## Problem 2: Costly Insertions and Deletions

In arrays, inserting at the beginning requires shifting elements.

Example:

Before:

```
10 20 30 40
```

Insert 5:

```
5 10 20 30 40
```

All elements need to move.

Time Complexity: **O(n)**

In a linked list:

Before:

```
10 → 20 → 30
```

Create a new node:

```
5
```

Change references:

```
5 → 10 → 20 → 30
```

Time Complexity: **O(1)**

---

# 3. Important Characteristics of Linked Lists

## 1. Dynamic Size

Linked Lists can grow and shrink during runtime.

Example:

```
10 → 20 → 30
```

Adding a new element:

```
10 → 20 → 30 → 40
```

No resizing is required.

---

## 2. Non-contiguous Memory Allocation

Array:

```
100 104 108 112
[10][20][30][40]
```

Linked List:

```
100        500        900
[10] ---> [20] ---> [30]
```

Nodes can exist anywhere in memory.

---

## 3. Efficient Insertions and Deletions

Adding or removing nodes only requires changing references.

Example:

Remove 20:

Before:

```
10 → 20 → 30
```

After:

```
10 → 30
```

Only the links change.

---

## 4. Sequential Access

Linked Lists do not support direct indexing.

Array:

```java
arr[5]
```

Direct access:

```
O(1)
```

Linked List:

```
head → node1 → node2 → node3 → node4
```

To reach node 5, we must traverse.

Time:

```
O(n)
```

---

## 5. Extra Memory Usage

Each node stores an additional reference.

Example:

```
+------+------+
| data | next |
+------+------+
```

The `next` pointer requires extra memory.

---

# 4. Types of Linked Lists

## 1. Singly Linked List

Each node points only to the next node.

Structure:

```
10 → 20 → 30 → null
```

Node:

```java
class Node {
    int data;
    Node next;
}
```

---

## 2. Doubly Linked List

Each node contains:

* Previous node reference
* Data
* Next node reference

Structure:

```
null ← 10 ⇄ 20 ⇄ 30 → null
```

Node:

```java
class Node {
    int data;
    Node prev;
    Node next;
}
```

---

## 3. Circular Linked List

The last node points back to the first node.

```
10 → 20 → 30
↑         |
|_________|
```

---

# 5. Array vs Linked List

| Feature             | Array        | Linked List           |
| ------------------- | ------------ | --------------------- |
| Memory allocation   | Continuous   | Non-contiguous        |
| Size                | Fixed        | Dynamic               |
| Access by index     | O(1)         | O(n)                  |
| Search              | O(n)         | O(n)                  |
| Insert at beginning | O(n)         | O(1)                  |
| Delete at beginning | O(n)         | O(1)                  |
| Insert at end       | O(1) average | O(1) if tail exists   |
| Memory usage        | Less         | More (extra pointers) |
| Cache performance   | Better       | Worse                 |
| Implementation      | Simple       | More complex          |

---

# 6. Java Built-in LinkedList

Java provides a built-in implementation:

```java
import java.util.LinkedList;

LinkedList<Integer> list = new LinkedList<>();
```

Java's `LinkedList` internally uses a **doubly linked list**.

Each node contains:

```
+---------+------+---------+
| previous| data | next    |
+---------+------+---------+
```

It maintains references to:

* First node
* Last node

This allows efficient operations at both ends.

---

# 7. Important Java LinkedList Methods

## Creating a LinkedList

```java
LinkedList<Integer> list = new LinkedList<>();
```

---

# Adding Elements

## add()

Adds element at the end.

```java
list.add(10);
list.add(20);
list.add(30);
```

Result:

```
10 ⇄ 20 ⇄ 30
```

Complexity:

```
O(1)
```

---

## addFirst()

Adds element at the beginning.

```java
list.addFirst(5);
```

Result:

```
5 ⇄ 10 ⇄ 20 ⇄ 30
```

Complexity:

```
O(1)
```

---

## addLast()

Adds element at the end.

```java
list.addLast(40);
```

Complexity:

```
O(1)
```

---

## add(index, value)

Insert at a specific position.

```java
list.add(2, 25);
```

Complexity:

```
O(n)
```

---

# Removing Elements

## remove()

Remove using index.

```java
list.remove(2);
```

---

## removeFirst()

```java
list.removeFirst();
```

Complexity:

```
O(1)
```

---

## removeLast()

```java
list.removeLast();
```

Complexity:

```
O(1)
```

---

# Accessing Elements

## get()

Get element at index.

```java
int value = list.get(2);
```

Complexity:

```
O(n)
```

---

## getFirst()

```java
list.getFirst();
```

Complexity:

```
O(1)
```

---

## getLast()

```java
list.getLast();
```

Complexity:

```
O(1)
```

---

# Searching

## contains()

Checks whether an element exists.

```java
list.contains(20);
```

Complexity:

```
O(n)
```

---

# Size

```java
list.size();
```

Returns number of elements.

Complexity:

```
O(1)
```

---

# Clear List

```java
list.clear();
```

Removes all elements.

---

# 8. LinkedList as Queue

Java LinkedList can implement Queue.

Example:

```java
Queue<Integer> queue = new LinkedList<>();

queue.offer(10);
queue.offer(20);
queue.offer(30);

queue.poll();
```

Queue:

```
Front
 |
10 → 20 → 30
          |
        Rear
```

Common methods:

| Method    | Purpose              |
| --------- | -------------------- |
| offer()   | Insert element       |
| poll()    | Remove front element |
| peek()    | View front element   |
| isEmpty() | Check empty          |

---

# 9. LinkedList as Deque

A Deque allows insertion/removal from both ends.

```java
Deque<Integer> deque = new LinkedList<>();

deque.addFirst(10);
deque.addLast(20);

deque.removeFirst();
deque.removeLast();
```

Used in:

* Sliding window problems
* BFS traversal
* Monotonic queue problems

---

# 10. When to Use LinkedList?

Use LinkedList when:

* Frequent insertion/deletion is required.
* Random access is not important.
* You need queue/deque behavior.

Examples:

* Browser history
* Music playlists
* Undo/Redo operations
* Queue implementation
* Graph adjacency lists

---

# Interview Notes

For coding interview problems:

Use custom nodes when solving:

* Reverse Linked List
* Detect Cycle
* Merge Two Lists
* Find Middle Node
* Remove Nodes
* Linked List Reversal Problems

Example:

```java
class ListNode {
    int val;
    ListNode next;
}
```

Use Java's built-in LinkedList when the problem only requires:

* Queue operations
* Deque operations
* General collection usage

---

# Key Takeaways

* A Linked List stores elements as connected nodes.
* Each node contains data and a reference to another node.
* Linked Lists provide efficient insertion and deletion compared to arrays.
* Arrays provide faster random access.
* Java's LinkedList is a doubly linked list implementation.
* Understanding node manipulation is essential for solving linked list interview problems.

