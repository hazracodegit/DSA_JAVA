### Bubble Sort Algorithm
  Definition : Bubble Sort is a simple comparison-based Algorithms which repeatedly compares Adjacent elements and 
       swaps them if they are in wrong Order until the entire array becomes sorted.
  * Also known as Sinking Sort or Exchange Sort.
  * In each pass the largest element bubbles up to the end.
  ---------------------------------------------------------------------------------------------------------------------------
  Algorithm (Steps) - How it works :
      1.  Start from the first element
      2.  Compare the current element with the next elemment
      3.  If current element > next element , then swap
      4.  Repeat the same for all the remaining elements (one pass)
      5.  Repeat the steps 2, 3 and 4 for all the remaining passes until array becomes sorted total- (n-1)
  -------------------------------------------------------------------------------------------------------------------------------------------------
  Dry Run Example :
      Array : {5(a), 2, 9, 1, 5(b), 3}
          The size of the array is n=6 so the total number of passes are n-1 i.e., 5 passes
      Pass 1 : Compare 5 and 2, 5>2 true, swap 5 and 2 ----> {2, 5, 9, 1, 5, 3}
               Compare 5 and 9, 5>9 false, No swap     ----> {2, 5, 9, 1, 5, 3}
               Compare 9 and 1, 9>1 true, swap 9 and 1 ----> {2, 5, 1, 9, 5, 3}            n-1 comparisons
               Compare 9 and 5, 9>5 true, swap 9 and 5 ----> {2, 5, 1, 5, 9, 3}
               Compare 9 and 3, 9>3 true, swap 9 and 3 ----> {2, 5, 1, 5, 3, 9}
            9 is the largest element bubbled up to the end in the first pass
            9 is sorted
      Pass 2 : Compare 2 and 5, 2>5 false, No swap     ----> {2, 5, 1, 5, 3, 9}
               Compare 5 and 1, 5>1 true, swap 5 and 1 ----> {2, 1, 5, 5, 3, 9}
               Compare 5 and 5, 5>5 false, No swap     ----> {2, 1, 5, 5, 3, 9}  stable   n-2 comparisons
               Compare 5 and 3, 5>3 true, swap 5 and 3 ----> {2, 1, 5, 3, 5, 9}
            5 and 9 is sorted
            5 is the second largest element bubble up to the end (correct position) after the 2nd pass
      Pass 3 : Compare 2 and 1, 2>1 true, swap 2 and 1 ----> {1, 2, 5, 3, 5, 9}
               Compare 2 and 5, 2>5 false, No swap     ----> {1, 2, 5, 3, 5, 9}
               Compare 5 and 3, 5>3 true, swap 5 and 3 ----> {1, 2, 3, 5, 5, 9} 
            The entire array is sorted only in 3 passes, so need to perform the remaining 2 passes (Optimised Bubble Sort)
----------------------------------------------------------------------------------------------------------------------------------------------
    Time and Space Complexity :
            Best Case Time Complexity : O(n) The array is already sorted 
                               outer for loops runs only 1 time and breaks, inner loop runs n times.
            Average Case Time Complexity : O(n*n)
            Worst Case Time Complexity : O(n*n)
            Space Complexity : O(1)  In-place Sort uses no extra space
  -----------------------------------------------------------------------------------------------------------------------------------------
    Key Points to be remembered :
          *  In-place Sorting Algorithm
          *  Stable Sort (maintains the relative order of equal elements)
          *  Simple Algorithm but inefficient for large data sets
  ------------------------------------------------------------------------------------------------------------------------------------
    When to use this ----->
            * Suitable for small arrays
            * When stability matters
            * to find kth largest element without sorting the entire array
            * learning purpose
  ---------------------------------------------------------------------------------------------------------------------------------------------------
      Code :
            int[] arr={5, 2, 9, 1, 5, 3}
            int n=arr.length;
            for(int i=0;i<n-1;i++){
               boolean swap=false;
               for(int j=0;j<n-i-1;j++){
                  if (arr[j]>arr[j+1]){
                     int temp=arr[j];
                     arr[j]=arr[j+1];
                     arr[j+1]=temp;
                     swap=true;
                  }
               }
              if (!swap)
                break;
            }
==============================================================================================================================================================
  ### Selection Sort Algorithm
       Definition : Selection Sort is a simple comparison-based sorting Algorithm which Repeatedly finds the minimum element
                 from the unsorted part and places it at the correct position in the sorted part.
  * In each pass the smallest element is placed at the beginning - correct position.
  Algorithm (Steps) - How it works :
         1.  Start with the first element
         2.  Assume the current element as the minimum element.
         3.  Now compare the current element with remaining elements.
         4.  If any element is smaller than the current element, then update minIndex.
         5.  Swap the current element with the minimum element - one pass completed.
         6.  Repeat the same process for the remaining passes. total - (n-1) passes
  --------------------------------------------------------------------------------------------------------------------------------------
  Dry Run Example :
        Array : {5(a), 2, 9, 1, 5(b), 3}
                The size of the array is n=6 so the total number of passes are n-1 i.e., 5 passes
        Pass 1 : i=0, minIndex=0, minElement=5(a)
                 Compare 5(a) with 2, minIndex=1, minElement=2
                 Compare 2 with 9, minIndex=1, minElement=2
                 Compare 2 with 1, minIndex=3, minElement=1
                 Compare 1 with 5(b), minIndex=3, minElement=1
                 Compare 1 with 3, minIndex=3, minElement=1
              swap current element 5(a) with minIndex element 1 ----> {1, 2, 9, 5(a), 5(b), 3}
        Pass 2 : i=1, minIndex=1, minElement = 2
                  Compare 2 and 9, minIndex=1, minElement=2
                  Compare 2 and 5(a), minIndex=1, minElement=2
                  Compare 2 and 5(b), minIndex=1, minElement=2
                  Compare 2 and 3, minIndex=1, minElement=2
              No swap, 2 is at the correct position only ---> {1, 2, 9, 5(a), 5(b), 3}
       Pass 3 : i=2, minIndex=2, minElement=9
                  Compare 9 and 5(a), minIndex=3, minElement=5(a)
                  Compare 5(a) and 5(b), minIndex=3, minElement=5(a)
                  Compare 5(a) and 3, minIndex=5, minElement=3
              i!=minIndex swap 9 and 3 ----> {1, 2, 3, 5(a), 5(b), 9}
       Pass 4 : i=3, minIndex=3, minElement=5(a)
                  Compare 5(a) and 5(b), no change, minIndex=3, minElement=5(a)
                  Compare 5(a) and 9, no change, minIndex=3, minElement=5(a)
       Pass 5 : i=4, minIndex=4, minElement=5(b)
                  Compare 5(b) and 9, no change, minIndex=4, minElement=5(b)
         {1, 2, 9, 5(a), 5(b), 3} The array is sorted, here the order of equal elements is not changed, 
                             but there are many such cases where the relative can be changed.
---------------------------------------------------------------------------------------------------------------------------------------------
    Time and Space Complexity :
               Best Case Time Complexity : O(n*n)
               Average Case Time Complexity : O(n*n)
               Worst Case Time Complexity : O(n*n)
               Space Complexity : O(1)
-----------------------------------------------------------------------------------------------------------------------------------------------------------
    Key Points to be remembered :
         *  In-place Sorting Algorithm
         *  Unstable (may change the relative order of equal elements)
         *  Simple but inefficient for large data sets
         *  Cannot Optimize like Bubble Sort, in best case eventhough the array is already sorted
                   insertion sort takes O(n*n) in best case also
         *  Fewer/less swaps than Bubble Sort
------------------------------------------------------------------------------------------------------------------------------------------------------------
  When to use ----->
         *  to find the kth smallest element without sorting the entire array
         *  when swap count needs to be minimised
  -----------------------------------------------------------------------------------------------------------------------------------------------------
  Code :
             int[] arr={5, 2, 9, 1, 5, 3}
             int n=arr.length;
             for(int i=0;i<n-1;i++){
                 int minIndex=i;
                 for(int j=i+1;j<n;j++){
                     if (arr[j]<arr[minIndex])
                         minIndex=j;
                 }
               if (minIndex!=i){
                 int temp=arr[minIndex];
                 arr[minIndex]=arr[i];
                 arr[i]=temp;
               }
             }
====================================================================================================================================================
               
                  
      
            
    
            
  
