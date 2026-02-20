Reverse a string with spaces intact

Given a string, your task is to reverse the string keeping the spaces intact to their positions.

Example 1:

Input:
S = "Help others"
Output: sreh topleH
Explanation: The space is intact at index 4
while all other characters are reversed.
Example 2:

Input: 
S = "geeksforgeeks"
Output: skeegrofskeeg
Explanation: No space present, hence the
entire string is reversed.

  Bruteforce Approach: 
     class Solution {
    String reverseWithSpacesIntact(String S) {
        // your code here
        StringBuilder sb=new StringBuilder();
        for(int i=S.length()-1;i>=0;i--){
            if (S.charAt(i)!=' ')
            sb.append(S.charAt(i));
        }
        StringBuilder sb1=new StringBuilder();
        int index=0;
        for(int i=0;i<S.length();i++){
            if (S.charAt(i)!=' '){
                sb1.append(sb.charAt(index));
                index++;
            }
            else{
                sb1.append(" ");
            }
        }
        return sb1.toString();
        
    }
}

Optimsed Approach: Two-pointers(Opposite)
     The idea is to use two pointers pointing at start and end of the string. 
  If character at start or end is space, we move the pointer pointing to the space to the 
  next position and swap only if both pointer point to a character. 
