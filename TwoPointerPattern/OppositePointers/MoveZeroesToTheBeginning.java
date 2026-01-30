### Move zeroes to the beginning
  Example: array = {0,1,2,0,3,0,4,5,0}
  Output: {0,0,0,0,1,2,3,4,5}
Bruteforce Approach : Using an extra space
       public static int[] moveZeroesToBeginning(int[] nums) {
      int n = nums.length;
    int[] temp = new int[n];
    int index = 0;
    // Step 1: count zeroes
    for (int i = 0; i < n; i++) {
        if (nums[i] == 0) {
            temp[index++] = 0;
        }
    }
    // Step 2: add non-zero elements
    for (int i = 0; i < n; i++) {
        if (nums[i] != 0) {
            temp[index++] = nums[i];
        }
    }

    return temp;
}

Time Complexity : O(2*n)
Space Complexity : O(n)
Optimised Approach : Inplace-modification
     public static void main(String[] args) {
	int[] arr={1,2,0,0,0,4,0,1,0,5,0};
	int index=arr.length-1;
	for(int i=arr.length-1;i>=0;i--){
	    if (arr[i]!=0){
	        arr[index--]=arr[i];
	    }
	}
	for(int i=index;i>=0;i--){
	    arr[index--]=0;
	}
	System.out.print(Arrays.toString(arr));
	}
Time Complexity : O(2*n)
Space Complexity : O(1)
