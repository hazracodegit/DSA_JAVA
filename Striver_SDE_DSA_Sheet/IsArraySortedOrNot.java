### Check if the array is sorted or not (Basically in non - descending order)
  This is a straight forward problem, there is no bruteforce or better approach for this question.
  Consider the array containing duplicates also.
  Time Complexity : O(n)
  Space Complexity : O(1)
      Example :
         array = {1,2,2,3,4,5}
           return true
         array = {1,3,3,2,4,5}
           return false
         import java.util.*;
         public class Main {
             public static void main(String[] args){
                 Scanner sc = new Scanner(System.in);
                 System.out.print("Enter the size of the array: ");
                 int n = sc.nextInt();
                 int[] arr = new int[n];
                 System.out.print("Enter the array elements: ");
                 for(int i=0;i<n;i++){
                    arr[i] = sc.nextInt();
                 }
                 boolean isSorted = true;
                 for(int i=0;i<n-1;i++){
                    if (arr[i]>arr[i+1]){
                       isSorted = false;
                       break;
                    }
                 }
               System.out.print(isSorted);
             }
         }
