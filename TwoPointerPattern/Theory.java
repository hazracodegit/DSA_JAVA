### Two-Pointer Technique:
       The two-pointer technique is a problem-solving approach where we use two indices (pointers) 
       start and end to traverse a data structure (usually an array or string) instead of using nested loops.

👉 Main goal: reduce time complexity, often from O(n²) → O(n).
                                                  
Basic Idea (Intuition) :
      *  Think of two people standing at different positions in an array and moving intelligently based on conditions.
      *  One pointer usually starts at the beginning
      *  The other at the end
      *  You move one or both pointers depending on the problem
      *  The operation stops when both reach the same position or cross each other.

  Where should we use this Two-pointer Technique?
       *  When the input array/string is in sorted order.
                ----->   📌 Keywords:
                       “sorted array”, “non-decreasing order”, “lexicographically sorted”
                          📌 Typical problems:
                          Pair with given sum, Closest sum, Triplet sum (inside loop), Remove duplicates
                          👉 Thought:
                     “Since data is sorted, I can move pointers intelligently instead of checking all pairs.” 
        *  Comparing elements from both ends.
                 ----->   If problem talks about:
                          First & last, Leftmost & rightmost, Front & back
                             📌 Problems:
                           Palindrome check, Reverse array/string, Container with most water
                              👉 Thought:
                          “I can start from both ends and move inward.”
         *  Looking for pairs/subarrays.
         *  Removing and modifying elements of array in-place.
         *  Linked List cycle / middle element
         *  Mainly used in Arrays/Strings/Linkedlist
array = {10, 20, 30, 40, 50}
       ----> the array {10, 30, 50} is known as subsequence
       ----> the array {10, 20, 30} is known as subarray

  Types of Two-pointer Techniques:
         1️⃣ Opposite Direction Pointers (Most Common)
                    both pointers start at opposite ends
         2️⃣ Same Direction Pointers (Fast & Slow)
                    Both pointers move forward, but at different speeds
  
         
  
    
