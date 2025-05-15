// tcs interview question-1
public class Main {
    public static void main(String[] args) {
        int[] arr={1,0,1,0,1,0};
        int[] arr1=new int[arr.length];
        int count=0;
        int count1=0;
        int index=0;
        for(int i=0;i<arr.length;i++){
            if (arr[i]==0)
            count=count+1;
            else
            count1=count1+1;
        }
        for(int i=0;i<arr.length;i++){

            arr1[i]=0;
            count--;
            if (count==0){
                index=i;
            break;}
        }
        for(int i=index+1;i<arr.length;i++){
            arr1[i]=1;
            count1--;
            if (count1==0)
            break;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr1[i]+" ");
        }
        
        

        

    }

}
