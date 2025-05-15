// two sum problem-brute force approach 
package DSA.arrays;

public class arrays1 {
    public static void main(String[] args) {
        int[] arr={10,40,30,50,20};
        int target=90;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if (arr[i]+arr[j]==target){
                    System.out.printf("[%d,%d]",i,j);
                }
            }
        }
    }
    
}
