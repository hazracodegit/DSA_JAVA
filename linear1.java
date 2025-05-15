package DSA;
// linear search using recursion
public class linear1 {
    public static void main(String[] args){
        int[] arr={10,20,30,40,50};
        int target=50;
        int index=0;
        int result=linearSearch(arr,target,index);
        if (result!=-1)
        System.out.println("element found at index: "+result);
    }
    public static int linearSearch(int arr[],int target,int index){
        if (index >=arr.length){
        return -1;}
        if (arr[index]==target){
            return index;}
            else
            return linearSearch(arr, target,index+1);
    }
}
/*linear search using recursion is ineffective due to stack overflow (function calls) but having awareness how to implement linear search is important */
