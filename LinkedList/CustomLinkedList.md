# Custom Singly Linked List in Java

## 📌 Overview

This project implements a **custom Singly Linked List** in Java without using Java's built-in `LinkedList` class.

The purpose of this project is to understand the internal working of linked lists, including node creation, insertion, deletion, and traversal operations.

---

# 📂 Project Structure

```
CustomLinkedList.java

├── CustomLinkedList
│   ├── main()
│   ├── insertAtBeginning()
│   ├── insertAtEnd()
│   ├── insertAtPosition()
│   ├── deleteAtBeginning()
│   ├── deleteAtEnd()
│   ├── deleteAtPosition()
│   └── display()
│
└── Node
    ├── data
    └── next
```

---

# 🔗 Linked List Structure

A linked list consists of multiple nodes.

Each node contains:

- **data** → Stores the value
- **next** → Stores the reference of the next node

Example:

```
Head
 |
 v
+------+-------+      +------+-------+      +------+------+
| 10   |  next | ---> | 20   | next  | ---> | 30   | null |
+------+-------+      +------+-------+      +------+------+
```

---

# 🧩 Node Class

```java
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
```

### Working

1. Create a new node.
2. Store the value inside `data`.
3. Initialize `next` as `null`.
4. Later connect it with another node.

---

# 💻 Complete Program

```java
import java.util.*;

public class CustomLinkedList{

    static Node head;

    public static void main(String[] args){

        insertAtBeginning(10);
        insertAtEnd(20);
        insertAtBeginning(30);
        insertAtEnd(40);
        insertAtBeginning(50);

        insertAtPosition(60,2);

        deleteAtBeginning();
        deleteAtEnd();
        deleteAtPosition(1);

        display();
    }


    static void insertAtBeginning(int value){

        Node newNode = new Node(value);

        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }


    static void insertAtEnd(int value){

        Node newNode = new Node(value);

        if(head == null){
            head = newNode;
            return;
        }

        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;
    }


    static void insertAtPosition(int value,int pos){

        Node newNode = new Node(value);
        Node temp = head;


        if(pos == 0){
            insertAtBeginning(value);
            return;
        }


        for(int i=0;i<pos-1;i++){

            if(temp == null){
                System.out.println("Invalid Position");
                return;
            }

            temp=temp.next;
        }


        if(temp==null){
            System.out.println("Invalid Position");
            return;
        }


        newNode.next=temp.next;
        temp.next=newNode;
    }



    static void deleteAtBeginning(){

        if(head!=null)
            head=head.next;

        else
            System.out.println("Linked List is empty");
    }



    static void deleteAtEnd(){

        if(head==null){

            System.out.println("Linked List is empty");
            return;
        }


        if(head.next==null){

            head=null;
            return;
        }


        Node temp=head;


        while(temp.next.next!=null){

            temp=temp.next;
        }


        temp.next=null;
    }



    static void deleteAtPosition(int pos){

        if(head==null){

            System.out.println("Linked List is empty");
            return;
        }


        if(pos==0){

            head=head.next;
            return;
        }


        Node temp=head;


        for(int i=0;i<pos-1;i++){

            if(temp==null || temp.next==null){

                System.out.println("Invalid Position");
                return;
            }

            temp=temp.next;
        }


        if(temp.next==null){

            System.out.println("Invalid Position");
            return;
        }


        temp.next=temp.next.next;
    }



    static void display(){

        Node temp=head;


        while(temp!=null){

            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}



class Node{

    int data;
    Node next;


    Node(int data){

        this.data=data;
        this.next=null;
    }
}
```

---

# ⚙️ Operations Explanation

---

# 1. Insert at Beginning

## Function

```java
insertAtBeginning(value);
```

## Steps

1. Create a new node.
2. Check whether the list is empty.
3. If empty, make the new node the head.
4. Otherwise:
   - Connect new node to current head.
   - Move head to new node.

Example:

Before:

```
10 → 20 → 30
```

Insert `5`

After:

```
5 → 10 → 20 → 30
```

### Complexity

Time Complexity: `O(1)`

Space Complexity: `O(1)`

---

# 2. Insert at End

## Function

```java
insertAtEnd(value);
```

## Steps

1. Create a new node.
2. If list is empty, make it head.
3. Otherwise traverse until the last node.
4. Connect last node with new node.

Example:

Before:

```
10 → 20 → 30
```

Insert `40`

After:

```
10 → 20 → 30 → 40
```

### Complexity

Time Complexity: `O(n)`

Space Complexity: `O(1)`

---

# 3. Insert at Position

## Function

```java
insertAtPosition(value,position);
```

## Steps

1. Create a new node.
2. Traverse until the previous position.
3. Connect new node with next node.
4. Connect previous node with new node.

Example:

Before:

```
10 → 20 → 40
```

Insert `30` at position 2:

After:

```
10 → 20 → 30 → 40
```

### Complexity

Time Complexity: `O(n)`

Space Complexity: `O(1)`

---

# 4. Delete at Beginning

## Function

```java
deleteAtBeginning();
```

## Steps

1. Check if list exists.
2. Move head to the next node.
3. Previous first node becomes unused.

Example:

Before:

```
10 → 20 → 30
```

After:

```
20 → 30
```

### Complexity

Time Complexity: `O(1)`

---

# 5. Delete at End

## Function

```java
deleteAtEnd();
```

## Steps

1. Check if list is empty.
2. Traverse to second last node.
3. Make its next reference `null`.

Example:

Before:

```
10 → 20 → 30
```

After:

```
10 → 20
```

### Complexity

Time Complexity: `O(n)`

---

# 6. Delete at Position

## Function

```java
deleteAtPosition(position);
```

## Steps

1. Check if list is empty.
2. If position is zero, update head.
3. Traverse to previous node.
4. Skip the node to delete.

Example:

Before:

```
10 → 20 → 30 → 40
```

Delete position 2:

After:

```
10 → 20 → 40
```

### Complexity

Time Complexity: `O(n)`

---

# 7. Display Linked List

## Function

```java
display();
```

## Steps

1. Start from head.
2. Print node data.
3. Move to next node.
4. Continue until null.

Example Output:

```
30
10
20
```

### Complexity

Time Complexity: `O(n)`

---

# 📊 Complexity Table

| Operation | Time Complexity | Space Complexity |
|----------|----------------|-----------------|
| Insert Beginning | O(1) | O(1) |
| Insert End | O(n) | O(1) |
| Insert Position | O(n) | O(1) |
| Delete Beginning | O(1) | O(1) |
| Delete End | O(n) | O(1) |
| Delete Position | O(n) | O(1) |
| Display | O(n) | O(1) |

---

# ▶️ How to Run

### Compile

```bash
javac CustomLinkedList.java
```

### Execute

```bash
java CustomLinkedList
```

---

# 📚 Concepts Learned

- Classes and Objects
- References in Java
- Node Creation
- Dynamic Data Structures
- Singly Linked List
- Insertion Operations
- Deletion Operations
- Traversal
- Time Complexity Analysis

---

# 🚀 Future Improvements

- Search an element
- Reverse linked list
- Find middle node
- Detect cycle
- Remove duplicates
- Get size of linked list
- Implement Doubly Linked List
- Implement Circular Linked List
- Make Generic Linked List

---

# 👨‍💻 Author

Created as a Data Structures learning project using Java.
