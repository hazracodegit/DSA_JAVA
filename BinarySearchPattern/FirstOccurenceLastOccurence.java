### First  Occurence 
Fast  Occurence : The problem Statement states that we are given an array sorted in either ascending
   or descending Order(can contain duplicates), and a target element will be given. Now we have to find the first Occurence (Index)
    of that target element.
Example : { 10, 20, 20, 20, 50, 60}  target=20
  Output: 2
Bruteforce Approach: Apply linear search
    * Start iterating the array from the first element
    * If the current element is equal to the target element
    * Then print the index number and break out of the loop.
    Time Complexity : O(n) // slower for large sized arrays so try to optimize
    Space Complexity : O(1)
--------------------------------------------------------------------------------------------------------------------------------------
  Optimized Approach : Apply Binary Search
      *  Initialize the pointers start and end
      *  Calculate mid, mid = (low + high)/2
      *  if the mid element is equal to the target
            ---> then store the index in a variable
            ---> now, we need first occurence, which will be available in the first half of the array
                 so, high = mid-1
            ---> calculate the mid and repeat the above steps untill you find the first occurence
      Time Complexity : O(logn)
      Space Complexity : O(1)
        Iterative Approach :
                int firstOccurrence(int[] arr, int target) {
                int low = 0, high = arr.length - 1;
                int firstOccurence = -1;

                while (low <= high) {
                   int mid = low + (high - low) / 2;
                    if (arr[mid] == target) {
                          firstOccurence = mid;        // store index
                          high = mid - 1;   // search in left half 
                        } else if (arr[mid] < target) 
                        low = mid + 1;
                        else 
                        high = mid - 1;  
                  }
                  return firstOccurence;
            }



=================================================================================================================================================================
 ### Last Occurence
  Last Occurence : The problem statement states that we are given an array which is sorted in either ascending or
     descending order (can contain duplicates) and a target element. You have to find the last Occurence (index)
     of the target element in the array.
  Bruteforce Approach : Apply Linear Search
     *  Start Iterating the array from the first element.
     *  If the current element is equal to the target element
            then store the index and again start comparing till the end of the array is reached.
     Time Complexity : O(n) // slower for large sized arrays
     Space Complexity : O(1)
-------------------------------------------------------------------------------------------------------------------------
  Optimized Approach : Apply Binary Search
     *  Initialize the pointers start and end
     *  Calculate the mid
     *  if the mid element is equal to the target element
             ---> then store the index and to find the last occurence, we should search for the element in the
                    right half so low = mid+1
             ---> Calculate the mid and again repeat the above steps
           Time Complexity : O(logn)
           Space Complexity : O(1)
        Iterative Approach :
                         int lastOccurrence(int[] arr, int target) {
                int low = 0, high = arr.length - 1;
                int lastOccurence = -1;

                while (low <= high) {
                   int mid = low + (high - low) / 2;
                    if (arr[mid] == target) {
                          lastOccurence = mid;        // store index
                          low = mid + 1;   // search in right half 
                        } else if (arr[mid] < target) 
                        low = mid + 1;
                        else 
                        high = mid - 1;  
                  }
                  return last Occurence;
            }

  
                    
