📘 Java Strings — Complete Guide
Complete Java Strings Notes: Theory, String Methods, String Constant Pool, Immutability, StringBuilder, StringBuffer, Memory Management, Examples, and Interview Questions.
📑 Table of Contents
Introduction to Strings
Creating Strings
String Immutability
String Constant Pool
String Comparison
Important String Methods
Searching Methods
Extracting and Modifying Strings
String Conversion
StringBuilder
StringBuffer
String vs StringBuilder vs StringBuffer
Memory Management and Performance
Unicode and Characters
Common String Programs
Interview Questions
Common Mistakes
Quick Revision
1. Introduction to Strings

A String is a sequence of characters used to represent text.

In Java, String is a predefined class available in the java.lang package.

Example
public class Main {
    public static void main(String[] args) {
        String name = "Java";
        String message = "Hello World";

        System.out.println(name);
        System.out.println(message);
        System.out.println(name.length());
    }
}


Output:

Java
Hello World
4

Important Properties of String
String is a class, not a primitive data type.
String is immutable, meaning its contents cannot be changed after creation.
Strings can be created using literals or constructors.
String literals can share objects through the String Constant Pool.
String provides methods for searching, comparing, extracting, and modifying text by returning new Strings.
String supports Unicode text.
2. Creating Strings

Java provides multiple ways to create String objects.

2.1 Using a String Literal
String s1 = "Java";
String s2 = "Java";

System.out.println(s1 == s2);


Output:

true


Explanation: Identical String literals are interned, so both variables can refer to the same pooled object.

2.2 Using the new Keyword
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);
System.out.println(s1.equals(s2));


Output:

false
true


Explanation:

== compares object references.
equals() compares String contents.
Each explicit new String(...) creates a distinct String object.
2.3 Creating a String from a Character Array
char[] chars = {'J', 'a', 'v', 'a'};

String s = new String(chars);

System.out.println(s);


Output: Java

2.4 Creating a String from a Byte Array
import java.nio.charset.StandardCharsets;

byte[] data = {65, 66, 67};

String s = new String(data, StandardCharsets.UTF_8);

System.out.println(s);


Output: ABC

Best Practice: Always specify a charset when converting bytes into text.

2.5 Creating an Empty String
String s1 = "";
String s2 = new String();

System.out.println(s1.isEmpty());
System.out.println(s2.length());


Output:

true
0

3. String Immutability

Immutability means that an object's contents cannot be changed after it has been created.

In Java, String objects are immutable.

Example
String s = "Hello";

s.concat(" World");

System.out.println(s);


Output:

Hello


Why? The concat() method returns a new String instead of modifying the original String.

Correct Approach
String s = "Hello";

s = s.concat(" World");

System.out.println(s);


Output: Hello World

Another Example
String s = "java";

s.toUpperCase();

System.out.println(s);

s = s.toUpperCase();

System.out.println(s);


Output:

java
JAVA

Why Is String Immutable?
Security: Strings used in file paths, class names, and configuration values cannot be modified through an existing String reference.
String Pool: Immutable objects can safely be shared.
Thread Safety: String contents cannot be modified after construction.
Hashing: Hash codes can be cached because String contents never change.
Predictability: Methods can receive Strings without changing their original contents.
Interview Point: A String variable can be reassigned, but the String object itself cannot be modified.
4. String Constant Pool

The String Constant Pool is a pool of canonical String instances maintained by the JVM.

String literals with identical contents can share the same pooled object.

Example 1: String Literals
String a = "Java";
String b = "Java";

System.out.println(a == b);


Output: true

Example 2: String Literal vs Constructor
String a = "Java";
String b = new String("Java");

System.out.println(a == b);
System.out.println(a.equals(b));


Output:

false
true

Example 3: The intern() Method

The intern() method returns the canonical pooled String for matching contents.

String a = new String("Java");
String b = a.intern();
String c = "Java";

System.out.println(b == c);


Output: true

Conceptual Diagram
            String Constant Pool
                     |
                     v
                "Java" Object
                  ^      ^
                  |      |
                  b      c

    a ---> Separate String Object


Remember:

String literals can use the String Constant Pool.
new String("Java") creates a distinct String object.
intern() returns the canonical pooled String.
5. String Comparison

Java provides several methods to compare Strings.

5.1 == Operator

Checks whether two references point to the same object.

String a = "Java";
String b = new String("Java");

System.out.println(a == b);


Output: false

5.2 equals() Method

Compares the contents of two Strings.

String a = "Java";
String b = new String("Java");

System.out.println(a.equals(b));


Output: true

5.3 equalsIgnoreCase()

Compares Strings without considering case differences.

System.out.println("JAVA".equalsIgnoreCase("java"));


Output: true

5.4 compareTo()

Compares Strings lexicographically.

System.out.println("Apple".compareTo("Banana") < 0);
System.out.println("Java".compareTo("Java"));
System.out.println("Zoo".compareTo("Apple") > 0);


Output:

true
0
true

Return Value	Meaning
Negative	First String comes before the second
Zero	Both Strings compare equally
Positive	First String comes after the second

Important: compareTo() does not necessarily return exactly -1, 0, or 1.

5.5 compareToIgnoreCase()
System.out.println("java".compareToIgnoreCase("JAVA"));


Output: 0

5.6 Null-Safe Comparison
import java.util.Objects;

String a = null;
String b = "Java";

System.out.println(Objects.equals(a, b));


Output: false

Best Practice: Use equals() for String content comparison and Objects.equals() when either reference might be null.

6. Important String Methods

Assume the following String:

String s = "Hello Java";

Method	Description	Example
length()	Returns UTF-16 code-unit count	s.length()
isEmpty()	Checks whether length is zero	"".isEmpty()
isBlank()	Checks whether empty or whitespace-only	" ".isBlank()
charAt(i)	Returns a code unit at an index	s.charAt(0)
equals(str)	Compares contents	s.equals("Hello Java")
equalsIgnoreCase(str)	Compares without case sensitivity	"JAVA".equalsIgnoreCase("java")
toUpperCase()	Converts to uppercase	s.toUpperCase()
toLowerCase()	Converts to lowercase	s.toLowerCase()
trim()	Removes certain leading/trailing characters	s.trim()
strip()	Removes Unicode whitespace at both ends	s.strip()
concat(str)	Concatenates Strings	s.concat("!")
contains(seq)	Checks for a sequence	s.contains("Java")
startsWith(prefix)	Checks the prefix	s.startsWith("Hello")
endsWith(suffix)	Checks the suffix	s.endsWith("Java")
indexOf(x)	Finds the first occurrence	s.indexOf("Java")
lastIndexOf(x)	Finds the last occurrence	s.lastIndexOf("a")
substring(a)	Extracts from an index	s.substring(6)
substring(a, b)	Extracts a range	s.substring(0, 5)
replace(old, new)	Replaces literal text	s.replace("Java", "Python")
replaceAll(regex, new)	Replaces regex matches	s.replaceAll("\\s+", "")
replaceFirst(regex, new)	Replaces the first regex match	s.replaceFirst("Java", "Python")
split(regex)	Splits using a regex	s.split(" ")
toCharArray()	Converts to a character array	s.toCharArray()
repeat(n)	Repeats text	"Hi".repeat(3)
matches(regex)	Tests the entire String against a regex	"123".matches("\\d+")
intern()	Returns the canonical pooled String	s.intern()

Version Note: isBlank(), strip(), and repeat() require Java 11 or later.

6.1 length()
String s = "Programming";

System.out.println(s.length());


Output: 11

6.2 charAt()
String s = "Java";

System.out.println(s.charAt(0));
System.out.println(s.charAt(2));


Output:

J
v

6.3 isEmpty() vs isBlank()
String a = "";
String b = "   ";

System.out.println(a.isEmpty());
System.out.println(b.isEmpty());
System.out.println(b.isBlank());


Output:

true
false
true

6.4 trim() vs strip()
String s = "   Java   ";

System.out.println(s.trim());
System.out.println(s.strip());


Output:

Java
Java


strip() is preferable when Unicode whitespace handling is required.

6.5 concat()
String a = "Hello";
String b = "World";

String result = a.concat(" ").concat(b);

System.out.println(result);


Output: Hello World

6.6 contains()
String s = "I love Java";

System.out.println(s.contains("Java"));
System.out.println(s.contains("Python"));


Output:

true
false

6.7 startsWith() and endsWith()
String file = "notes.txt";

System.out.println(file.startsWith("notes"));
System.out.println(file.endsWith(".txt"));


Output:

true
true

6.8 repeat()
System.out.println("Java ".repeat(3));


Output: Java Java Java

7. Searching Methods
7.1 indexOf()

Returns the first matching index or -1 if the value is not found.

String s = "banana";

System.out.println(s.indexOf('a'));
System.out.println(s.indexOf("ana"));
System.out.println(s.indexOf('z'));
System.out.println(s.indexOf('a', 2));


Output:

1
1
-1
3

7.2 lastIndexOf()

Returns the last matching index.

String s = "banana";

System.out.println(s.lastIndexOf('a'));
System.out.println(s.lastIndexOf("ana"));


Output:

5
3

7.3 matches()

Checks whether the entire String matches a regular expression.

System.out.println("12345".matches("\\d+"));
System.out.println("123abc".matches("\\d+"));


Output:

true
false

7.4 regionMatches()

Compares selected regions of two Strings.

String a = "HelloJava";
String b = "Java";

System.out.println(a.regionMatches(5, b, 0, 4));


Output: true

8. Extracting and Modifying Strings

Important: String methods return results. They do not modify the original String object.

8.1 substring()
String s = "Programming";

System.out.println(s.substring(3));
System.out.println(s.substring(0, 7));


Output:

gramming
Program


Remember:

Start index is inclusive.
End index is exclusive.
Invalid indices throw IndexOutOfBoundsException.
8.2 replace()
String s = "banana";

System.out.println(s.replace('a', 'o'));
System.out.println(s.replace("na", "NA"));


Output:

bonono
baNANA


replace() performs literal replacement.

8.3 replaceAll()
String s = "Java123Programming456";

System.out.println(s.replaceAll("\\d", ""));


Output: JavaProgramming

replaceAll() uses a regular expression.

8.4 replaceFirst()
String s = "one two one";

System.out.println(s.replaceFirst("one", "three"));


Output: three two one

8.5 split()
String s = "Java,Python,C++";

String[] languages = s.split(",");

for (String language : languages) {
    System.out.println(language);
}


Output:

Java
Python
C++


The delimiter is a regular expression.

To split on a literal dot:

String[] parts = "a.b.c".split("\\.");


To preserve trailing empty elements:

String[] parts = "a,b,,".split(",", -1);

8.6 Removing Spaces
String s = "J a v a";

System.out.println(s.replace(" ", ""));


Output: Java

9. String Conversion
9.1 String.valueOf()

Converts values into Strings.

int age = 21;
double price = 99.5;
boolean active = true;

System.out.println(String.valueOf(age));
System.out.println(String.valueOf(price));
System.out.println(String.valueOf(active));


Output:

21
99.5
true

9.2 Integer.parseInt()

Converts numeric text into an integer.

String s = "123";

int number = Integer.parseInt(s);

System.out.println(number + 10);


Output: 133

Invalid numeric text throws NumberFormatException.

9.3 String to Character Array
String s = "Java";

char[] arr = s.toCharArray();

for (char ch : arr) {
    System.out.println(ch);
}

9.4 Character Array to String
char[] arr = {'C', 'o', 'd', 'e'};

String s = new String(arr);

System.out.println(s);


Output: Code

9.5 String.join()
String result = String.join("-", "2026", "10", "10");

System.out.println(result);


Output: 2026-10-10

9.6 String.format()
String name = "Ravi";
int age = 21;

String result = String.format(
    "Name: %s, Age: %d",
    name,
    age
);

System.out.println(result);


Output: Name: Ravi, Age: 21

Format Specifier	Meaning
%s	String representation
%d	Decimal integer
%f	Floating-point number
%.2f	Two decimal places
%c	Character
%b	Boolean
%n	Platform-specific newline
10. StringBuilder
10.1 What Is StringBuilder?

StringBuilder is a mutable sequence of characters.

Unlike String, StringBuilder allows its contents to be modified without creating a new builder for every operation.

Example
StringBuilder sb = new StringBuilder("Java");

sb.append(" Programming");

System.out.println(sb);


Output: Java Programming

10.2 Why Use StringBuilder?

Repeated String concatenation can create many intermediate objects.

Less suitable for repeated appends:

String result = "";

for (int i = 0; i < 10000; i++) {
    result += i;
}


Usually preferable:

StringBuilder sb = new StringBuilder();

for (int i = 0; i < 10000; i++) {
    sb.append(i);
}

String result = sb.toString();

10.3 Creating StringBuilder Objects
StringBuilder sb1 = new StringBuilder();
StringBuilder sb2 = new StringBuilder("Java");
StringBuilder sb3 = new StringBuilder(100);

The no-argument constructor commonly starts with capacity 16.
The String constructor initializes the builder with the supplied text.
The integer constructor specifies the initial capacity, not the length.
10.4 Important StringBuilder Methods
Method	Description
append(x)	Adds text at the end
insert(index, x)	Inserts text
replace(start, end, str)	Replaces a range
delete(start, end)	Deletes a range
deleteCharAt(index)	Deletes one UTF-16 code unit
reverse()	Reverses the sequence
charAt(index)	Reads a code unit
setCharAt(index, ch)	Changes a code unit
length()	Returns current length
capacity()	Returns current capacity
ensureCapacity(n)	Ensures minimum capacity
setLength(n)	Changes the length
substring(start)	Returns a String
substring(start, end)	Returns a String range
indexOf(str)	Finds the first occurrence
lastIndexOf(str)	Finds the last occurrence
toString()	Converts to String
10.5 append()
StringBuilder sb = new StringBuilder("Hello");

sb.append(" ");
sb.append("World");
sb.append(123);

System.out.println(sb);


Output: Hello World123

10.6 insert()
StringBuilder sb = new StringBuilder("Java");

sb.insert(0, "Learn ");

System.out.println(sb);


Output: Learn Java

10.7 replace()

The end index is exclusive.

StringBuilder sb = new StringBuilder("Hello World");

sb.replace(6, 11, "Java");

System.out.println(sb);


Output: Hello Java

10.8 delete()
StringBuilder sb = new StringBuilder("Hello World");

sb.delete(5, 11);

System.out.println(sb);


Output: Hello

10.9 deleteCharAt()
StringBuilder sb = new StringBuilder("Hello");

sb.deleteCharAt(1);

System.out.println(sb);


Output: Hllo

10.10 reverse()
StringBuilder sb = new StringBuilder("Java");

sb.reverse();

System.out.println(sb);


Output: avaJ

10.11 setCharAt()
StringBuilder sb = new StringBuilder("Java");

sb.setCharAt(0, 'L');

System.out.println(sb);


Output: Lava

10.12 capacity()
StringBuilder sb = new StringBuilder();

System.out.println(sb.length());
System.out.println(sb.capacity());


Output:

0
16


The default capacity is commonly 16.

Length: Number of characters stored.
Capacity: Available storage before growth is required.
10.13 ensureCapacity()
StringBuilder sb = new StringBuilder();

sb.ensureCapacity(100);

System.out.println(sb.capacity() >= 100);


Output: true

10.14 setLength()
StringBuilder sb = new StringBuilder("Hello");

sb.setLength(3);

System.out.println(sb);


Output: Hel

Increasing the length fills new positions with the null character '\u0000'.

10.15 Convert StringBuilder to String
StringBuilder sb = new StringBuilder("Java");

String result = sb.toString();

System.out.println(result);


Output: Java

Important StringBuilder Points
Mutable: Contents can be modified.
Not synchronized: Not thread-safe for concurrent unsynchronized access.
Efficient: Generally preferred for repeated text construction in one thread.
Equality: Does not override equals() to compare character contents.
11. StringBuffer
11.1 What Is StringBuffer?

StringBuffer is a mutable sequence of characters, similar to StringBuilder.

Its methods are synchronized, making individual operations thread-safe.

Example
StringBuffer sb = new StringBuffer("Hello");

sb.append(" World");

System.out.println(sb);


Output: Hello World

11.2 Creating StringBuffer Objects
StringBuffer sb1 = new StringBuffer();
StringBuffer sb2 = new StringBuffer("Java");
StringBuffer sb3 = new StringBuffer(100);

11.3 Important StringBuffer Methods

StringBuffer provides methods similar to StringBuilder:

append()
insert()
replace()
delete()
deleteCharAt()
reverse()
charAt()
setCharAt()
length()
capacity()
ensureCapacity()
setLength()
toString()
Example
StringBuffer sb = new StringBuffer("Java");

sb.append(" Language");
sb.insert(0, "Learn ");
sb.replace(0, 5, "Study");

System.out.println(sb);


Output: Study Java Language

11.4 Why Use StringBuffer?

Use StringBuffer when:

A mutable character sequence is shared between threads.
Synchronized individual operations are useful.
An external synchronization strategy is not already sufficient.

Important: Synchronization of individual methods does not automatically make an entire sequence of multiple operations atomic.

For ordinary single-threaded text building, StringBuilder is usually preferred.

12. String vs StringBuilder vs StringBuffer
Feature	String	StringBuilder	StringBuffer
Mutability	Immutable	Mutable	Mutable
Modification	Returns results	Modifies builder	Modifies buffer
Synchronization	Not required for immutable contents	No	Synchronized methods
Repeated appends	Often less suitable in loops	Usually preferred	Synchronization adds overhead
equals()	Compares contents	Identity-based	Identity-based
Typical usage	Normal text	Single-threaded text construction	Shared mutable text with synchronized operations
Equality Example
String a = new String("Java");
String b = new String("Java");

System.out.println(a.equals(b));

StringBuilder x = new StringBuilder("Java");
StringBuilder y = new StringBuilder("Java");

System.out.println(x.equals(y));
System.out.println(x.toString().equals(y.toString()));


Output:

true
false
true

Which One Should You Use?
String: For ordinary text values.
StringBuilder: For repeated modifications in a single thread.
StringBuffer: When synchronized mutable operations are specifically needed.
13. Memory Management and Performance
13.1 String Concatenation
String a = "Hello";
String b = "World";

String result = a + " " + b;


Java compilers can optimize concatenation expressions. Therefore, not every + operation necessarily creates a separate intermediate String.

However, repeated concatenation in loops can still create avoidable allocations.

13.2 StringBuilder Performance
StringBuilder sb = new StringBuilder();

for (int i = 0; i < 10000; i++) {
    sb.append(i);
}

String result = sb.toString();


This usually reduces repeated allocations compared with accumulating a String using += on every iteration.

13.3 Capacity Growth

A commonly used growth rule in standard OpenJDK implementations is:

newCapacity = oldCapacity * 2 + 2


The implementation may allocate more if the required minimum capacity is larger.

Note: This is an implementation detail, not a universal guarantee for every JVM.

13.4 Compact Strings

Since Java 9, common OpenJDK implementations use Compact Strings internally.

Eligible text can use a byte array with an encoding indicator:

Latin-1-compatible text can use one byte per code unit.
Other text may require UTF-16 storage.

This is an implementation optimization, not a requirement for every Java implementation.

14. Unicode and Characters
14.1 What Is char?

A Java char represents a single UTF-16 code unit.

char ch = 'A';


A supplementary Unicode character can require two UTF-16 code units.

14.2 Unicode Example
String emoji = "😀";

System.out.println(emoji.length());

System.out.println(
    emoji.codePointCount(0, emoji.length())
);


Output:

2
1


length() counts UTF-16 code units, while codePointCount() counts Unicode code points.

14.3 Iterating over Code Points
String s = "A😀B";

s.codePoints().forEach(cp ->
    System.out.println(Integer.toHexString(cp))
);


A Unicode code point is not always the same as a user-perceived character. Some visible characters consist of multiple code points.

15. Common String Programs
15.1 Reverse a String
static String reverse(String s) {
    return new StringBuilder(s).reverse().toString();
}


Example:

System.out.println(reverse("Java"));


Output: avaJ

15.2 Check Palindrome

A palindrome reads the same forward and backward.

static boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        left++;
        right--;
    }

    return true;
}


Example:

System.out.println(isPalindrome("madam"));
System.out.println(isPalindrome("hello"));


Output:

true
false


This version is case-sensitive and compares UTF-16 code units.

15.3 Count Vowels
static int countVowels(String s) {
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
        char ch = Character.toLowerCase(s.charAt(i));

        if (ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u') {
            count++;
        }
    }

    return count;
}

15.4 Character Frequency
import java.util.HashMap;
import java.util.Map;

static Map<Character, Integer> frequency(String s) {
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    return map;
}


This counts UTF-16 code units.

15.5 Check Anagrams

Two Strings are anagrams if they contain the same characters with the same frequencies.

import java.util.Arrays;

static boolean areAnagrams(String a, String b) {
    if (a.length() != b.length()) {
        return false;
    }

    char[] x = a.toCharArray();
    char[] y = b.toCharArray();

    Arrays.sort(x);
    Arrays.sort(y);

    return Arrays.equals(x, y);
}


Example:

System.out.println(areAnagrams("listen", "silent"));


Output: true

This implementation is case-sensitive and treats spaces as characters.

15.6 Remove Duplicate Characters
static String removeDuplicates(String s) {
    StringBuilder result = new StringBuilder();
    boolean[] seen = new boolean[65536];

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        if (!seen[ch]) {
            seen[ch] = true;
            result.append(ch);
        }
    }

    return result.toString();
}


Example:

System.out.println(removeDuplicates("programming"));


Output: progamin

This preserves first-occurrence order and works with UTF-16 code units.

15.7 Count Words
static int countWords(String s) {
    String trimmed = s.trim();

    if (trimmed.isEmpty()) {
        return 0;
    }

    return trimmed.split("\\s+").length;
}


Example:

System.out.println(countWords("Java is very useful"));


Output: 4

16. Interview Questions
Beginner-Level Questions
What is a String in Java?
Why is String immutable?
What is the difference between String and char[]?
What is the difference between == and equals()?
What is the String Constant Pool?
What is the purpose of intern()?
How does length() work?
What is the difference between isEmpty() and isBlank()?
What is the difference between trim() and strip()?
How do you convert a String into a character array?
Intermediate-Level Questions
What is the difference between substring() and subSequence()?
What is the difference between replace() and replaceAll()?
What is the difference between indexOf() and lastIndexOf()?
Why is StringBuilder useful for repeated concatenation?
What is the difference between StringBuilder and StringBuffer?
What is the difference between append() and insert()?
What is the difference between length() and capacity()?
Why does StringBuilder's equals() not compare text?
How do you split a String using a delimiter?
How do you reverse a String?
Advanced-Level Questions
How does String immutability improve security?
What are the limitations of char for Unicode?
What is the difference between UTF-16 code units and Unicode code points?
What is String interning?
How does Java optimize String concatenation?
Do synchronized StringBuffer methods make compound operations atomic?
How do you compare Strings without considering case?
How do you safely compare Strings when they may be null?
What is the difference between a Unicode code point and a grapheme cluster?
When should you use String, StringBuilder, and StringBuffer?
Output-Based Questions
Question 1
String a = "Java";
String b = "Java";

System.out.println(a == b);
System.out.println(a.equals(b));


Output:

true
true

Question 2
String a = new String("Java");
String b = new String("Java");

System.out.println(a == b);
System.out.println(a.equals(b));


Output:

false
true

Question 3
String s = "Hello";

s.concat(" World");

System.out.println(s);


Output: Hello

Reason: The returned String was not assigned to the variable.

Question 4
StringBuilder sb = new StringBuilder("Java");

sb.append(" DSA");

System.out.println(sb);


Output: Java DSA

Reason: StringBuilder is mutable.

Question 5
StringBuilder a = new StringBuilder("Java");
StringBuilder b = new StringBuilder("Java");

System.out.println(a.equals(b));


Output: false

Reason: StringBuilder inherits identity-based equality behavior from Object.

Question 6
String s = "Programming";

System.out.println(s.substring(0, 4));


Output: Prog

Reason: The start index is inclusive and the end index is exclusive.

17. Common Mistakes
Mistake 1: Comparing String Contents Using ==

Incorrect:

if (a == b) {
    // Compare text
}


Correct:

if (a.equals(b)) {
    // Compare text
}


Use Objects.equals(a, b) when either reference may be null.

Mistake 2: Assuming String Methods Modify the Original String

Incorrect:

String s = "java";

s.toUpperCase();


Correct:

s = s.toUpperCase();

Mistake 3: Confusing length() and length
String s = "Java";
char[] arr = {'J', 'a', 'v', 'a'};

System.out.println(s.length());
System.out.println(arr.length);

String uses the length() method.
Arrays use the length field.
Mistake 4: Incorrect Dot Splitting

Incorrect:

String[] parts = "a.b.c".split(".");


Correct:

String[] parts = "a.b.c".split("\\.");


The dot is a regular-expression metacharacter.

Mistake 5: Confusing Capacity and Length
StringBuilder sb = new StringBuilder(100);

System.out.println(sb.length());
System.out.println(sb.capacity());


Output:

0
100

Mistake 6: Assuming StringBuffer Makes Every Sequence Atomic

Individual synchronized method calls do not automatically make multiple method calls atomic as a group.

Mistake 7: Forgetting That the End Index Is Exclusive
String s = "Programming";

System.out.println(s.substring(0, 4));


Output: Prog

Mistake 8: Treating Every Unicode Character as One char

Some Unicode characters require two UTF-16 code units, and some visible characters consist of multiple code points.

18. Quick Revision
Concept	Important Point
String	Immutable text
String literal	Can use the String Constant Pool
new String()	Creates a distinct object
==	Compares reference identity
equals()	Compares String contents
intern()	Returns the canonical pooled String
length()	Counts UTF-16 code units
substring(a, b)	Start inclusive, end exclusive
replace()	Literal replacement
replaceAll()	Regular-expression replacement
split()	Splits using a regular expression
StringBuilder	Mutable and unsynchronized
StringBuffer	Mutable with synchronized methods
append()	Adds text at the end
insert()	Inserts text at an index
delete()	Removes a range
reverse()	Reverses the sequence
capacity()	Available storage capacity
toString()	Returns a String representation
Unicode code point	A Unicode code point value
Grapheme cluster	A user-perceived character unit
🎯 Recommended Learning Order
String Creation and Immutability
String Constant Pool
== vs equals()
Important String Methods
Searching, Substring, Replacement, and Splitting
StringBuilder and Its Methods
StringBuffer and Synchronization
Memory Management and Performance
Unicode and Character Handling
String Coding Problems and Interview Questions
Conclusion

To master Java Strings, focus on these three concepts:

String: Immutable and ideal for ordinary text.
StringBuilder: Mutable and generally preferred for repeated modifications in a single thread.
StringBuffer: Mutable with synchronized methods for appropriate concurrent use cases.

Understanding these concepts will help you solve Java interview questions, DSA problems, and real-world programming tasks.

Happy Coding! ☕
