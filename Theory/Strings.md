Java Strings — Complete Guide

Complete notes on Java String, String methods, String Constant Pool, immutability, StringBuilder, StringBuffer, memory management, coding examples, and interview questions.

Table of Contents
1. Introduction to String
2. Creating Strings
3. String Immutability
4. String Constant Pool
5. String Comparison
6. Important String Methods
7. Searching Methods
8. Extracting and Modifying Strings
9. String Conversion
10. StringBuilder
11. StringBuffer
12. String vs StringBuilder vs StringBuffer
13. Memory and Performance
14. Unicode and Characters
15. Common String Programs
16. Interview Questions
17. Common Mistakes
18. Quick Revision
1. Introduction to String

A String is a sequence of characters used to represent text.

In Java, String is a class available in the java.lang package.

String name = "Java";
String message = "Hello World";
String empty = "";

Important properties
String is a class, not a primitive data type.
String objects are immutable.
Strings can be created using literals or constructors.
String literals can share objects through the String Constant Pool.
String provides methods for searching, comparing, extracting, and transforming text.
String uses UTF-16 internally as its conceptual character representation.
Example
public class Main {
    public static void main(String[] args) {
        String language = "Java";

        System.out.println(language);
        System.out.println(language.length());
    }
}


Output:

Java
4

2. Creating Strings
2.1 Using a String literal
String s1 = "Java";
String s2 = "Java";

System.out.println(s1 == s2); // true


Identical String literals are interned and can refer to the same pooled object.

2.2 Using the new keyword
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);      // false
System.out.println(s1.equals(s2)); // true


Each explicit constructor call creates a distinct String object.

2.3 From a character array
char[] chars = {'J', 'a', 'v', 'a'};
String s = new String(chars);

System.out.println(s); // Java

2.4 From a byte array
import java.nio.charset.StandardCharsets;

byte[] data = {65, 66, 67};

String s = new String(data, StandardCharsets.UTF_8);

System.out.println(s); // ABC


Specify a charset when converting bytes to text.

2.5 Empty String
String s1 = "";
String s2 = new String();

System.out.println(s1.isEmpty()); // true
System.out.println(s2.length());  // 0

3. String Immutability

Immutability means that an object's contents cannot be changed after creation.

Java String objects are immutable.

String s = "Hello";

s.concat(" World");

System.out.println(s); // Hello


The concat() method returns a new String. It does not modify the original String.

Correct usage:

String s = "Hello";

s = s.concat(" World");

System.out.println(s); // Hello World

Another example
String s = "java";

s.toUpperCase();

System.out.println(s); // java

s = s.toUpperCase();

System.out.println(s); // JAVA

Why is String immutable?
Security: Text used in paths, class names, and configuration values cannot be modified through an existing String reference.
String Pool: Immutable objects can safely be shared.
Thread safety: String contents cannot be modified after construction.
Hashing: Hash codes can be cached because contents do not change.
Predictability: Methods can receive Strings without changing the original text.
Important interview point

The variable can be reassigned, but the String object itself cannot be modified.

String s = "Hello";
s = "World";


The variable now refers to "World". The original String was not modified.

4. String Constant Pool

The String Constant Pool is a pool of canonical String instances maintained by the JVM.

Example 1: String literals
String a = "Java";
String b = "Java";

System.out.println(a == b); // true


Both references can point to the same pooled object.

Example 2: Using new
String a = "Java";
String b = new String("Java");

System.out.println(a == b);      // false
System.out.println(a.equals(b)); // true


The literal refers to the pooled String, while the constructor creates a distinct object.

Example 3: The intern() method

The intern() method returns the canonical pooled String with matching contents.

String a = new String("Java");
String b = a.intern();
String c = "Java";

System.out.println(b == c); // true

Conceptual diagram
String Constant Pool
        |
        v
    "Java" object
       ^   ^
       |   |
       a   c


For new String("Java"), the new String object is separate from the pooled String.

5. String Comparison
5.1 ==

Checks whether two references point to the same object.

String a = "Java";
String b = new String("Java");

System.out.println(a == b); // false

5.2 equals()

Compares String contents.

String a = "Java";
String b = new String("Java");

System.out.println(a.equals(b)); // true

5.3 equalsIgnoreCase()

Compares text without considering case differences.

System.out.println("JAVA".equalsIgnoreCase("java")); // true

5.4 compareTo()

Compares Strings lexicographically.

System.out.println("Apple".compareTo("Banana") < 0); // true
System.out.println("Java".compareTo("Java"));        // 0
System.out.println("Zoo".compareTo("Apple") > 0);    // true


Return value:

Negative: the first String comes before the second.
Zero: both Strings compare equally.
Positive: the first String comes after the second.

The result is not necessarily -1, 0, or 1.

5.5 compareToIgnoreCase()
System.out.println("java".compareToIgnoreCase("JAVA")); // 0

5.6 Null-safe comparison
import java.util.Objects;

String a = null;
String b = "Java";

System.out.println(Objects.equals(a, b)); // false

6. Important String Methods

Assume:

String s = "Hello Java";

Method	Description
length()	Returns the number of UTF-16 code units
isEmpty()	Checks whether the String has length zero
isBlank()	Checks whether it is empty or whitespace-only (Java 11+)
charAt(index)	Returns a UTF-16 code unit at an index
equals(str)	Compares contents
equalsIgnoreCase(str)	Compares without case sensitivity
toUpperCase()	Converts to uppercase
toLowerCase()	Converts to lowercase
trim()	Removes leading and trailing characters at or below U+0020
strip()	Removes leading and trailing Unicode whitespace (Java 11+)
concat(str)	Concatenates Strings
contains(seq)	Checks whether a sequence exists
startsWith(prefix)	Checks the prefix
endsWith(suffix)	Checks the suffix
indexOf(x)	Finds the first matching index
lastIndexOf(x)	Finds the last matching index
substring(start)	Extracts from an index to the end
substring(start, end)	Extracts a range; end is exclusive
replace(old, new)	Replaces literal characters or sequences
replaceAll(regex, replacement)	Replaces regex matches
replaceFirst(regex, replacement)	Replaces the first regex match
split(regex)	Splits using a regular expression
toCharArray()	Converts to a character array
toString()	Returns the String itself
repeat(n)	Repeats text (Java 11+)
matches(regex)	Checks whether the entire String matches a regex
intern()	Returns the canonical pooled String
6.1 length()
String s = "Programming";

System.out.println(s.length()); // 11

6.2 charAt()
String s = "Java";

System.out.println(s.charAt(0)); // J
System.out.println(s.charAt(2)); // v


Valid indices range from 0 to length() - 1.

6.3 isEmpty() and isBlank()
String a = "";
String b = "   ";

System.out.println(a.isEmpty()); // true
System.out.println(b.isEmpty()); // false
System.out.println(b.isBlank()); // true, Java 11+

6.4 trim() and strip()
String s = "   Java   ";

System.out.println(s.trim());  // Java
System.out.println(s.strip()); // Java


strip() is useful when Unicode whitespace handling is required.

6.5 concat()
String a = "Hello";
String b = "World";

String result = a.concat(" ").concat(b);

System.out.println(result); // Hello World

6.6 contains()
String s = "I love Java";

System.out.println(s.contains("Java"));   // true
System.out.println(s.contains("Python")); // false

6.7 startsWith() and endsWith()
String file = "notes.txt";

System.out.println(file.startsWith("notes")); // true
System.out.println(file.endsWith(".txt"));    // true

6.8 repeat()

Available since Java 11.

System.out.println("Java ".repeat(3));
// Java Java Java

7. Searching Methods
7.1 indexOf()

Returns the first matching index, or -1 if not found.

String s = "banana";

System.out.println(s.indexOf('a'));     // 1
System.out.println(s.indexOf("ana"));   // 1
System.out.println(s.indexOf('z'));     // -1
System.out.println(s.indexOf('a', 2));  // 3

7.2 lastIndexOf()

Returns the last matching index.

String s = "banana";

System.out.println(s.lastIndexOf('a'));   // 5
System.out.println(s.lastIndexOf("ana")); // 3

7.3 matches()

Checks whether the entire String matches a regular expression.

System.out.println("12345".matches("\\d+"));  // true
System.out.println("123abc".matches("\\d+")); // false

7.4 regionMatches()

Compares selected regions of two Strings.

String a = "HelloJava";
String b = "Java";

System.out.println(a.regionMatches(5, b, 0, 4)); // true

8. Extracting and Modifying Strings

Strings are immutable, so these methods return results instead of changing the original String.

8.1 substring()
String s = "Programming";

System.out.println(s.substring(3));    // gramming
System.out.println(s.substring(0, 7)); // Program


Remember:

Start index is inclusive.
End index is exclusive.
Invalid ranges throw IndexOutOfBoundsException.
8.2 replace()
String s = "banana";

System.out.println(s.replace('a', 'o')); // bonono
System.out.println(s.replace("na", "NA")); // baNANA

8.3 replaceAll()
String s = "Java123Programming456";

System.out.println(s.replaceAll("\\d", ""));
// JavaProgramming


replaceAll() uses regular expressions.

8.4 replaceFirst()
String s = "one two one";

System.out.println(s.replaceFirst("one", "three"));
// three two one

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


The argument is a regular expression.

To split on a literal dot:

String[] parts = "a.b.c".split("\\.");


To preserve trailing empty elements:

String[] parts = "a,b,,".split(",", -1);

8.6 Remove spaces
String s = "J a v a";

System.out.println(s.replace(" ", "")); // Java

9. String Conversion
9.1 String.valueOf()

Converts values into Strings.

int age = 21;
double price = 99.5;
boolean active = true;

String a = String.valueOf(age);
String b = String.valueOf(price);
String c = String.valueOf(active);

System.out.println(a); // 21
System.out.println(b); // 99.5
System.out.println(c); // true

9.2 Integer.parseInt()

Converts numeric text into an integer.

String s = "123";

int n = Integer.parseInt(s);

System.out.println(n + 10); // 133


Invalid numeric text throws NumberFormatException.

9.3 String to character array
String s = "Java";
char[] arr = s.toCharArray();

9.4 Character array to String
char[] arr = {'C', 'o', 'd', 'e'};

String s = new String(arr);

System.out.println(s); // Code

9.5 String.join()
String result = String.join("-", "2026", "10", "10");

System.out.println(result); // 2026-10-10

9.6 String.format()
String name = "Ravi";
int age = 21;

String result = String.format("Name: %s, Age: %d", name, age);

System.out.println(result);
// Name: Ravi, Age: 21


Common format specifiers:

Specifier	Meaning
%s	String representation
%d	Decimal integer
%f	Floating-point number
%.2f	Two decimal places
%c	Character
%b	Boolean
%n	Platform-specific newline
10. StringBuilder
10.1 What is StringBuilder?

StringBuilder is a mutable sequence of characters.

Unlike String, it allows modifications without creating a new builder for every operation.

StringBuilder sb = new StringBuilder("Java");

sb.append(" Programming");

System.out.println(sb); // Java Programming

Why use StringBuilder?

Repeated String concatenation can create many intermediate objects.

Less efficient for large repeated appends:

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

10.2 Creating StringBuilder
StringBuilder sb1 = new StringBuilder();
StringBuilder sb2 = new StringBuilder("Java");
StringBuilder sb3 = new StringBuilder(100);


The integer argument specifies initial capacity, not length. The default capacity of the no-argument constructor is commonly 16.

10.3 Important StringBuilder methods
Method	Description
append(x)	Adds text at the end
insert(index, x)	Inserts text at an index
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
10.4 append()
StringBuilder sb = new StringBuilder("Hello");

sb.append(" ");
sb.append("World");
sb.append(123);

System.out.println(sb); // Hello World123

10.5 insert()
StringBuilder sb = new StringBuilder("Java");

sb.insert(0, "Learn ");

System.out.println(sb); // Learn Java

10.6 replace()

The end index is exclusive.

StringBuilder sb = new StringBuilder("Hello World");

sb.replace(6, 11, "Java");

System.out.println(sb); // Hello Java

10.7 delete()
StringBuilder sb = new StringBuilder("Hello World");

sb.delete(5, 11);

System.out.println(sb); // Hello

10.8 deleteCharAt()
StringBuilder sb = new StringBuilder("Hello");

sb.deleteCharAt(1);

System.out.println(sb); // Hllo

10.9 reverse()
StringBuilder sb = new StringBuilder("Java");

sb.reverse();

System.out.println(sb); // avaJ

10.10 setCharAt()
StringBuilder sb = new StringBuilder("Java");

sb.setCharAt(0, 'L');

System.out.println(sb); // Lava

10.11 capacity()
StringBuilder sb = new StringBuilder();

System.out.println(sb.length());   // 0
System.out.println(sb.capacity()); // Commonly 16


Length is the number of characters stored. Capacity is the available storage before growth is needed.

10.12 ensureCapacity()
StringBuilder sb = new StringBuilder();

sb.ensureCapacity(100);

System.out.println(sb.capacity() >= 100); // true

10.13 setLength()
StringBuilder sb = new StringBuilder("Hello");

sb.setLength(3);

System.out.println(sb); // Hel


Increasing the length fills new positions with '\u0000'.

10.14 Convert StringBuilder to String
StringBuilder sb = new StringBuilder("Java");

String result = sb.toString();

System.out.println(result); // Java

Important points
StringBuilder is mutable.
StringBuilder is not synchronized.
It is generally preferred for repeated modifications in a single thread.
It inherits identity-based equals() behavior rather than comparing contents.
11. StringBuffer
11.1 What is StringBuffer?

StringBuffer is a mutable character sequence similar to StringBuilder.

Its methods are synchronized, allowing individual operations to be thread-safe.

StringBuffer sb = new StringBuffer("Hello");

sb.append(" World");

System.out.println(sb); // Hello World

11.2 Creating StringBuffer
StringBuffer sb1 = new StringBuffer();
StringBuffer sb2 = new StringBuffer("Java");
StringBuffer sb3 = new StringBuffer(100);

11.3 Important methods

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
11.4 Example
StringBuffer sb = new StringBuffer("Java");

sb.append(" Language");
sb.insert(0, "Learn ");
sb.replace(0, 5, "Study");

System.out.println(sb); // Study Java Language

11.5 Why use StringBuffer?

Use StringBuffer when a mutable character sequence is shared between threads and synchronized individual operations are appropriate.

However, synchronized methods do not automatically make an entire sequence of multiple operations atomic.

For ordinary single-threaded code, StringBuilder is usually preferred.

12. String vs StringBuilder vs StringBuffer
Feature	String	StringBuilder	StringBuffer
Mutability	Immutable	Mutable	Mutable
Modification	Returns new results	Modifies builder	Modifies buffer
Synchronized methods	Not needed for immutable contents	No	Yes
Repeated appends	Often less suitable in loops	Usually preferred	Synchronization adds overhead
equals()	Compares text	Identity-based	Identity-based
Typical use	Text values	Single-threaded text construction	Shared mutable text with synchronized operations
Equality example
String a = new String("Java");
String b = new String("Java");

System.out.println(a.equals(b)); // true

StringBuilder x = new StringBuilder("Java");
StringBuilder y = new StringBuilder("Java");

System.out.println(x.equals(y)); // false
System.out.println(x.toString().equals(y.toString())); // true

Which should you use?
Use String for ordinary text values.
Use StringBuilder for repeated text modifications in a single thread.
Use StringBuffer when synchronized mutable operations are specifically needed.
13. Memory and Performance
13.1 String concatenation
String a = "Hello";
String b = "World";

String result = a + " " + b;


Java compilers can optimize concatenation expressions. Not every + operation necessarily creates a separate intermediate String.

However, repeatedly concatenating Strings inside loops can cause avoidable allocations.

13.2 Performance example
StringBuilder sb = new StringBuilder();

for (int i = 0; i < 10000; i++) {
    sb.append(i);
}

String result = sb.toString();


This usually reduces repeated allocation compared with accumulating a String using += in every iteration.

13.3 Capacity growth

A commonly used growth formula in standard OpenJDK implementations is:

newCapacity = oldCapacity * 2 + 2


The implementation may allocate more when the required minimum capacity is larger. Treat this as an implementation detail rather than a universal JVM guarantee.

13.4 Compact Strings

Since Java 9, common OpenJDK implementations use Compact Strings, storing eligible text using a byte array and an encoding indicator.

Latin-1-compatible content can use one byte per code unit; other content may require UTF-16 storage.

This is an implementation optimization, not a requirement for every JVM implementation.

14. Unicode and Characters
14.1 What is char?

A Java char represents one UTF-16 code unit.

char ch = 'A';


A supplementary Unicode character can require two UTF-16 code units.

14.2 Unicode example
String emoji = "😀";

System.out.println(emoji.length()); // 2
System.out.println(
    emoji.codePointCount(0, emoji.length())
); // 1


The String length counts UTF-16 code units, while codePointCount() counts Unicode code points.

14.3 Iterate over Unicode code points
String s = "A😀B";

s.codePoints().forEach(cp ->
    System.out.println(Integer.toHexString(cp))
);


A code point is not always the same as a user-perceived character. Some visible characters consist of multiple code points.

15. Common String Programs
15.1 Reverse a String
static String reverse(String s) {
    return new StringBuilder(s).reverse().toString();
}


Example:

System.out.println(reverse("Java")); // avaJ

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

System.out.println(isPalindrome("madam")); // true
System.out.println(isPalindrome("hello")); // false


This version is case-sensitive and compares UTF-16 code units.

15.3 Count vowels
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

15.4 Character frequency
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

System.out.println(areAnagrams("listen", "silent")); // true


This implementation is case-sensitive and treats spaces as characters.

15.6 Remove duplicate characters
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
// progamin


This preserves first occurrence order and works with UTF-16 code units.

15.7 Count words
static int countWords(String s) {
    String trimmed = s.trim();

    if (trimmed.isEmpty()) {
        return 0;
    }

    return trimmed.split("\\s+").length;
}


Example:

System.out.println(countWords("Java is very useful")); // 4

16. Interview Questions
Beginner
What is a String in Java?
Why is String immutable?
What is the difference between String and char[]?
What is the difference between == and equals()?
What is the String Constant Pool?
What does intern() do?
How does length() work?
What is the difference between isEmpty() and isBlank()?
What is the difference between trim() and strip()?
How do you convert a String to a character array?
Intermediate
What is the difference between substring() and subSequence()?
What is the difference between replace() and replaceAll()?
What is the difference between indexOf() and lastIndexOf()?
Why is StringBuilder useful for repeated concatenation?
What is the difference between StringBuilder and StringBuffer?
What is the difference between append() and insert()?
What is the difference between length() and capacity()?
Why does StringBuilder's equals() not compare contents?
How do you split a String using a delimiter?
How do you reverse a String?
Advanced
How does String immutability improve security?
What are the limitations of char for Unicode?
What is the difference between UTF-16 code units and Unicode code points?
What is String interning?
How does Java optimize String concatenation?
Do synchronized StringBuffer methods make compound operations atomic?
How do you compare Strings without considering case?
How do you compare Strings safely when they may be null?
What is the difference between a code point and a grapheme cluster?
When should you use String, StringBuilder, and StringBuffer?
Output-based questions
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


Output:

Hello


The returned String was not assigned.

Question 4
StringBuilder sb = new StringBuilder("Java");
sb.append(" DSA");

System.out.println(sb);


Output:

Java DSA

Question 5
StringBuilder a = new StringBuilder("Java");
StringBuilder b = new StringBuilder("Java");

System.out.println(a.equals(b));


Output:

false


StringBuilder inherits identity-based equality behavior from Object.

Question 6
String s = "Programming";

System.out.println(s.substring(0, 4));


Output:

Prog


The start index is inclusive and the end index is exclusive.

17. Common Mistakes
Mistake 1: Comparing text using ==

Incorrect:

if (a == b) {
    // Compare text
}


Correct:

if (a.equals(b)) {
    // Compare text
}


Use Objects.equals(a, b) when either reference may be null.

Mistake 2: Assuming String methods modify the original String

Incorrect:

String s = "java";
s.toUpperCase();


Correct:

s = s.toUpperCase();

Mistake 3: Confusing length() and length
String s = "Java";
char[] arr = {'J', 'a', 'v', 'a'};

System.out.println(s.length()); // String method
System.out.println(arr.length); // Array field

Mistake 4: Incorrect dot splitting

Incorrect:

String[] parts = "a.b.c".split(".");


Correct:

String[] parts = "a.b.c".split("\\.");


The dot is a regular-expression metacharacter.

Mistake 5: Confusing capacity and length
StringBuilder sb = new StringBuilder(100);

System.out.println(sb.length());   // 0
System.out.println(sb.capacity()); // At least 100

Mistake 6: Assuming StringBuffer makes every sequence atomic

Individual synchronized method calls do not automatically make a sequence of multiple calls atomic.

Mistake 7: Forgetting exclusive end indices
String s = "Programming";

System.out.println(s.substring(0, 4)); // Prog

Mistake 8: Treating every Unicode character as one char

Some characters require two UTF-16 code units, and some visible characters consist of multiple code points.

18. Quick Revision
Concept	Remember
String	Immutable text
String literal	Can use the String Constant Pool
new String()	Creates a distinct object
==	Reference identity
equals()	String content comparison
intern()	Returns the canonical pooled String
length()	Number of UTF-16 code units
substring(a, b)	Start inclusive, end exclusive
replace()	Literal replacement
replaceAll()	Regex replacement
split()	Regex-based splitting
StringBuilder	Mutable and unsynchronized
StringBuffer	Mutable with synchronized methods
append()	Adds text at the end
insert()	Inserts text at an index
delete()	Removes a range
reverse()	Reverses the sequence
capacity()	Available character storage
toString()	Returns a String representation
Unicode code point	A Unicode character value
Grapheme cluster	A user-perceived character unit
Recommended learning order
String creation and immutability.
String Constant Pool and == vs equals().
All important String methods.
Searching, substring, replacement, and splitting.
StringBuilder and its methods.
StringBuffer and synchronization.
Memory, performance, and Unicode.
String coding problems and interview questions.
Final Notes
Use String for ordinary text.
Use StringBuilder for repeated modifications in a single thread.
Use StringBuffer when synchronized mutable operations are required.
Use .equals() for String content comparison.
Specify a charset when converting bytes to text.
Use Java 11 or later for isBlank(), strip(), and repeat().

Mastering these concepts will help with Java interviews, DSA problems, and real-world Java development.
