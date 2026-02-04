Given an integer array arr, return all the unique pairs [arr[i], arr[j]] 
such that i != j and arr[i] + arr[j] == 0.

Note: The pairs must be returned in sorted order, the solution array should also be sorted, 
  and the answer must not contain any duplicate pairs.
  Input: arr = [-1, 0, 1, 2, -1, -4]
Output: [[-1, 1]]
Explanation: arr[0] + arr[2] = (-1)+ 1 = 0.
arr[2] + arr[4] = 1 + (-1) = 0.
The distinct pair are [-1,1].

  Optimised Approach using HashMap :
       // User function Template for Java
import java.util.HashMap;
import java.util.*;
class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> lst=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int diff=0;int target=0;
        for(int i=0;i<arr.length;i++){
            diff=target-arr[i];
            if (!map.containsKey(diff)){
                map.put(arr[i],i);
            }
            else{
                ArrayList<Integer> list=new ArrayList<>();
                if (arr[i]>diff){
                    list.add(diff);
                    list.add(arr[i]);
                    lst.add(list);
                }
                else{
                    list.add(arr[i]);
                    list.add(diff);
                    lst.add(list);
                }
            }
        }
        Set<List<Integer>> set=new HashSet<>(lst);
        List<List<Integer>> list=new ArrayList<>(set);
       

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (List<Integer> inner : list) {
        result.add(new ArrayList<>(inner));
        }
        Collections.sort(result, (a, b) -> a.get(0) - b.get(0));


        return result;
        
    }
}
Time Complexity : O(n logn)
Space Complexity : O(n)
