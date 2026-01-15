// Remove Duplicates from the sorted Array - In-Place
Given an integer array nums sorted in non-decreasing order,
  remove duplicates in-place such that each unique element appears only once. 
  The relative order of the elements should be kept the same.
  Return the number of unique elements.
  The first k elements of nums should contain the unique numbers in sorted order.
  The remaining elements beyond index k - 1 can be ignored.
  Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 -------------------------------------------------------------------------------------------------------------------- 
  Bruteforce Approach :
       * We need to get the unique elements first - so use Set Data Structure
       * Traverse through the entire array and put all the elements into the set - contains unique elements.
       * Now insert all the elements present in the set into the array using an index pointer
          which keeps the track of number of unique elements.
       * Use LinkedHashSet to maintain the relative order of unique elements.
       Time Complexity : O(n) + O(n) = O(2n)
                   --- i'm inserting all the n elements into the set so - O(n)
                   --- pushing back k unique elements into the array so O(K)
                         if all the n elements are unique so - O(n)
       Space Complexity : O(n)

                import java.util.*;
                public class Main {
                    public static void main(String[] args){
                        Scanner sc = new Scanner(System.in);
                        int[] arr={1,2,2,3,4,4,5,6};
                        int n=arr.length;
                        LinkedHashSet<Integer> set = new LinkedHashSet<>();
                        for(int i=0;i<n;i++){
                           set.add(arr[i]);
                        }
                        int index=0;
                        for(int num: set){
                           arr[index++] = num;
                        }
                       System.out.print(index);
                    }
                }
-----------------------------------------------------------------------------------------------------------------

  Optimised Approach :  In-Place Movement
           * Use two pointers approach
           Time Complexity : O(n)
           Space Complexity : O(1)
                import java.util.*;
                public class Main {
                    public static void main(String[] args){
                        Scanner sc = new Scanner(System.in);
                        int[] arr={1,2,2,3,4,4,5,6};
                        int n=arr.length;
                        int i=0;
                      for(int j=1;j<n;j++){
                         if (arr[j]!=arr[i]){
                            arr[i+1]=arr[j];
                            i++;
                         }
                      }
                      System.out.print(i+1);
                    }
                }
            

  
                        

  
