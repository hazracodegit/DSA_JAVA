# Reverse Prefix of Word 🔄

A Java solution for the **"Reverse Prefix of Word"** problem.

---

## 📌 Problem Statement
Given a 0-indexed string `word` and a character `ch`, reverse the segment of `word` that starts at index `0` and ends at the index of the **first occurrence** of `ch` (inclusive). 
* If the character `ch` does not exist in `word`, do nothing and return the original string.

### Examples

| Input (`word`, `ch`) | Output | Explanation |
| :--- | :---: | :--- |
| `"abcdefd"`, `'d'` | `"dcbaefd"` | First occurrence of `'d'` is at index 3. Reverse from index 0 to 3. |
| `"xyxzxe"`, `'z'` | `"zxyxxe"` | First occurrence of `'z'` is at index 3. Reverse from index 0 to 3. |

---

## ⚙️ Algorithm (Step-by-Step)

1. Find the index of the first occurrence of character `ch` in the string using `word.indexOf(ch)`.
2. If `ch` is not found (index is `-1`), return the original string as-is.
3. If found:
   * Iterate backwards from the found index down to `0`, appending each character to a `StringBuilder` (this reverses the prefix).
   * Iterate forwards from index `index + 1` to the end of the string, appending the remaining characters.
4. Convert the `StringBuilder` to a string and return it.

---

## 💻 Java Source Code

```java
public class ReversePrefix {

    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);

        // If character is not found, return the original string
        if (index == -1) {
            return word;
        }

        StringBuilder sb = new StringBuilder();

        // Append characters from the target index down to 0 (reversed prefix)
        for (int i = index; i >= 0; i--) {
            sb.append(word.charAt(i));
        }

        // Append the remaining characters from index + 1 to the end
        for (int i = index + 1; i < word.length(); i++) {
            sb.append(word.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word, ch)); // Output: dcbaefd
    }
}
