# 🗺️ HashMap Methods in Java

> A complete guide to the most commonly used **HashMap** methods in Java with syntax, examples, and time complexities.

---

# 📖 What is a HashMap?

A **HashMap** is a data structure that stores data in the form of **Key-Value pairs**.

- Every **key** is unique.
- Each key maps to exactly one value.
- Duplicate keys are **not allowed**.
- Duplicate values are allowed.
- Average time complexity for most operations is **O(1)**.

Example

```text
Key    Value

1  →   One
2  →   Two
3  →   Three
```

---

# 💻 Creating a HashMap

```java
import java.util.HashMap;

HashMap<Integer, String> map = new HashMap<>();
```

---

# 📋 Important HashMap Methods

| Method | Description | Average Time |
|---------|-------------|--------------|
| `put()` | Insert or update a key-value pair | O(1) |
| `get()` | Returns the value of a key | O(1) |
| `getOrDefault()` | Returns value or default | O(1) |
| `containsKey()` | Checks if a key exists | O(1) |
| `containsValue()` | Checks if a value exists | O(n) |
| `remove()` | Removes a key | O(1) |
| `replace()` | Replaces the value | O(1) |
| `size()` | Returns the number of entries | O(1) |
| `isEmpty()` | Checks whether the map is empty | O(1) |
| `clear()` | Removes all entries | O(n) |
| `keySet()` | Returns all keys | O(n) |
| `values()` | Returns all values | O(n) |
| `entrySet()` | Returns all key-value pairs | O(n) |

---

# 1️⃣ put()

Adds a key-value pair.

If the key already exists, its value is updated.

### Syntax

```java
map.put(key, value);
```

### Example

```java
HashMap<Integer,String> map = new HashMap<>();

map.put(1,"One");
map.put(2,"Two");
map.put(3,"Three");

System.out.println(map);
```

### Output

```text
{1=One, 2=Two, 3=Three}
```

---

# Updating a Value

```java
map.put(2,"Second");

System.out.println(map);
```

Output

```text
{1=One, 2=Second, 3=Three}
```

---

# 2️⃣ get()

Returns the value associated with the given key.

### Syntax

```java
map.get(key);
```

### Example

```java
System.out.println(map.get(2));
```

Output

```text
Second
```

If the key does not exist,

```java
System.out.println(map.get(10));
```

Output

```text
null
```

---

# 3️⃣ getOrDefault()

Returns the value if the key exists.

Otherwise, returns the default value.

### Syntax

```java
map.getOrDefault(key, defaultValue);
```

### Example

```java
System.out.println(map.getOrDefault(2,-1));

System.out.println(map.getOrDefault(5,-1));
```

Output

```text
Second
-1
```

---

# 4️⃣ containsKey()

Checks whether a key exists.

### Syntax

```java
map.containsKey(key);
```

### Example

```java
System.out.println(map.containsKey(2));

System.out.println(map.containsKey(10));
```

Output

```text
true
false
```

---

# 5️⃣ containsValue()

Checks whether a value exists.

### Syntax

```java
map.containsValue(value);
```

### Example

```java
System.out.println(map.containsValue("Second"));

System.out.println(map.containsValue("Five"));
```

Output

```text
true
false
```

---

# 6️⃣ remove()

Removes a key and its value.

### Syntax

```java
map.remove(key);
```

### Example

```java
map.remove(2);

System.out.println(map);
```

Output

```text
{1=One, 3=Three}
```

---

# 7️⃣ replace()

Replaces the value of an existing key.

### Syntax

```java
map.replace(key, value);
```

### Example

```java
map.replace(3,"Third");

System.out.println(map);
```

Output

```text
{1=One, 3=Third}
```

---

# 8️⃣ size()

Returns the total number of key-value pairs.

```java
System.out.println(map.size());
```

Output

```text
2
```

---

# 9️⃣ isEmpty()

Checks whether the map is empty.

```java
System.out.println(map.isEmpty());
```

Output

```text
false
```

---

# 🔟 clear()

Removes every entry.

```java
map.clear();

System.out.println(map);
```

Output

```text
{}
```

---

# 1️⃣1️⃣ keySet()

Returns all keys.

```java
HashMap<Integer,String> map = new HashMap<>();

map.put(1,"One");
map.put(2,"Two");
map.put(3,"Three");

System.out.println(map.keySet());
```

Output

```text
[1, 2, 3]
```

---

# 1️⃣2️⃣ values()

Returns all values.

```java
System.out.println(map.values());
```

Output

```text
[One, Two, Three]
```

---

# 1️⃣3️⃣ entrySet()

Returns all key-value pairs.

```java
System.out.println(map.entrySet());
```

Output

```text
[1=One, 2=Two, 3=Three]
```

---

# 🔁 Iterating Through a HashMap

## Using keySet()

```java
for(Integer key : map.keySet()) {
    System.out.println(key + " -> " + map.get(key));
}
```

---

## Using entrySet() (Recommended)

```java
for(Map.Entry<Integer,String> entry : map.entrySet()) {

    System.out.println(entry.getKey() + " -> " + entry.getValue());

}
```

---

# ⚡ Time Complexity

| Operation | Average Time |
|-----------|--------------|
| put() | O(1) |
| get() | O(1) |
| containsKey() | O(1) |
| remove() | O(1) |
| replace() | O(1) |
| getOrDefault() | O(1) |
| containsValue() | O(n) |
| keySet() | O(n) |
| values() | O(n) |
| entrySet() | O(n) |
| clear() | O(n) |

---

# 💡 Interview Tips

- ✅ Use `containsKey()` before `get()` when a missing key needs special handling.
- ✅ Use `getOrDefault()` for frequency counting.
- ✅ Prefer `entrySet()` when iterating over both keys and values.
- ✅ `HashMap` does **not** maintain insertion order.
- ✅ Keys must be unique, but values can be duplicated.

---

# ⭐ Key Takeaways

- A `HashMap` stores **key-value pairs**.
- Average lookup, insertion, and deletion take **O(1)** time.
- `put()` inserts or updates values.
- `get()` retrieves values.
- `containsKey()` checks if a key exists.
- `getOrDefault()` is useful when a key may not exist.
- `entrySet()` is the preferred way to iterate over all entries.
