package DSA.arrays;

public class Remove_duplicate {
    public static void main(String[] args){
        int[] arr={2,2,3,3,4,6,6};
        int[] arr1=new int[arr.length];
        arr1[0]=arr[0];
        int low=1,high=0;
        for(int i=1;i<arr.length;i++){
            if (arr1[high]!=arr[i]){
            high++;
            arr1[high]=arr[i];
            low++;
        }

        }
        for(int i=0;i<low;i++)
        System.out.print(arr1[i]+" ");
    }
    
    
}
