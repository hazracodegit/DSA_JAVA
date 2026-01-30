### 3Sum Problem
Problem Statement: Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that 
    i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.
Example 1:
   Input: nums = [-1,0,1,2,-1,-4]
   Output: [[-1,-1,2],[-1,0,1]]
   Explanation: 
   nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
   nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
   nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
   The distinct triplets are [-1,0,1] and [-1,-1,2].
   Notice that the order of the output and the order of the triplets does not matter.
  Bruteforce Approach :
      *  Use 3 nested loops and iterate through the array, check for every possible triplet that sum upto 0
      Time Complexity : O(n*n*n) // very slow for large arrays
  Better Approach :
        *  Use the two-pointer technique and find the triplet where the sum is zero.
                ----> Run a for loop and fix the ith element for every ith iteration.
                ----> Now use the two-pointer approach for finding the remaining two elements.
                            where nums[i]+nums[low]+nums[high]==0
        *  Convert the list to the set and all the duplicate triplets will be removed.
        *  Convert the set again back to the list.
         Arrays.sort(nums1);
        List<List<Integer>> lst=new ArrayList<>();
        HashSet<Integer> set=new LinkedHashSet<>();
        
        for(int i=0;i<nums1.length-2;i++){
            int low=i+1;int high=nums1.length-1;
            while(low<high){
                int sum=nums1[i]+nums1[low]+nums1[high];
                if (nums1[i]+nums1[low]+nums1[high]==0){
                    lst.add(Arrays.asList(nums1[i],nums1[low],nums1[high]));
                    low++;high--;
                }
                else if (sum>0)
                high--;
                else
                low++;
            }
        }
        Set<List<Integer>> unique = new HashSet<>(lst);
        List<List<Integer>> result = new ArrayList<>(unique);

        return result;
}
Time Complexity: O(n*n)
Space Complexity : O(n*n)
--------------------------------------------------------------------------------------------------------
