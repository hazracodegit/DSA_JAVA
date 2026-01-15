### Second Largest Element in the array
  Example :
      Array : {10, 30, 2, 5, 3}
      secondLargest = 10
        Bruteforce Approach : 
            * Sort the given array in Ascending Order.
            *  Traverse the array from last and return the element if (arr[i] != largest)
            Time Complexity : O(n logn) + O(n)
            Space Complexity : O(1)
            /*     // finding the second largest element in the array
                   import java.util.*;
                   public class Main {
                      public static void main(String[] args){
                          Scanner sc = new Scanner(System.in);
                          System.out.print("Enter the size of the array");
                          int n = sc.nextInt();
                          int[] arr = new int[n];
                          System.out.print("Enter the array elements: ");
                          for(int i=0;i<n;i++){
                            arr[i] = sc.nextInt();
                          }
                         Arrays.sort(arr);
                         int largest=arr[n-1];
                         int second=Integer.MIN_VALUE;
                         for(int i=n-1;i>=0;i--){
                           if (arr[i]!=largest){
                             second=arr[i];
                             break;
                           }
                         }
                        System.out.print("Second Largest Element: "+ second);
                      }
                   }
              */
        Better Approach : 
              *  Use 2 for loops to find the second largest element.
              *  Using for loop in the first pass find the largest element.
              *  Using the 2nd for loop in the second pass return second largest element if (arr[i]>second && arr[i] != largest)
              Time Complexity : O(n) + O(n) = O(2n)
              Space Complexity : O(1)
              /*          // finding the second largest element
                          import java.util.*;
                          public class Main {
                              public static void main(String[] args){
                                  Scanner sc = new Scanner(System.in);
                                  System.out.print("Enter the size of the array");
                                  int n = sc.nextInt();
                                  int[] arr = new int[n];
                                  System.out.print("Enter the array elements: ");
                                  for(int i=0;i<n;i++){
                                  arr[i] = sc.nextInt();
                                  }
                                  // first pass - finding the largest element
                                  int largest = arr[0];
                                  for(int i=0;i<n;i++){
                                     if (arr[i]>largest)
                                        largest = arr[i];
                                  }
                                 // second pass - finding the second largest element
                                 int second = Integer.MIN_VALUE; // safe - if the array contains negative elements
                                 for(int i=0;i<n;i++){
                                   if (arr[i]>second && arr[i]!=largest)
                                      second = arr[i];
                                 }
                                System.out.print("Second Largest Element: "+ second);
                              }
                          }
             */
        Optimised Approach : 
                   * Only in one pass find the both largest and second largest element.
                   Time Complexity : O(n)
                   Space Complexity : O(1)
                    /*       // finding the largest and second largest element
                            
                                  int second = Integer.M import java.util.*;
                             public class Main {
                              public static void main(String[] args){
                                  Scanner sc = new Scanner(System.in);
                                  System.out.print("Enter the size of the array");
                                  int n = sc.nextInt();
                                  int[] arr = new int[n];
                                  System.out.print("Enter the array elements: ");
                                  for(int i=0;i<n;i++){
                                  arr[i] = sc.nextInt();
                                  }
                                  int largest = arr[0];IN_VALUE;
                                  for(int i=0;i<n;i++){
                                     if (arr[i]>largest){
                                       second = largest;
                                       largest = arr[i];
                                     }
                                  }
                                System.out.print("Second Largest Element: "+ second);
                              }
                             }
                      */
                                
        
