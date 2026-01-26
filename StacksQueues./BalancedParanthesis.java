### Balanced Paranthesis Checker
  Problem Statement: A String will be given which contains only opening and closing brackets. Return true if it follows the
     rules of Balanced Paranthesis Checker.
  Conditions for Balanced Paranthesis:
         *  Every closing bracket should have opening bracket
         *  Every opening bracket should have closing bracket
         *  Order of the brackets must be maintained
  Why should we use Stack Data Structure to solve this Problem:
         *  Because here the brackets are following the LIFO Order- i.e. the bracket which is recently opened or 
            lastly opened is the first one to be to be closed. So Hence we are using Stack.
         *  And the bracket which is first opened is the one which is closed at last.
  Example : String : (){()[]}
        Output : true
  Example : String : ([]{}([)]
        Output : false
  Algorithm (In Steps) :
        *   Push opening brackets ( { [ onto the stack
        *   When a closing bracket appears:
               ----> Stack must not be empty
               ----> Top of stack must match the closing bracket
               ----> If not → invalid
        *   At the end:
               ----> Stack must be empty → valid
               ----> Not empty → Invalid
                           
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
