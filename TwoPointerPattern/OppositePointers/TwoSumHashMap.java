import java.util.HashMap;
public class Main
{
	public static void main(String[] args) {
		int[] arr={2,6,5,8,11};
		int target=14;
		HashMap<Integer,Integer> map=new HashMap<>();
		int diff=0;
		for(int i=0;i<arr.length;i++){
		    diff=target-arr[i];
		    if (!map.containsKey(diff)){
		        map.put(arr[i],i);
		    }
		    else{
		        System.out.println(i+" "+map.get(diff));
		        break;
		    }
		    
		}
		
	}
}
