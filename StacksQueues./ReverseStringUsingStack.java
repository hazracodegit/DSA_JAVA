import java.util.Stack;

public class ReverseStringUsingStack
{
	public static void main(String[] args){
		Stack<Character> stack = new Stack<>();
		String str = "hello";
		for(int i=0;i<str.length();i++){
			stack.push(str.charAt(i));
		}
		while(!stack.isEmpty()){
			System.out.println(stack.peek());
			stack.pop();
		}
	}
}