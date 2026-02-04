Count pairs with given sum

You are given an array arr[] and an integer target. You have to count all pairs in the array such that their 
  sum is equal to the given target.

Examples:

Input: arr[] = [1, 5, 7, -1, 5], target = 6 
Output: 3
Explanation: Pairs with sum 6 are (1, 5), (7, -1) and (1, 5). 
Input: arr[] = [1, 1, 1, 1], target = 2 
Output: 6
Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1, 1), (1, 1).
Input: arr[] = [10, 12, 10, 15, -1], target = 125
Output: 0
Explanation: There is no pair with sum = target
Constraints:
1 ≤ arr.size() ≤ 105
-104 ≤ arr[i] ≤ 104
  0 ≤ target ≤ 104

  -----------------------------------------------------------------------------------------------------
  Bruteforce Approach :
                class Solution {
    int countPairs(int arr[], int target) {
        // code here
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if (arr[i]+arr[j]==target)
                count++;
            }
        }
        return count;
    }
}
Time Complexity : O(n*n)
Space Complexity : O(1)
  ----------------------------------------------------------------------------------------------------
  Optimised Approach : Using HashMap
         import java.util.*;
class Solution {
    int countPairs(int arr[], int target) {
        // code here
       
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int diff = target - num;

        if (map.containsKey(diff)) {
            count += map.get(diff);
        }
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
    return count;        
    }
}

Time Complexity : O(n)
Space Complexity : O(n)
