# 📚 Java Strings — Complete Notes

> **A complete guide to Strings in Java, from fundamentals to advanced concepts, with examples, memory diagrams, coding problems, and interview questions.**

---

## 📑 Table of Contents

1. [Introduction to Strings](#-1-introduction-to-strings)
2. [Creating Strings](#-2-creating-strings)
3. [String Constant Pool](#-3-string-constant-pool)
4. [String Immutability](#-4-string-immutability)
5. [String Memory Management](#-5-string-memory-management)
6. [String Methods](#-6-important-string-methods)
7. [String Comparison](#-7-string-comparison)
8. [String Concatenation](#-8-string-concatenation)
9. [StringBuilder](#-9-stringbuilder)
10. [StringBuffer](#-10-stringbuffer)
11. [String vs StringBuilder vs StringBuffer](#-11-string-vs-stringbuilder-vs-stringbuffer)
12. [String Formatting](#-12-string-formatting)
13. [Character and String Conversion](#-13-character-and-string-conversion)
14. [String Arrays and Character Arrays](#-14-string-arrays-and-character-arrays)
15. [Important String Algorithms](#-15-important-string-algorithms)
16. [Time Complexity](#-16-time-complexity)
17. [Common Mistakes](#-17-common-mistakes)
18. [Java String Interview Questions](#-18-java-string-interview-questions)
19. [Practice Problems](#-19-practice-problems)
20. [Quick Revision](#-20-quick-revision)

---

## 🔹 1. Introduction to Strings

A **String** is a sequence of characters used to represent text in Java.

Examples:

```java
String name = "Hazra";
String language = "Java";
String message = "Hello World!";
```

### Key Points

- **`String` is a class** in the `java.lang` package.
- Strings are **immutable**, meaning their contents cannot be changed after creation.
- Java Strings use **UTF-16 code units** internally as their conceptual character representation. Some Unicode characters require two `char` values.
- Strings can be created using literals or the `new` keyword.
- The `String` class provides many built-in methods for searching, comparing, extracting, and transforming text.

### What is a String?

```java
String text = "JAVA";
```

Conceptually:

```text
Index:       0   1   2   3
Character:   J   A   V   A
```

**Important:** String indexing starts from `0`.

---

## 🔹 2. Creating Strings

There are two common ways to create a String.

### 2.1 Using a String Literal

```java
String s1 = "Java";
String s2 = "Java";
```

Java reuses the same pooled String object for identical string literals.

```java
System.out.println(s1 == s2); // true
```

### 2.2 Using the `new` Keyword

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);      // false
System.out.println(s1.equals(s2)); // true
```

The `new` keyword creates a distinct String object for each expression here, even though the contents are identical.

### Difference

| String Literal | `new String()` |
|---|---|
| Uses the String pool when possible | Creates a new String object |
| Identical literals can share an object | Each `new` expression creates a distinct object |
| Usually preferred | Often unnecessary |
| `==` can be true for identical literals | `==` is false for these two objects |

---

## 🔹 3. String Constant Pool

The **String Constant Pool** is a special area of JVM memory used to reuse String objects.

### Example

```java
String a = "Java";
String b = "Java";
String c = new String("Java");

System.out.println(a == b); // true
System.out.println(a == c); // false
System.out.println(a.equals(c)); // true
```

### Memory Concept

```text
String Pool
+-------------------+
|      "Java"       | <---- a
+-------------------+ <---- b

Heap
+-------------------+
|      "Java"       | <---- c
+-------------------+
```

The diagram is conceptual: the literal's pooled object and the object created by `new` are distinct.

### What Does `intern()` Do?

The `intern()` method returns the canonical pooled representation of a String.

```java
String a = new String("Java");
String b = a.intern();
String c = "Java";

System.out.println(b == c); // true
```

**Remember:** `intern()` does not modify the original String. It returns a reference to the canonical pooled String.

---

## 🔹 4. String Immutability

**Immutability means an object's state cannot be changed after it has been created.**

In Java, a String's contents cannot be modified after creation.

### Example

```java
String s = "Hello";

s.concat(" World");

System.out.println(s); // Hello
```

Why?

Because `concat()` returns a new String. It does not modify the existing one.

Correct approach:

```java
String s = "Hello";

s = s.concat(" World");

System.out.println(s); // Hello World
```

The variable `s` now references a new String object.

### Another Example

```java
String language = "Java";

language.toUpperCase();

System.out.println(language); // Java
```

Correct:

```java
language = language.toUpperCase();

System.out.println(language); // JAVA
```

### Why Are Strings Immutable?

- **Security:** Useful for values such as file paths, class names, and connection-related text.
- **String pool:** Shared String instances can be reused safely.
- **Thread safety:** The contents can be shared between threads without synchronization to protect the String itself.
- **Hashing:** A String's hash code can be cached because its contents do not change.
- **Predictability:** String values cannot be altered through another reference.

**Interview Tip:** Methods such as `replace()`, `substring()`, `toUpperCase()`, and `trim()` return a String. They do not change the original String.

---

## 🔹 5. String Memory Management

### Stack and Heap Concept

```java
String s1 = "Java";
String s2 = new String("Python");
```

Conceptually:

- Local variables and references are associated with a method's execution.
- String objects are objects managed in the JVM heap.
- String literals use pooled String objects.
- Objects that are no longer reachable can become eligible for garbage collection.

**Important:** Do not assume that every String literal exists only in the heap or that all JVM memory details are identical across every Java version and implementation.

### Example

```java
String s = "Hello";
s = "World";
```

The original `"Hello"` String is not modified. The variable now references `"World"`.

The original object can remain available if another reference points to it or if it is otherwise retained by the JVM.

---

## 🔹 6. Important String Methods

Consider:

```java
String s = "Hello Java";
```

| Method | Description | Example | Result |
|---|---|---|---|
| `length()` | Returns UTF-16 code unit count | `s.length()` | `10` |
| `charAt(i)` | Returns the `char` at an index | `s.charAt(1)` | `'e'` |
| `substring(a)` | Extracts from index `a` | `s.substring(6)` | `"Java"` |
| `substring(a, b)` | Extracts from `a` to `b - 1` | `s.substring(0, 5)` | `"Hello"` |
| `equals()` | Compares contents | `s.equals("Hello Java")` | `true` |
| `equalsIgnoreCase()` | Ignores case differences | `"java".equalsIgnoreCase("JAVA")` | `true` |
| `compareTo()` | Lexicographic comparison | `"abc".compareTo("abd")` | `-1` |
| `contains()` | Checks for a substring | `s.contains("Java")` | `true` |
| `indexOf()` | Finds the first occurrence | `s.indexOf('a')` | `7` |
| `lastIndexOf()` | Finds the last occurrence | `s.lastIndexOf('a')` | `9` |
| `startsWith()` | Checks the prefix | `s.startsWith("Hello")` | `true` |
| `endsWith()` | Checks the suffix | `s.endsWith("Java")` | `true` |
| `toUpperCase()` | Converts to uppercase | `"java".toUpperCase()` | `"JAVA"` |
| `toLowerCase()` | Converts to lowercase | `"JAVA".toLowerCase()` | `"java"` |
| `replace()` | Replaces literal characters or sequences | `"banana".replace('a', 'o')` | `"bonono"` |
| `isEmpty()` | Checks whether length is zero | `"".isEmpty()` | `true` |
| `isBlank()` | Checks whether text is empty or whitespace | `"   ".isBlank()` | `true` |
| `trim()` | Removes leading/trailing characters up to U+0020 | `"  Java  ".trim()` | `"Java"` |
| `strip()` | Removes leading/trailing Unicode whitespace | `"  Java  ".strip()` | `"Java"` |
| `split()` | Splits using a regular expression | `"a,b,c".split(",")` | `["a","b","c"]` |
| `toCharArray()` | Converts to a `char[]` | `"Java".toCharArray()` | `['J','a','v','a']` |
| `repeat(n)` | Repeats a String | `"Hi".repeat(3)` | `"HiHiHi"` |

**Note:** `isBlank()` and `repeat()` were introduced in Java 11. Use a compatible JDK when practising.

### Example Program

```java
public class StringMethods {
    public static void main(String[] args) {
        String s = "Hello Java";

        System.out.println(s.length());
        System.out.println(s.charAt(0));
        System.out.println(s.substring(6));
        System.out.println(s.contains("Java"));
        System.out.println(s.toUpperCase());
        System.out.println(s.replace("Java", "World"));
        System.out.println(s.indexOf('a'));
    }
}
```

Output:

```text
10
H
Java
true
HELLO JAVA
Hello World
7
```

### Important Index Rules

For a String of length `n`:

- Valid character indexes are `0` through `n - 1`.
- `substring(begin, end)` includes `begin` but excludes `end`.
- `charAt(n)` throws `StringIndexOutOfBoundsException`.
- `substring(n)` returns an empty String.
- `indexOf()` returns `-1` if the requested character or substring is not found.

---

## 🔹 7. String Comparison

Java provides several ways to compare Strings.

### 7.1 `==` Operator

Compares **object references**, not String contents.

```java
String a = new String("Java");
String b = new String("Java");

System.out.println(a == b); // false
```

### 7.2 `equals()`

Compares String contents.

```java
String a = new String("Java");
String b = new String("Java");

System.out.println(a.equals(b)); // true
```

### 7.3 `equalsIgnoreCase()`

Compares text without distinguishing uppercase and lowercase in the usual case-insensitive comparison.

```java
String a = "java";
String b = "JAVA";

System.out.println(a.equalsIgnoreCase(b)); // true
```

### 7.4 `compareTo()`

Performs lexicographic comparison based on String character values.

```java
System.out.println("apple".compareTo("banana")); // negative
System.out.println("cat".compareTo("cat"));      // 0
System.out.println("dog".compareTo("cat"));      // positive
```

**Remember:**

- `==` → reference comparison.
- `equals()` → content comparison.
- `compareTo()` → lexicographic ordering.
- `equalsIgnoreCase()` → case-insensitive content comparison.

---

## 🔹 8. String Concatenation

Concatenation means joining Strings together.

### Using the `+` Operator

```java
String first = "Hello";
String second = "World";

String result = first + " " + second;

System.out.println(result); // Hello World
```

### Using `concat()`

```java
String a = "Hello";
String b = " Java";

String result = a.concat(b);

System.out.println(result); // Hello Java
```

### The Problem with Repeated Concatenation

```java
String result = "";

for (int i = 0; i < 1000; i++) {
    result = result + i;
}
```

Because Strings are immutable, repeated concatenation can create many intermediate String objects and perform unnecessary copying.

For larger or repeated modifications, **use `StringBuilder`**.

```java
StringBuilder result = new StringBuilder();

for (int i = 0; i < 1000; i++) {
    result.append(i);
}

System.out.println(result);
```

Modern Java compilers may optimize some concatenation expressions, but `StringBuilder` remains a useful choice for repeated modifications inside loops.

---

## 🔹 9. StringBuilder

**`StringBuilder` is a mutable sequence of characters.** Unlike String, its contents can be changed without creating a new String for every modification.

### Creating a StringBuilder

```java
StringBuilder sb = new StringBuilder();

StringBuilder sb2 = new StringBuilder("Hello");

StringBuilder sb3 = new StringBuilder(50);
```

- `new StringBuilder()` creates an empty builder with default capacity.
- `new StringBuilder("Hello")` initializes it with the specified text.
- `new StringBuilder(50)` sets the initial capacity to 50 characters.

**Capacity is not the same as length.**

```java
StringBuilder sb = new StringBuilder();

System.out.println(sb.length());   // 0
System.out.println(sb.capacity()); // 16
```

The default initial capacity is 16.

### Important StringBuilder Methods

| Method | Purpose | Example |
|---|---|---|
| `append()` | Adds content to the end | `sb.append("Java")` |
| `insert()` | Inserts content at an index | `sb.insert(0, "Hi ")` |
| `replace()` | Replaces a range | `sb.replace(0, 2, "Hello")` |
| `delete()` | Removes a range | `sb.delete(0, 2)` |
| `deleteCharAt()` | Removes one character | `sb.deleteCharAt(0)` |
| `reverse()` | Reverses the sequence | `sb.reverse()` |
| `charAt()` | Reads a character | `sb.charAt(0)` |
| `setCharAt()` | Changes a character | `sb.setCharAt(0, 'J')` |
| `length()` | Returns current length | `sb.length()` |
| `capacity()` | Returns allocated character capacity | `sb.capacity()` |
| `ensureCapacity()` | Requests minimum capacity | `sb.ensureCapacity(100)` |
| `setLength()` | Changes logical length | `sb.setLength(3)` |
| `toString()` | Produces an immutable String | `sb.toString()` |

### Example 1: `append()`

```java
StringBuilder sb = new StringBuilder("Hello");

sb.append(" Java");

System.out.println(sb); // Hello Java
```

### Example 2: `insert()`

```java
StringBuilder sb = new StringBuilder("Hello");

sb.insert(5, " World");

System.out.println(sb); // Hello World
```

### Example 3: `replace()`

```java
StringBuilder sb = new StringBuilder("Hello World");

sb.replace(6, 11, "Java");

System.out.println(sb); // Hello Java
```

The ending index is exclusive.

### Example 4: `delete()`

```java
StringBuilder sb = new StringBuilder("Hello World");

sb.delete(5, 11);

System.out.println(sb); // Hello
```

### Example 5: `reverse()`

```java
StringBuilder sb = new StringBuilder("Java");

sb.reverse();

System.out.println(sb); // avaJ
```

### Example 6: `setCharAt()`

```java
StringBuilder sb = new StringBuilder("Java");

sb.setCharAt(0, 'K');

System.out.println(sb); // Kava
```

### Example 7: `toString()`

```java
StringBuilder sb = new StringBuilder("Hello");

String result = sb.toString();

System.out.println(result); // Hello
```

This is useful when a method requires a String rather than a StringBuilder.

### Example 8: StringBuilder Capacity

```java
StringBuilder sb = new StringBuilder(10);

sb.append("Java");

System.out.println(sb.length());   // 4
System.out.println(sb.capacity()); // 10

sb.ensureCapacity(50);

System.out.println(sb.capacity()); // At least 50
```

**Important:** Capacity is the available internal storage before growth is needed. It is not the number of characters currently stored.

### Complete StringBuilder Program

```java
public class BuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Java");

        sb.append(" Programming");
        System.out.println(sb);

        sb.insert(4, " Language");
        System.out.println(sb);

        sb.replace(0, 4, "Python");
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb.toString());
    }
}
```

### Why Is StringBuilder Efficient?

- It is mutable.
- It is useful for repeated text modifications.
- It reduces the need for intermediate immutable Strings.
- It provides convenient methods such as `append()`, `insert()`, and `delete()`.

**Note:** `StringBuilder` is not synchronized. Avoid sharing a mutable builder across threads without appropriate synchronization.

---

## 🔹 10. StringBuffer

**`StringBuffer` is a mutable character sequence whose methods are synchronized.**

It offers many methods similar to `StringBuilder`.

```java
StringBuffer sb = new StringBuffer("Hello");

sb.append(" Java");

System.out.println(sb); // Hello Java
```

### StringBuffer vs StringBuilder

- Both are mutable.
- Both support operations such as `append()`, `insert()`, `delete()`, and `reverse()`.
- `StringBuffer` synchronizes its methods.
- `StringBuilder` does not synchronize its methods and is generally preferred for single-threaded use.
- Synchronization does not automatically make a multi-step operation involving a shared buffer atomic.

### Example

```java
public class BufferDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Java");

        sb.append(" Programming");
        sb.insert(4, " Language");

        System.out.println(sb);
    }
}
```

Output:

```text
Java Language Programming
```

---

## 🔹 11. String vs StringBuilder vs StringBuffer

| Feature | String | StringBuilder | StringBuffer |
|---|---|---|---|
| Mutability | Immutable | Mutable | Mutable |
| Can modify existing contents? | No | Yes | Yes |
| Synchronization | Immutable content is safe to share | Not synchronized | Methods are synchronized |
| Repeated modifications | Often less suitable | Generally efficient | Can incur synchronization overhead |
| Typical use | Fixed text | Building or editing text | Shared mutable text with synchronized methods |
| `append()` | Returns a String | Returns the builder | Returns the buffer |
| `reverse()` | Not available as an instance method | Available | Available |

### Which One Should You Use?

- **String:** For fixed text, names, messages, and values that should not change.
- **StringBuilder:** For repeated modifications, loops, and algorithmic problems.
- **StringBuffer:** When its synchronized methods are specifically useful for a shared mutable character sequence.

---

## 🔹 12. String Formatting

Java supports formatted Strings through `String.format()`.

### Example

```java
String name = "Hazra";
int age = 20;
double cgpa = 9.53;

String result = String.format(
    "Name: %s, Age: %d, CGPA: %.2f",
    name, age, cgpa
);

System.out.println(result);
```

Output:

```text
Name: Hazra, Age: 20, CGPA: 9.53
```

### Common Format Specifiers

| Specifier | Meaning |
|---|---|
| `%s` | String representation |
| `%d` | Integer |
| `%f` | Floating-point value |
| `%.2f` | Floating-point value with two digits after the decimal point |
| `%c` | Character |
| `%b` | Boolean representation |
| `%n` | Platform-specific newline |

**Tip:** Formatting is useful for reports, logs, readable output, and interview coding problems.

---

## 🔹 13. Character and String Conversion

### String to Character Array

```java
String s = "Java";

char[] chars = s.toCharArray();

for (char ch : chars) {
    System.out.println(ch);
}
```

### Character Array to String

```java
char[] chars = {'J', 'a', 'v', 'a'};

String s = new String(chars);

System.out.println(s); // Java
```

### Integer to String

```java
int num = 123;

String s = String.valueOf(num);

System.out.println(s); // 123
```

Alternatively:

```java
String s = Integer.toString(123);
```

### String to Integer

```java
String s = "123";

int num = Integer.parseInt(s);

System.out.println(num + 10); // 133
```

Invalid numeric text causes `NumberFormatException`.

### String to Character Array vs `charAt()`

Use `charAt(i)` when you only need to access a character by index.

Use `toCharArray()` when you want a separate, mutable character array to process.

**Unicode note:** A Java `char` represents a UTF-16 code unit, not necessarily a complete Unicode character. For text containing supplementary Unicode characters, consider code-point methods such as `codePoints()`.

---

## 🔹 14. String Arrays and Character Arrays

### Array of Strings

```java
String[] names = {"Hazra", "Aisha", "Sara"};

for (String name : names) {
    System.out.println(name);
}
```

### Array of Characters

```java
char[] letters = {'J', 'A', 'V', 'A'};

System.out.println(new String(letters)); // JAVA
```

### Splitting a String

```java
String sentence = "Java is easy";

String[] words = sentence.split(" ");

for (String word : words) {
    System.out.println(word);
}
```

Output:

```text
Java
is
easy
```

**Important:** `split()` accepts a regular expression. To split on a literal dot, use `"\\."` rather than `"."`.

---

## 🔹 15. Important String Algorithms

### 15.1 Reverse a String

```java
public class ReverseString {
    public static void main(String[] args) {
        String s = "Java";

        String reversed = new StringBuilder(s)
                .reverse()
                .toString();

        System.out.println(reversed); // avaJ
    }
}
```

### 15.2 Check Palindrome

A palindrome reads the same forward and backward.

Examples: `madam`, `level`, `121`.

```java
public class Palindrome {
    public static void main(String[] args) {
        String s = "madam";

        String reversed = new StringBuilder(s)
                .reverse()
                .toString();

        System.out.println(s.equals(reversed));
    }
}
```

Output:

```text
true
```

### 15.3 Count Vowels and Consonants

```java
public class CountCharacters {
    public static void main(String[] args) {
        String s = "Java Programming".toLowerCase();

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
```

This example counts English letters only and ignores spaces, digits, punctuation, and non-English letters.

### 15.4 Count Characters

```java
public class CharacterFrequency {
    public static void main(String[] args) {
        String s = "banana";

        int[] freq = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch < 256) {
                freq[ch]++;
            }
        }

        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                System.out.println(
                    (char) i + " : " + freq[i]
                );
            }
        }
    }
}
```

This version works for character values below 256. For general Unicode text, use a `HashMap` keyed by character or code point instead.

### 15.5 Remove Spaces

```java
public class RemoveSpaces {
    public static void main(String[] args) {
        String s = "Java is easy";

        String result = s.replace(" ", "");

        System.out.println(result); // Javaiseasy
    }
}
```

### 15.6 Check Anagrams

Two Strings are anagrams if their characters have the same frequencies, ignoring order.

```java
import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String a = "listen";
        String b = "silent";

        char[] x = a.toCharArray();
        char[] y = b.toCharArray();

        Arrays.sort(x);
        Arrays.sort(y);

        System.out.println(Arrays.equals(x, y));
    }
}
```

Output:

```text
true
```

This basic version is case-sensitive and treats spaces as significant.

### 15.7 Count Words

```java
public class WordCount {
    public static void main(String[] args) {
        String s = "Java is easy to learn";

        String trimmed = s.trim();

        int count = trimmed.isEmpty()
                ? 0
                : trimmed.split("\\s+").length;

        System.out.println(count); // 5
    }
}
```

### 15.8 Remove Duplicate Characters

```java
public class RemoveDuplicates {
    public static void main(String[] args) {
        String s = "programming";

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (result.indexOf(String.valueOf(ch)) == -1) {
                result.append(ch);
            }
        }

        System.out.println(result); // progamin
    }
}
```

This preserves the first occurrence of each character.

---

## 🔹 16. Time Complexity

Let `n` be the length of the String and `k` be the length of the inserted or appended text.

| Operation | Typical Time Complexity |
|---|---|
| `length()` | O(1) |
| `charAt(i)` | O(1) |
| `equals()` | O(n) worst case |
| `compareTo()` | O(n) worst case |
| `indexOf()` | O(n) typical for a single-character search |
| `substring()` | O(n) in the resulting substring length, depending on implementation |
| `toCharArray()` | O(n) |
| `StringBuilder.append()` | O(k) amortized |
| `StringBuilder.insert()` | O(n + k) in general |
| `StringBuilder.delete()` | O(n) in general |
| `StringBuilder.reverse()` | O(n) |
| Sorting a character array | O(n log n) for typical comparison-based sorting |

**Important:** Actual performance depends on the JDK implementation, input, and operation. Amortized complexity accounts for occasional internal capacity growth.

### Why Is StringBuilder Preferred in Loops?

Repeated immutable concatenation can repeatedly copy previously accumulated text.

Using a builder typically makes constructing a final String from many pieces more efficient.

---

## 🔹 17. Common Mistakes

### Mistake 1: Using `==` to Compare Contents

Incorrect:

```java
if (a == b) {
    System.out.println("Equal");
}
```

Correct:

```java
if (a.equals(b)) {
    System.out.println("Equal");
}
```

### Mistake 2: Forgetting Immutability

Incorrect:

```java
String s = "hello";
s.toUpperCase();

System.out.println(s); // hello
```

Correct:

```java
s = s.toUpperCase();
```

### Mistake 3: Incorrect Substring Ending Index

```java
String s = "Programming";

System.out.println(s.substring(0, 4)); // Prog
```

The ending index is excluded.

### Mistake 4: Accessing an Invalid Index

```java
String s = "Java";

// s.charAt(4); // Throws an exception
```

Valid indexes are `0` to `3`.

### Mistake 5: Using `+` Repeatedly in Large Loops

Prefer a `StringBuilder` when repeatedly constructing text.

### Mistake 6: Confusing Length and Capacity

```java
StringBuilder sb = new StringBuilder(100);

System.out.println(sb.length());   // 0
System.out.println(sb.capacity()); // 100
```

### Mistake 7: Forgetting That `split()` Uses Regex

```java
String s = "one.two.three";

String[] parts = s.split("\\.");
```

The escaped dot matches a literal period.

### Mistake 8: Confusing Character and Byte Length

`String.length()` returns the number of UTF-16 code units, not the number of encoded bytes or necessarily the number of visible Unicode characters.

---

## 🔹 18. Java String Interview Questions

### Basic Questions

**1. What is a String in Java?**

A String is an object representing a sequence of characters. Java's `String` class is immutable.

**2. Why are Strings immutable?**

Immutability supports safe sharing, String pool reuse, predictable behavior, and caching of hash codes.

**3. What is the String Constant Pool?**

It is a JVM-managed pool of canonical String instances that allows eligible Strings to be reused.

**4. What is the difference between `==` and `equals()`?**

`==` compares references for objects; `equals()` compares contents for Strings.

**5. Can we modify a String after creating it?**

No. String operations that appear to modify text return a new String instead.

### Intermediate Questions

**6. What is the difference between `StringBuilder` and `StringBuffer`?**

Both are mutable. `StringBuffer` synchronizes its methods, while `StringBuilder` does not.

**7. Why is StringBuilder preferred in loops?**

It allows repeated modifications without requiring a new immutable String for every append.

**8. What does `intern()` do?**

It returns the canonical pooled String for the same contents.

**9. What is the difference between `substring()` and `subSequence()`?**

`substring()` returns a String. `subSequence()` returns a `CharSequence`.

**10. What is the difference between `isEmpty()` and `isBlank()`?**

`isEmpty()` checks whether length is zero. `isBlank()` also treats whitespace-only Strings as blank.

### Advanced Questions

**11. Is StringBuilder thread-safe?**

Not by itself. Its mutable contents require external synchronization or another coordination strategy when shared across threads.

**12. Does StringBuilder always outperform String concatenation?**

No. It is generally useful for repeated modifications, but modern Java compilers optimize many concatenation expressions.

**13. What is the difference between String length and code-point count?**

`length()` counts UTF-16 code units. `codePointCount()` counts Unicode code points in the specified range.

**14. Why can Strings be used as HashMap keys?**

Their immutable contents provide stable equality and hash-code behavior while used as keys.

**15. What happens when `charAt()` receives an invalid index?**

It throws `StringIndexOutOfBoundsException`.

**16. What happens when `Integer.parseInt()` receives invalid numeric text?**

It throws `NumberFormatException`.

---

## 🔹 19. Practice Problems

Practise these problems in order, starting with basic loops and moving towards data structures and algorithms.

### Beginner Level

- [ ] Find the length of a String without using `length()`.
- [ ] Reverse a String.
- [ ] Check whether a String is a palindrome.
- [ ] Count vowels and consonants.
- [ ] Convert lowercase letters to uppercase.
- [ ] Count the number of words.
- [ ] Remove spaces from a String.
- [ ] Count occurrences of a character.

### Intermediate Level

- [ ] Check whether two Strings are anagrams.
- [ ] Remove duplicate characters.
- [ ] Find the first non-repeating character.
- [ ] Find the first repeating character.
- [ ] Find the most frequent character.
- [ ] Reverse each word in a sentence.
- [ ] Check whether one String is a rotation of another.
- [ ] Find the longest common prefix.
- [ ] Compress repeated characters.
- [ ] Find all duplicate characters.

### Advanced Level

- [ ] Longest substring without repeating characters.
- [ ] Longest palindromic substring.
- [ ] Group anagrams.
- [ ] Minimum window substring.
- [ ] String pattern matching using KMP.
- [ ] Rabin–Karp pattern searching.
- [ ] Edit distance between two Strings.
- [ ] Longest common subsequence.
- [ ] Decode an encoded String.
- [ ] Implement a basic string-to-integer parser.

**Practice Tip:** For every problem, try a brute-force solution first. Then improve the time and space complexity and explain your approach.

---

## 🔹 20. Quick Revision

| Concept | Remember |
|---|---|
| String | Immutable |
| StringBuilder | Mutable, not synchronized |
| StringBuffer | Mutable, synchronized methods |
| `==` | Compares object references |
| `equals()` | Compares String contents |
| `intern()` | Returns canonical pooled String |
| `length()` | Returns UTF-16 code unit count |
| `charAt(i)` | Returns a character unit at index `i` |
| `substring(a, b)` | Includes `a`, excludes `b` |
| `append()` | Adds content to a builder or buffer |
| `reverse()` | Reverses a builder or buffer |
| `capacity()` | Reports internal capacity |
| `toString()` | Converts a builder or buffer to a String |
| `isEmpty()` | Checks zero length |
| `isBlank()` | Checks empty or whitespace-only text |
| `split()` | Splits using a regular expression |

---

## 🎯 Final Takeaways

- **Understand immutability** before learning advanced String problems.
- **Know the String pool** and the difference between references and contents.
- **Master String methods** such as `substring()`, `indexOf()`, `equals()`, and `split()`.
- **Use StringBuilder** for repeated text construction and modification.
- **Understand StringBuffer** and its synchronization behavior.
- **Practise DSA problems** to strengthen problem-solving and interview performance.
- **Always analyse time and space complexity** before optimizing a solution.

---

## 👩‍💻 Author

**Dudekula Hazra Bee**

- GitHub: [@hazracodegit](https://github.com/hazracodegit)
- Portfolio: [Personal Portfolio](https://hazracodegit.github.io/Personal-Portfolio-Website)
- LinkedIn: [Hazra Bee](https://www.linkedin.com/in/hazra-bee-dudekula/)

⭐ **If these notes help you learn Java Strings, consider starring the repository!**

*Keep learning, keep coding, and keep improving.* 🚀
