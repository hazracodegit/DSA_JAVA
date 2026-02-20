### Move all Zeros to End of Array

Given an array of integers arr[], move all the zeros to the end of the array while maintaining the relative 
order of all non-zero elements.

Examples: 

Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
Output: [1, 2, 4, 3, 5, 0, 0, 0]
Explanation: There are three 0s that are moved to the end.

Input: arr[] = [10, 20, 30]
Output: [10, 20, 30]
Explanation: No change in array as there are no 0s. 

Input: arr[] = [0, 0]
Output: [0, 0]
Explanation: No change in array as there are all 0s.

  Bruteforce Approach: Using temporary array
  Optimised Approach: Fast and Slow Pointers
  Algorithm:
     * Initialize slow pointer to zero, slow=0
     * Iterate through the each element in the entire array, using fast pointer
     * if (arr[fast]!=0) then swap arr[slow] and arr[fast]
     * Increment slow
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int[] arr={1,0,2,0,3,0,4,0,5,0};
		int slow=0;
		for(int fast=0;fast<arr.length;fast++){
		    if (arr[fast]!=0){
		        int temp=arr[slow];
		        arr[slow]=arr[fast];
		        arr[fast]=temp;
		        slow++;
		    }
		}
		System.out.println(Arrays.toString(arr));
  }
}
