package DSA;

public class arrays2 {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50};
        int target=90;
        int low=0,high=arr.length-1;
        while(low<high){
            if ((arr[low]+arr[high])==target){
                System.out.printf("[%d,%d]",low,high);
                break;
            }
            else if (target>(arr[low]+arr[high]))
            low=low+1;
            else
            high=high-1;
        }
    }
}
