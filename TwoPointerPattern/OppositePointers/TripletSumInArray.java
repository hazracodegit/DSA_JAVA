Triplet Sum in Array

Given an array arr[] and an integer target, determine if there exists a triplet in the array 
  whose sum equals the given target.

Return true if such a triplet exists, otherwise, return false.

Examples: 

Input: arr[] = [1, 4, 45, 6, 10, 8], target = 13
Output: true 
Explanation: The triplet {1, 4, 8} sums up to 13.
Input: arr[] = [1, 2, 4, 3, 6, 7], target = 10
Output: true 
Explanation: The triplets {1, 3, 6} and {1, 2, 7} both sum to 10. 
Input: arr[] = [40, 20, 10, 3, 6, 7], target = 24
Output: false 
Explanation: No triplet in the array sums to 24.
  Constraints:
3 ≤ arr.size() ≤ 5*103
0 ≤ arr[i], target ≤ 105
--------------------------------------------------------------------------------------------------
  Bruteforce Approach :
           class Solution {
    public boolean hasTripletSum(int arr[], int target) {
        // code Here
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    int sum=arr[i]+arr[j]+arr[k];
                    if (sum==target)
                    return true;
                }
            }
        }
        return false;
    }
}
Time Complexity : O(n*n*n)
Space Complexity : O(1)
  ----------------------------------------------------------------------------------------------------
  Optimised Approach : Two-Pointer Technique
               import java.util.*;
class Solution {
    public boolean hasTripletSum(int arr[], int target) {
        // code Here
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            int start=i+1;
            int end=arr.length-1;
            while(start<end){
                int sum=arr[i]+arr[start]+arr[end];
                if (sum==target)
                return true;
                else if (sum>target)
                end--;
                else 
                start++;
            }
        }
        return false;
    }
}
Time Complexity : O(n*n)
Space Complexity : O(1)
