### Balanced Paranthesis Checker
  Problem Statement: A String will be given which contains only opening and closing brackets. Return true if it follows the
     rules of Balanced Paranthesis Checker.
  Conditions for Balanced Paranthesis:
         *  Every closing bracket should have opening bracket
         *  Every opening bracket should have closing bracket
         *  Order of the brackets must be maintained
  Example : String : (){()[]}
        Output : true
  Example : String : ([]{}([)]
        Output : false


                           
                           
                           
                           
                           
import java.util.Stack;

public class BalancedParenthesis {

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // If opening bracket → push
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // If closing bracket
            else {
                // Stack empty → no matching opening
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check matching pair
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack empty → balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[()]}";
        System.out.println(isBalanced(s)); // true
    }
}
