### Remove all Adjacent Duplicates from a String
Problem Statement : You are given a string s consisting of lowercase English letters.
  A duplicate removal consists of choosing two adjacent and equal letters and removing them.
We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
  Example :
  Input: s = "abbaca"
  Output: "ca"
  Input: s = "azxxzy"
  Output: "ay"
  Why we need to use Stack:
     *  Because Adjacent Duplicates follow the LIFO order.
           When a duplicate is removed, the new adjacency is created with the previous character.
  Time Complexity : O(n)
  Space Complexity : O(n)
  Algorithm (In Steps):
        *  Start iterating into the string using a for loop.
        *  If the current character is equal to the top of the stack.
               ----> then pop the character from the stack.
        *  If the current character is not equal to the top of the stack.
               ----> then push the current character into the stack.
  Using Stack:
                      public String removeDuplicates(String s) {
                      Stack<Character> stack=new Stack<>();
                      for(char ch:s.toCharArray()){
                         if ((!stack.isEmpty())&&(stack.peek()==ch)){
                              stack.pop();
                           }
                          else{
                               stack.push(ch);
                          }
                       }
                     StringBuilder sb=new StringBuilder();
                           for(char ch:stack){
                             sb.append(ch);
                           }
                      return sb.toString();        
                    }
