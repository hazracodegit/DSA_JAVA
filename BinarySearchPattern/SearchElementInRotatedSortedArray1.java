### Search Element in Rotated Sorted Array-1 (without duplicates)
  What is mean by rotated sorted array?
       {10, 20, 30, 40, 50, 60} ---> This is the actual sorted array
       {40, 50, 60, 10, 20, 30} ---> This is the Rotated Sorted Array
Problem Statement : You are given a Rotated Sorted Array and a target element, you goal is to search the target 
   element in the rotated sorted array and return the index of the target element.
  Example : {40, 50, 60, 10, 20, 30}
      target = 10
        Output : 3
Bruteforce Approach : Apply Linear Search and return the index of the target element
     Time Complexity : O(n)
     Space Complexity : O(1)
  ----------------------------------------------------------------------------------------------------
Optimized Approach : Apply Binary Search - because in the question it is clearly stated that 'search' and the array is sorted.
  Why only Binary Search - because here we can eliminate the portions
     *  Initialize the pointers low and high
     *  Calculate the mid element
     *  Check for the sorted half
            ---> if arr[low]<=arr[mid] then the left half is sorted, then start searching here
            ---> if arr[mid]<=arr[high] then the right half is sorted, then start searching here
     Time Complexity : O(logn)
     Space Complexity : O(1)
              Iterative Binary Search Approach : 
