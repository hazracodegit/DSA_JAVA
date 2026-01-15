You are given an array and you have to left rotate the array specified by K number of positions.
    Example : 
        array = {1, 2, 3, 4, 5, 6, 7}
        K = 3
      Left rotate array by 1 position : {2, 3, 4, 5, 6, 7, 1}
      Left rotate array by 1 position : {3, 4, 5, 6, 7, 1, 2}
      Left rotate array by 1 position : {4, 5, 6, 7, 1, 2, 3}
   The size of the above array is 7
       When we rotate an array either left or right with number of positions equal to the length of the array.
       we will get the same array again.
       so basically 7 rotations = Original array
                    8 rotations = Original array(7 rotations) + 1 rotation
        *  so use k=k%n
    While performing left rotation - negative k indicates right rotation
       if k is -ve do right rotation or convert -ve k equivalent to left rotation by doing k=k+n
       ------------------------------------------------------------------------------------------------
 Bruteforce Approach :
      * Store the 1st element in a temporary variable.
      * Now run a loop and move all the array elements one position to the left.
      * Now insert the stored element at the last position.
      * Now repeat the above process for K number of times.
      Time Complexity : O(n*K)
      Space Complexity : O(1)
             // Left Rotation
              import java.util.*;
              public class Main {
                 public static void main(String[] args){
                     Scanner sc = new Scanner(System.in);
                     int[] arr={1,2,3,4,5,6,7};
                     int k=3;
                     for(int i=0;i<k;i++){
                        int first=arr[0];
                        for(int i=1;i<n;i++){
                          arr[i-1]=arr[i];
                        }
                       arr[n-1]=first;
                     }
                   System.out.print(Arrays.toString(arr));
                 }
              }
--------------------------------------------------------------------------------------------------------

  Optimised Approach : Reversal Algorithm
       * Reverse the first k elements - {3,2,1,4,5,6,7}
       * Reverse the remaining n-k elements - {3,2,1,7,6,5,4}
       * Reverse the entire array - {4,5,6,7,1,2,3}
       Time Complexity : O(k) + O(n-k) + O(n) = O(2n) = O(n)
       Space Complexity : O(1)
                // Left Rotation
              import java.util.*;
              public class Main {
                static void reverse(int[] arr, int start, int end){
                  while(start<end){
                    int temp=arr[start];
                    arr[start]=arr[end];
                    arr[end]=arr[start];
                    start++;
                    end--;
                  }
                }
                 public static void main(String[] args){
                     Scanner sc = new Scanner(System.in);
                     int[] arr={1,2,3,4,5,6,7};
                     int k=3;
                     reverse(arr,0,k-1);
                     reverse(arr,k,n-1);
                     reverse(arr,0,n-1);
                     System.out.print(Arrays.toString(arr));
                 }
              }
                     
             
      
