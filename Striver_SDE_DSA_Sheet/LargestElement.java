 ### Largest Element is the Maximum element present in the array.
  Example:   
Array: 5, 12, 3, 9, 7
  Largest element = 12
Bruteforce Approach :
    Sort the given Array and return arr[n-1] -----> largest element
    Time Complexity: O(n logn) ----> Any sorting Algorithm takes Maximum of (nlog n) time
    Space Complexity: O(1)
      /*  import java.util.Arrays;
          import java.util.Scanner;
          public class Main {
              public static void main(String[] args){
                  Scanner sc=new Scanner(System.in);
                  System.out.print("Enter the size of the Array");
                  int n = sc.nextInt();
                  int[] arr = new int[n];
                  System.out.print("Enter the Array elements:");
                  for(int i=0;i<n;i++){
                     arr[i] = sc.nextInt();
                  }
                 Arrays.sort(arr);
                 System.out.print("Largest Element: "+ arr[n-1]);
              }
          }
      */
  Optimised Approach :
      * Assume first element as the largest element.
      * Traverse through the entire array and compare every element with the largest element.
             if current element > largest then update
             else continue
      * Repeat the same process till the end of the array is reached.
      Time Complexity : O(n)
      Space Complexity : O(1)
         /*      import java.util.*;
                 public class Main {
                     public static void main(String[] args){
                         Scanner sc=new Scanner(System.in);
                         System.out.print("Enter the size of the Array");
                        int n = sc.nextInt();
                        int[] arr = new int[n];
                        System.out.print("Enter the Array elements:");
                        for(int i=0;i<n;i++){
                         arr[i] = sc.nextInt();
                        }
                       int largest = arr[0];
                       for(int i=0;i<n;i++){
                         if (arr[i]>largest)
                           largest = arr[i];
                       }
                       System.out.print("Largest Element: "+ largest);
                     }
                 }
         */
                         
                   
